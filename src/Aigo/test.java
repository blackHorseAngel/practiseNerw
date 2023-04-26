package Aigo;/**
 * @description
 * @author 86185
 * @date 2021/10/16 15:55
 * @see 1.0.0
 */

/**
 *@Desprition TODO
 *@Author zhangshenming
 *@Date 2021/10/16 15:55
 *@Version 1.0
 */
public class test {

    static int num =4;
    {
        num+=3;
        System.out.println("b");
    }
    int a =5;
    {
        System.out.println("c");
    }
    test(){
        System.out.println("d");
    }
    static {
        System.out.println("a");
    }
private static final String MESSAGE = "cib";
    public static void main(String[] args) {
//        new test();
//        System.out.println(1<<4);
    String a = "c"+"i"+"b";
    String b = "c";
    String c = "i";
    String d = "b";
        System.out.println(a==MESSAGE);
        System.out.println((b+c+d)==MESSAGE);
    }
}
