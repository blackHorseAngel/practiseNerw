package Aigo;

/**
 * @Description https://leetcode.cn/problems/longest-palindromic-substring/
 * 给你一个字符串 s，找到 s 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 输入：s = "cbbd"
 * 输出："bb"
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * @Author Administrator
 * @Date 2023/3/9 13:47
 * @Version 1.0.0
 */
public class LongestPalindrome {
    //全遍历查询
    public static String longestPalindrome(String s) {
        String temp = "";
        String palindrome = "";
        int longLength = 0;
        boolean flag = true;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = s.length(); j >= i ; j--){
                temp = s.substring(i,j);
                if(temp.length() == 0){
                    continue;
                }
                int length = temp.length();
                flag = judgePalindrome(temp);
                if(flag){
                    if(length > longLength){
                        longLength = length;
                        palindrome = temp;
                    }
                }
            }
        }
        return palindrome;
    }

    private static boolean judgePalindrome(String temp) {
        for(int i = 0 ; i < temp.length() ; i++){
            if(temp.charAt(i) != temp.charAt(temp.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划处理
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s){
        String longestPalindrome = "";
        if(s.length() < 2){
            return s;
        }
        String temp = "";
        int length = 0;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i + 1 ; j <= s.length() ; j++){
                temp = s.substring(i,j);
                boolean flag = judgePalindrome(temp);
                if(flag){
                    if(length < temp.length()){
                        length = Math.max(length,temp.length());
                        longestPalindrome = temp;
                    }

                }
            }
            if(length == s.length()){
                break;
            }
        }
        return longestPalindrome;
    }
    public static void main(String[] args) {
        //bab或aba
//        String s = "babad";
        //bb
//        String s = "cbbd";
        //
//        String s = "";
        //a
//        String s = "a";
        //bb
//        String s = "bb";
        //
        String s ="1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        System.out.println(s.length());
//       String str = longestPalindrome(s);
        String str = longestPalindrome3(s);
        System.out.println(str);
    }
}
