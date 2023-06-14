package Aigo.Longest.Palindrome;

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
public class LongestPalindromeV1 extends LongestPalindromeSuper {
    //全遍历查询
    public String longestPalindrome(String s) {
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
    /**
     *
     * @param temp
     * @return
     */
    private boolean judgePalindrome(String temp) {
        for(int i = 0 ; i < temp.length() ; i++){
            if(temp.charAt(i) != temp.charAt(temp.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        LongestPalindromeV1 longestPalindrome = new LongestPalindromeV1();
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
       String str =longestPalindrome.longestPalindrome(s);
//        String str = longestPalindrome3(s);
        System.out.println(str);
    }
}
