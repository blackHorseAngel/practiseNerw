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
    /**
     *@Description
     *@Author zhangshenming
     *@Param b
     *@Date 2021/10/16 22:37
     *@Return int
     */
    public static int move1(byte b){
        return  b | (b<<8) | (b<<16) | (b<<24);
    }

    public static int move(byte b){
        return 0;
    }
    public static void main(String[] args) {
        byte[]bytes = {3,(byte)200};
        for (byte b : bytes){
            int result = move1(b);
            System.out.println(result);

        }
//        int result = move2(b);
//        Integer i = -56;
//        String s = Integer.toBinaryString(i);
//        System.out.println(s);
    }
}
