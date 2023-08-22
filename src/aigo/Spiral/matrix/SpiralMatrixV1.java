package aigo.Spiral.matrix;

import java.util.*;

import static aigo.util.Init.initMatrix;
import static aigo.util.Print.printDoubleArray;

/**
 *@Desprition 矩阵的螺旋打印
 *@Author zhangshenming
 *@Date 2021/8/14 16:35
 *@Version 1.0
 */
public class SpiralMatrixV1 extends SpiralMatrixSuper {
    public static void main(String[] args) {
        int[][] array = initMatrix(5);
        printDoubleArray(array);
        SpiralMatrixV1 spiralMatrixV1 = new SpiralMatrixV1();
        //第一版：知道路径直接走
        spiralMatrixV1.printMatrixOneSide(array);
        //第三版：对第二版的修正（1、最外层循环退出条件；2、由原来的先走一步再判断是否出界再转向改为预判是否出界再转向；）
//        printMatrixOneSideNew2(array);
    }
    /**
     *@Description "回"字框打印（上帝视角）
     *@Author zhangshenming
     *@Param x, y, array
     *@Date 2021/8/14 18:30
     *@Return void
     */
    private void printMatrixOneSide(int[][] array) {
        // 用于存放遍历出来的数组中的数
        Set<Integer> set = new HashSet<Integer>();
        // 计数器
        int count = 0;
        for(int x = 0,y = 0,length = array.length ; length >= 0 ; length-- , x++ , y++){
            while(x <= length-1){
                if(set.contains(array[x][y])){
                    break;
                }
                set.add(array[x][y]);
                System.out.println("数组序号是：" + x + y + ":数组中的元素值是：" + array[x][y]);
                count++;
                x++;
            }
            for(x-- , y++ ; y <= length - 1 ; y++){
                if(set.contains(array[x][y])){
                    break;
                }
                set.add(array[x][y]);
                System.out.println("数组序号是：" + x + y + ":数组中的元素值是：" + array[x][y]);
                count++;
            }
            for(x-- , y-- ; x >= 0 ; x--){
                if(set.contains(array[x][y])){
                    break;
                }
                set.add(array[x][y]);
                System.out.println("数组序号是：" + x + y + ":数组中的元素值是：" + array[x][y]);
                count++;
            }
            for(x++ , y-- ; y >= 0 ; y--){
                if(set.contains(array[x][y])){
                    break;
                }
                set.add(array[x][y]);
                System.out.println("数组序号是：" + x + y + ":数组中的元素值是：" + array[x][y]);
                count++;
            }
        }
        System.out.println("count:" + count);
    }


}
