package exercise.滑动窗口法;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 无重复字符最长子串 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int t = lengthOfLongestSubstring1(s);
        System.out.println(t);
    }
    //滑动窗口法（使用经典方法）
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int l = 0;
        int len = 0;
        int lenNow = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                lenNow = i - l + 1;
            }else{
                while(s.charAt(l) != s.charAt(i)){
                    set.remove(s.charAt(l));
                    l++;
                }
                l += 1;
                lenNow = i - l + 1;
            }
            len = Math.max(len, lenNow);
        }
        return len;
    }
    //使用map来存储
    public static int lengthOfLongestSubstring1(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                l = Math.max(l, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            len = Math.max(len, i - l + 1);
        }
        return len;
    }





}
