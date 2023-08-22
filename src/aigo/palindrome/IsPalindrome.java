package aigo.palindrome;

/**
 * @Description https://leetcode.cn/problems/valid-palindrome
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 *输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * @Author Administrator
 * @Date 2023/5/18 23:53
 * @Version 1.0.0
 */
public class IsPalindrome extends PalindromeSuper {
    /**
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        String regex = "[a-z0-9]";
        s = s.toLowerCase().replaceAll(regex,"").trim();
        if(s.length() == 0){
            return true;
        }
        int p = 0;
        int q = s.length() - 1;
        while (p < q){
            if(s.charAt(p) != s.charAt(q)){
                return false;
            }else{
                p++;
                q--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome palindrome = new IsPalindrome();
        //true
        String s1 = "A man, a plan, a canal: Panama";
        //false
        String s2 = "race a car";
        //true
        String s3 = " ";
        //true
        String s4 = "aa";
        //true
        String s5 = "0P";
//        boolean flag1 = isPalindrome(s1);
//        System.out.println(flag1);
//        boolean flag2 = isPalindrome(s2);
//        System.out.println(flag2);
//        boolean flag3 = isPalindrome(s3);
//        System.out.println(flag3);
//        boolean flag4 = isPalindrome(s4);
//        System.out.println(flag4);
        boolean flag5 = palindrome.isPalindrome(s5);
        System.out.println(flag5);
    }
}
