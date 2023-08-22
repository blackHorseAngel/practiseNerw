package aigo.valid.Sqrt;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 18:51
 * @Version 1.0.0
 */
public class ValidSqrtV3 extends ValidSqrtSuper{
    /**
     *@Description 使用二分法
     *@Author zhangshenming
     *@Param num
     *@Date 2021/11/17 14:53
     *@Return boolean
     */
    public boolean isPerfectSquare(int num){
        long start = 0;
        long end = num;
        long middle = 0;
        long square = 0;
        int count = 0;
        while(start <= end){
            count++;
            middle = (end - start)/2 + start;
            square = middle * middle;
            if(square < num){
                start = middle + 1;
            }else if(square > num){
                end = middle - 1;
            }else{
                System.out.println("count:" + count);
                return true;
            }
        }
        System.out.println("count:" + count);
        return false;
    }
    public static void main(String[] args) {
        int num = 2147483647;
        ValidSqrtV3 validSqrtV3 = new ValidSqrtV3();
        boolean flag = validSqrtV3.isPerfectSquare(num);
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
