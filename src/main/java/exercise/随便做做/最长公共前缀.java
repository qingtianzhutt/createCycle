package exercise.随便做做;

public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] s = {"123","12344defs"};
        String t = "123456";
        System.out.println(t.substring(0, 1));
        System.out.println(longestCommonPrefix(s));

    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0)return "";
        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            res = combine(res, strs[i]);
        }
        return res;
    }
    public static String combine(String res, String str){
        int i = 0;
        while(i < res.length() && i < str.length()){
            if (res.charAt(i) != str.charAt(i)) {
                break;
            }
        }
        return res.substring(0, i);
    }
}
