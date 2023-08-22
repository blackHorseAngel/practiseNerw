package aigo.palindrome.Number;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 13:39
 * @Version 1.0.0
 */
public class PalindromeNumberV2 extends PalindromeNumberSuper{
    //字符串判断
    public boolean isPalindrome(int x){
        String s = String.valueOf(x);
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromeNumberV2 palindromeNumberV2 = new PalindromeNumberV2();
        boolean flag = palindromeNumberV2.isPalindrome(-121);
        System.out.println(flag);
    }
}
