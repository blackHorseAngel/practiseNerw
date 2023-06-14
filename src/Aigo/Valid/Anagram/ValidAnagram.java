package Aigo.Valid.Anagram;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description https://leetcode.cn/problems/valid-anagram
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *  @Author Administrator
 * @Date 2023/3/3 17:55
 * @Version 1.0.0
 */
public class ValidAnagram extends ValidAnagramSuper {
    //
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char sc = s.charAt(i);
            if(smap.containsKey(sc)){
                int svalue = smap.get(sc);
                smap.put(sc,++svalue);
            }else{
                smap.put(sc,1);
            }
        }
        for(int j = 0 ; j < t.length() ; j++){
            char tc = t.charAt(j);
            if(tmap.containsKey(tc)){
                int tvalue = tmap.get(tc);
                tmap.put(tc,++tvalue);
            }else{
                tmap.put(tc,+1);
            }
        }
        for(char c : smap.keySet()){
            if(tmap.containsKey(c)){
                int svalue = smap.get(c);
                int tvalue = tmap.get(c);
                if(svalue != tvalue){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
//        String s = "rat";
//        String t = "car";
        ValidAnagram validAnagram = new ValidAnagram();
        boolean flag = validAnagram.isAnagram(s,t);
        System.out.println(flag);
    }
}
