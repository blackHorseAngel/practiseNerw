package Aigo.Reverse.String;

/**
 *@Desprition https://leetcode-cn.com/problems/reverse-string/
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *@Author zhangshenming
 *@Date 2021/9/1 9:46
 *@Version 1.0
 */
public class ReverseString {
    /**
     *@Description
     *@Author zhangshenming
     *@Param s
     *@Date 2021/9/1 9:49
     *@Return void
     */
    public static void reverseStr(char[] s) {
        int start = 0;
        int end = s.length - 1;
        int mid = 0;
        int length = s.length;
        if(length == 0){
            return;
        }
        if(length >> 1 == 0){
            mid = (length>>1)-1;
        }else{
            mid = s.length>>1;
        }
        char c = 0;
        for(int i = 0;i <= mid;i++){
            c = s[end - i];
            s[end - i] = s[i];
            s[i] = c;
        }
    }

    public static void main(String[] args) {
//        char[]ch={'h','e','l','l','o'};
//        char[]ch = {'a','n','i','m','a','l'};
//        char[]ch = {'a','d','d'};
//          char[]ch = {};
        char[]ch = {'a'};
        reverseStr(ch);
        for(int i = 0;i < ch.length;i++){
            System.out.print(ch[i]+" ");
        }
    }
}
