package Aigo.Find.Unique.Char;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * 输入: s = "leetcode"
 * 输出: 0
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 输入: s = "aabb"
 * 输出: -1
 * 1 <= s.length <= 105
 * s 只包含小写字母
 * @Author Administrator
 * @Date 2023/3/3 12:15
 * @Version 1.0.0
 */
public class FirstUniqueCharV1 extends FindUniqueCharSuper {
    //双指针查找
    public int firstUniqChar(String s) {
        Set<Character>set = new HashSet<>();
        for(int i = 0; i < s.length() ; i++){
            boolean flag = true;
            char c1 = s.charAt(i);
            if(set.contains(c1)){
                continue;
            }
            for(int j = i + 1 ; j < s.length() ; j++){
                char c2 = s.charAt(j);
                if(c1 == c2){
                    flag = false;
                    set.add(c1);
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //0
//        String s = "leetcode";
        //2
        String s = "loveleetcode";
        //-1
//        String s = "aabb";
        FirstUniqueCharV1 firstUniqueCharV1 = new FirstUniqueCharV1();
        int index = firstUniqueCharV1.firstUniqChar(s);
        System.out.println(index);
    }
}
