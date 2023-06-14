package Aigo.Subsequence;

/**
 * @Description https://leetcode.cn/problems/is-subsequence
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 * @Author Administrator
 * @Date 2023/5/19 16:15
 * @Version 1.0.0
 */
public class IsSubsequence extends SubsequenseSuper {
    /**
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int p = 0;
        int q = 0;
        while(p < s.length() && q < t.length()){
            if(s.charAt(p) == t.charAt(q)){
                p++;
                q++;
            }else{
                q++;
            }
        }
        if(p < s.length()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //true
//        String s1 = "abc";
//        String t1 = "ahbgdc";
//        boolean flag1 = subsequence.isSubsequence(s1,t1);
//        System.out.println(flag1);
        String s2 = "axc";
        String t2 = "ahbgdc";
        IsSubsequence subsequence = new IsSubsequence();
        boolean flag2 = subsequence.isSubsequence(s2,t2);
        System.out.println(flag2);
    }
}
