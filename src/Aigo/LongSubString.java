package Aigo;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * @Author Administrator
 * @Date 2023/3/8 19:11
 * @Version 1.0.0
 */
public class LongSubString {
    //全遍历
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
             return 0;
        }
        Set<Character> set = new HashSet<>();
        int length = 0;
        for(int k = 0 ; k < s.length() ; k++){
            for(int i = k ; i < s.length() ; i++){
                char c = s.charAt(i);
                if(set.contains(c)){
                    length = set.size() > length ? set.size() : length;
                    set.clear();
                    break;
                }else{
                    set.add(c);
                }
            }
            if(s.length()-k < length){
                break;
            }
        }
        return set.size() > length ? set.size() : length;
    }

    /**
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if(s.length() < 2){
            return s.length();
        }
        char[]ch = s.toCharArray();
        int  p = 0;
        int q = ch.length - 1;
        Set<Character>set = new HashSet<>();
        //TODO 减少一重循环，但是结果不对
        while(p <= q){
          if(!set.contains(ch[p])){
            set.add(ch[p]);
          }
          if(ch[p]==ch[q]){
             q--;
          }else{
              p++;
          }

        }
        return set.size();
    }
    public static void main(String[] args) {
        //3  abc
//        String s = "abcabcbb";
        //1  b
//        String s = "bbbb";
        //3 kew
        String s = "pwwkew";
        //1
//        String s = " ";
        //
//        String s = "au";
//        int length = lengthOfLongestSubstring(s);
        int length = lengthOfLongestSubstring2(s);
        System.out.println(length);
    }
}
