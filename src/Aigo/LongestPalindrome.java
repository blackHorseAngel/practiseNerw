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
    //中心延展遍历
    public static String longestPalindrome2(String s) {
        int start = 0;
        int length = s.length();
        int end = s.length() -1;
        String palindrome = "";
        //如果字符串的长度是1，直接返回
        if(length == 1){
            return s;
        }

        if (length % 2 == 0) {
            //TODO 查找中间的两个字符串
            int mid =  binaryFind(start,end);
            while((mid >= 0) && (mid < length)){
                if((s.charAt(mid-1)) == s.charAt(mid+1)){
                    palindrome = s.substring(mid-1,mid+1+1);
                }
            }
        }else{
            //TODO 查找中间的一个字符串
        }
        //如果字符串的长度是
        return palindrome;
    }

    private static int binaryFind(int start, int end) {
        int mid = (end - start)/2 + start;

        return mid;
    }

    private static boolean judgePalindrome(String temp) {
        for(int i = 0 ; i < temp.length() ; i++){
            if(temp.charAt(i) != temp.charAt(temp.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //bab或aba
        String s = "babad";
        //bb
//        String s = "cbbd";
        //
//        String s = "";
        String str = longestPalindrome(s);
        System.out.println(str);
    }
}
