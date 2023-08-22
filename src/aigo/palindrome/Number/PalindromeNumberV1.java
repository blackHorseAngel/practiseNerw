package aigo.palindrome.Number;

/**
 * @Description https://leetcode.cn/problems/palindrome-number
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * 输入：x = 121
 * 输出：true
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * -231 <= x <= 231 - 1
 * @Author Administrator
 * @Date 2023/3/21 15:32
 * @Version 1.0.0
 */
public class PalindromeNumberV1 extends PalindromeNumberSuper {
    //
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }else if((x > 0) && (x%10 == 0)){
            return false;
        }
        int sum = 0;
        int tempX = x;
        int temp = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while(tempX != 0){
            temp = tempX % 10;
            sum = sum * 10;
            if(tempX > 0){
                if((sum >= max / 10) && (temp > 7)){
                    return false;
                }else{
                    sum = sum + temp;
                }
            }else if(tempX < 0){
                if((sum <= max/10) && (temp < -8)){
                   return false;
                }else{
                    sum = sum + temp;
                }
            }
            tempX = tempX / 10;
        }
        if(x == sum){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
      PalindromeNumberV1 palindromeNumberV1 = new PalindromeNumberV1();
      boolean flag = palindromeNumberV1.isPalindrome(-121);
      System.out.println(flag);
    }
}
