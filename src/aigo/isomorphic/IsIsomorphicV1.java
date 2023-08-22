package aigo.isomorphic;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description https://leetcode.cn/problems/isomorphic-strings
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 输入：s = "paper", t = "title"
 * 输出：true
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s和t由任意有效的 ASCII 字符组成
 * @Author Administrator
 * @Date 2023/7/3 9:27
 * @Version 1.0.0
 */
public class IsIsomorphicV1 extends IsIsomorphicSuper {
    @Override
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> sTotMap = new HashMap<>();
        Map<Character,Character> tTosMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if (sTotMap.containsKey(sch) && (sTotMap.get(sch) != tch)){
                return false;
            }
            if(tTosMap.containsKey(tch) && (tTosMap.get(tch) != sch)){
                return false;
            }
            sTotMap.put(sch,tch);
            tTosMap.put(tch,sch);
        }
        return true;
    }

    public static void main(String[] args) {
       //true
//        String s = "egg";
//        String t = "add";
        //false
//        String s = "foo";
//        String t = "bar";
        //true
//        String s = "paper";
//        String t = "title";
        //false
        String s = "badc";
        String t = "baba";
        IsIsomorphicV1 isIsomorphicV1= new IsIsomorphicV1();
        boolean flag = isIsomorphicV1.isIsomorphic(s,t);
        System.out.println(flag);
    }
}
