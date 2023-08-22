package aigo.find.Unique.Char;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 9:42
 * @Version 1.0.0
 */
public class FirstUniqueCharV2 extends FindUniqueCharSuper{
    //小写字母集遍历
    public int firstUniqChar(String s){
        int result = -1;
        for(char c = 'a' ; c <= 'z' ; c++){
            int index = s.indexOf(c);
            if((index != -1) && (index == s.lastIndexOf(c))){
                result = index;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        //0
//        String s = "leetcode";
        //2
        String s = "loveleetcode";
        //-1
//        String s = "aabb";
        FirstUniqueCharV2 firstUniqueCharV2 = new FirstUniqueCharV2();
        int index = firstUniqueCharV2.firstUniqChar(s);
        System.out.println(index);
    }
}
