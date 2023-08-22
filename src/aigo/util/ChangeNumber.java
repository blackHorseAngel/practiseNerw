package aigo.util;
/**
 *@Desprition 工具方法：交换两个数
 *@Author zhangshenming
 *@Date 2021/10/5 9:11
 *@Version 1.0
 */
public class ChangeNumber {
    /**
     *@Description 创建中间变量temp用于交换两个数
     *@Author zhangshenming
     *@Param array, i
     *@Date 2021/10/5 9:16
     *@Return int[]
     */
    public static int[]change1(int[]array,int i){
        int temp = 0;
        temp = array[i];
        array[i] = array[i+1];
        array[i+1] = temp;
        return array;
    }
    /**
     *@Description 使用异或位运算处理两个数字交换位置
     *@Author zhangshenming
     *@Param array, i
     *@Date 2021/10/5 9:18
     *@Return int[]
     */
    public static int[]change2(int[]array,int i){
        array[i] = array[i]^array[i+1];
        array[i+1] = array[i]^array[i+1];
        array[i] = array[i]^array[i+1];
        return array;
    }
}
