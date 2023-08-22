package aigo.valid.Sqrt;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 18:50
 * @Version 1.0.0
 */
public class ValidSqrtV2 extends ValidSqrtSuper{
    /***
     *@Description
     *@Author zhangshenming
     *@Param num
     *@Date 2021/11/17 14:41
     *@Return boolean
     */
    public boolean isPerfectSquare(int num) {
        for(int i = 1,square = 0 ; square < num ; i++) {
            square = i * i;
            if (num == square) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int num = 2147483647;
        ValidSqrtV2 validSqrtV2 = new ValidSqrtV2();
        boolean flag = validSqrtV2.isPerfectSquare(num);
        System.out.println(flag);

//        int[]num = {1,10,100,1000,10000,100000,1000000,10000000,100000000,100000000,2000000000,
//                2100000000,2140000000,2147000000,2147400000,2147480000,2147483000,2147483600,2147483640,2147483646};
//        boolean flag = false;
//        for(int i:num){
//            flag = isPerfectSquare3(i);
//            System.out.println("i:" + i + " 是否是完全平方数：" + flag);
//        }
    }
}
