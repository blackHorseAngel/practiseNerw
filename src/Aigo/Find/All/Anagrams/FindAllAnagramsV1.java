package Aigo.Find.All.Anagrams;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 *  @Author Administrator
 * @Date 2023/3/3 18:35
 * @Version 1.0.0
 */
public class FindAllAnagramsV1 extends FindAllAnagramsSuper {
    /**
     *
     * @param s
     * @param p
     * @return
     */
    public  List<Integer> findAnagrams(String s, String p) {
        List<Integer>list = new ArrayList<>();
        int[]pcount = new int[26];
        pcount = transferToArray(p,pcount);

        int[]tempCount = new int[26];
        for(int i = 0 ; i <= s.length() - p.length(); i++){
            String temp = s.substring(i,i+p.length());
            if(i > 0){
                temp = temp.substring(temp.length()-1);
            }
            tempCount = transferToArray(temp,tempCount);
            if(checkLetter(pcount,tempCount)){
              list.add(i);
            }
            resetFirst(s.charAt(i),tempCount);
        }
        return list;
    }

    /**
     *  判断字符串s的每个子串和p是否存在异位词关系
     * @param pcount
     * @param tempCount
     * @return
     */

    public  boolean checkLetter(int[]pcount,int[]tempCount){
        for(int i = 0; i < tempCount.length ; i++){
            if(pcount[i] != tempCount[i]){
                 return false;
            }
        }
        return true;
    }

    /**
     * 移除第一个tempCount的第一个元素
     * @param ch
     * @param tempCount
     */
    private void resetFirst(char ch,int[]tempCount) {
       int num = ch - 'a';
       if(tempCount[num] != 0){
         tempCount[num] = tempCount[num] - 1;
       }
    }
    /**
     * 生成26个小写字母字符串数组
     * @param s
     * @param count
     * @return
     */
    public int[]transferToArray(String s,int[]count){
       for(int i = 0 ; i < s.length(); i++){
           int num = s.charAt(i)-'a';
           count[num]++;
       }
       return count;
    }

    public static void main(String[] args) {
        //[0,6]
//        String s = "cbaebabacd";
//        String p = "abc";
        //[0,1,2]
        String s = "abab";
        String p = "ab";
        //

        FindAllAnagramsV1 findAllAnagramsV1 = new FindAllAnagramsV1();
        List<Integer>list = findAllAnagramsV1.findAnagrams(s,p);
        for(int i : list){
            System.out.println(i);
        }
    }
}
