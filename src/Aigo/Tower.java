package Aigo;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/3/31 20:32
 * @Version 1.0.0
 */
public class Tower {
    //从左往右数，第一根竖杆
    public static final String STICK_1 = "stick1";
    //从左往右数，第二根竖杆
    public static final String STICK_2 = "stick2";
    //从左往右数，第三根竖杆
    public static final String STICK_3 = "stick3";

    /**
     * 把n个盘子从一根杆子上移动到另一根杆子上
     * @param n
     * @param fromStick
     * @param toStick
     */
    public static void move(int n,String fromStick,String toStick){
        if(n <= 0){
            return;
        }
        move(n-1,STICK_1,STICK_2);
        moveOne(n,fromStick,toStick);
        move(n-1,STICK_2,STICK_3);
    }
    public static  void moveOne(int one,String fromStick,String toStick){
        System.out.println("第" + one + "个盘子从" + fromStick + "杆移动到" + toStick);
    }
    public static void main(String[] args) {
        move(3,STICK_1,STICK_3);
    }
}
