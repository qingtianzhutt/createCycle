package exercise.git.双指针;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//lc524
//返回长度最长且字母序最小
//字典序可以直接用方法compareTo

//排序，可以通过对 dictionary的预处理（将dictionory一句字符串长度的降序和字典序的升序来进行排序，然后从前到后来找到第一个符合条件的字符串来直接返回）
public class 最长子序列 {
    public String findLongestWord1(String s, List<String> dictionary) {
        String res = "";
        for (int i = 0; i < dictionary.size(); i++) {
            if (isContain(dictionary.get(i), s)) {
                res = res.equals("") ? dictionary.get(i) : longerStringAndLittleDict(res, dictionary.get(i));
            }
        }
        return res;

    }
    public Boolean isContain(String s, String source){
        int i = 0,j = 0;
        while(i < s.length() && j < source.length()){
            if (source.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i == s.length();
    }
    public String longerStringAndLittleDict(String s, String source){
        if (s.length() > source.length()) {
            return s;
        }else if (s.length() < source.length()){
            return source;
        }else{
            return littleDict(s, source);
        }
    }
    public String littleDict(String s, String source){
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) > source.charAt(j)){
                return source;
            }else if (s.charAt(j) < source.charAt(j)){
                return s;
            }
        }
        return s;
    }


    //直接通过比较器先进行排序。
    public String findLongestWord2(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            public int compare(String word1, String word2) {
                if (word1.length() != word2.length()) {
                    return word2.length() - word1.length();
                } else {
                    return word1.compareTo(word2);
                }
            }
        });
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                return t;
            }
        }
        return "";
    }

    @Test
    public void compare(){
        List<String> s = Arrays.asList("123", "1234", "1", "12345", "23");
        Collections.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                }else if (o1.length() < o2.length()){
                    return 1;
                }else{
                    return o1.compareTo(o2);
                }
            }
        });
        System.out.println(s);



    }
}
