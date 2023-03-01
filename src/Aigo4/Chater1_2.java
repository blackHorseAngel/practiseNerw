package Aigo4;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/2/21 15:15
 * @Version 1.0.0
 */
public class Chater1_2 {
    //1.2.7
public static String mystery(String s){
    int N = s.length();
    if( N <= 1){
        return s;
    }
    String a = s.substring(0,N/2);
    String b = s.substring(N/2,N);
    return mystery(b) + mystery(a);
}
    public static void main(String[] args) {
        //1.2.4
//        String string1 = "hello";
//        String string2 = string1;
//        string1 = "world";
//        System.out.println(string1);
//        System.out.println(string2);
        //1.2.5
//        String s = "hello world";
//        s.toUpperCase();
//        s.substring(6,11);
//        System.out.println(s);
        //1.2.7
//        String ss = mystery("hello");
//        System.out.println(ss);

   }
}
