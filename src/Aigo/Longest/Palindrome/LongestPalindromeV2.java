package Aigo.Longest.Palindrome;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 12:49
 * @Version 1.0.0
 */
public class LongestPalindromeV2 extends LongestPalindromeSuper{
    /**
     * 动态规划处理
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
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
        LongestPalindromeV2 longestPalindromeV2 = new LongestPalindromeV2();
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
        String str =longestPalindromeV2.longestPalindrome(s);
        System.out.println(str);
    }
}
