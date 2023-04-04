package Aigo;

/**
 * @Description https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果needle 不是 haystack 的一部分，则返回 -1 。
 *输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 *  @Author Administrator
 * @Date 2023/3/29 16:08
 * @Version 1.0.0
 */
public class findStrStr {
    //
    public static int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        for(int i = 0 ; i+needleLength <= haystackLength ; i++){
            String s = haystack.substring(i,i+needleLength);
            boolean flag = judgeStr(s,needle);
            if(flag){
                return i;
            }
        }
        return -1;
    }

    private static boolean judgeStr(String s, String needle) {
        boolean flag = true;
        for(int i = 0 ; i < needle.length() ; i++){
            if(s.charAt(i) != needle.charAt(i)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
//        String haystack = "sadbutsad";
//        String needle = "sad";
//        String haystack = "leetcode";
//        String needle= "leeto";
        String haystack = "a";
        String needle = "a";
//        String haystack = "abc";
//        String needle = "c";
        int num = strStr(haystack,needle);
        System.out.println(num);
    }
}
