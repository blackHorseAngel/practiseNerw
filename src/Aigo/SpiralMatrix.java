package Aigo;

import java.util.*;

import static Aigo.util.Init.initMatrix;
import static Aigo.util.Print.printDoubleArray;

/**
 *@Desprition 矩阵的螺旋打印
 *@Author zhangshenming
 *@Date 2021/8/14 16:35
 *@Version 1.0
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] array = initMatrix(5);
        printDoubleArray(array);
        //第一版：知道路径直接走
//      printMatrixOneSide(array);
        //第二版：未知路径尝试走
//      printMatrixOneSideNew(array);
        //第三版：对第二版的修正（1、最外层循环退出条件；2、由原来的先走一步再判断是否出界再转向改为预判是否出界再转向；）
        printMatrixOneSideNew2(array);
    }
    /**
     *@Description 第二版的修正版
     *@Author zhangshenming
     *@Param array
     *@Date 2021/8/26 23:47
     *@Return void
     */
    private static void printMatrixOneSideNew2(int[][] array) {
        //记录下当前的点对应的数字
        Set<Integer>set = new HashSet<Integer>();
        //用于最终打印次数的计数器
        int count = 0;
        //P(x,y)默认从(0,0)点出发，分别代表arr数组的第一位，第二位，第三位是方向，默认向右转的方向为初始方向0(向右走)，1(向下走),2(向左走),3(向上走)
        int[]arr = {0,0,0};
        //把数组中的出发点的值放进集合。
        set.add(array[arr[0]][arr[1]]);
        while(true){
            //打印当前点的元素
            System.out.println("数组中的元素位置：（"+arr[0]+","+arr[1]+"),元素是："+array[arr[0]][arr[1]]);
            //试试是否超出边界
            if( isNextStepOutOfBoundsOrMoved(arr,array,set)){
                //转向或递进
                arr = turnDirectionNew(arr,array);
            }else{
                //走一步的坐标
                arr = moveNextStep(arr);
                //把数组中的当前点的值放进集合。
                set.add(array[arr[0]][arr[1]]);
                count++;
                if(count == array.length * array.length-1){
                    break;
                }
            }
        }
        System.out.println("一共需要的次数："+count);
    }
    /**
     *@Description 获取下一个点的坐标
     *@Author zhangshenming
     *@Param x, y, z
     *@Date 2021/8/28 14:48
     *@Return int[]
     */
    private static int[]getNextStep(int x,int y,int z){
        int[]arr = new int[3];
        switch(z%4){
            case 0:x++;
                   break;
            case 1:y++;
                   break;
            case 2:x--;
                   break;
            case 3:y--;
                   break;
            default:break;
        }
        arr[0] = x;
        arr[1] = y;
        arr[2] = z;
        return arr;
    }
    /**
     *@Description 修正版的转向或递进一步
     *@Author zhangshenming
     *@Param arr, array
     *@Date 2021/8/27 0:09
     *@Return int[]
     */
    private static int[] turnDirectionNew(int[] arr, int[][] array) {
        arr[2]++;
        return arr;
    }
    /**
     *@Description "回"字框打印（上帝视角）
     *@Author zhangshenming
     *@Param x, y, array
     *@Date 2021/8/14 18:30
     *@Return void
     */
    private static void printMatrixOneSide(int[][] array) {
        // 用于存放遍历出来的数组中的数
        Set<Integer> set = new HashSet<Integer>();
        // 计数器
        int count = 0;
        for(int x=0,y=0,length=array.length;length>=0;length--,x++,y++){
            for(;x<=length-1;x++){
                if(set.contains(array[x][y])){
                    break;
                }
                set.add(array[x][y]);
                System.out.println("数组序号是："+x+y+":数组中的元素值是："+array[x][y]);
                count++;
            }
            for(x--,y++;y<=length-1;y++){
                if(set.contains(array[x][y])){
                    break;
                }
                set.add(array[x][y]);
                System.out.println("数组序号是："+x+y+":数组中的元素值是："+array[x][y]);
                count++;
            }
            for(x--,y--;x>=0;x--){
                if(set.contains(array[x][y])){
                    break;
                }
                set.add(array[x][y]);
                System.out.println("数组序号是："+x+y+":数组中的元素值是："+array[x][y]);
                count++;
            }
            for(x++,y--;y>=0;y--){
                if(set.contains(array[x][y])){
                    break;
                }
                set.add(array[x][y]);
                System.out.println("数组序号是："+x+y+":数组中的元素值是："+array[x][y]);
                count++;
            }
        }
        System.out.println("count:" + count);
    }


    /**
     *@Description 摸索着打印
     *@Author zhangshenming
     *@Param
     *@Date 2021/8/17 14:59
     *@Return void
     */
    public static void printMatrixOneSideNew(int[][]array) {
        //记录下当前的点对应的数字
        Set<Integer>set = new HashSet<Integer>();
        //计数器
        int count = 0;
        //P(x,y)默认从(0,0)点出发，分别代表arr数组的第一位，第二位，第三位是方向，默认向右转的方向为初始方向0(向右走)，1(向下走),2(向左走),3(向上走)
        int[]arr = {0,0,0};
        //判断是否出界的标志位
        boolean flag = false;
        while(!set.contains(array[arr[0]][arr[1]])){
            //打印当前点的元素
            System.out.println("数组中的元素位置：（"+arr[0]+","+arr[1]+"),元素是："+array[arr[0]][arr[1]]);
            //获取下一步的坐标
            arr = moveNextStep(arr);
            //试试是否超出边界
            flag = isNextStepOutOfBoundsOld(arr,array,set,flag);
            if(flag){
                //转向或递进
                arr = turnDirection(arr,array);
            }
            //把数组中的当前点的值放进集合。
            set.add(array[arr[0]][arr[1]]);
            flag = false;
            count++;
        }
        System.out.println("一共需要的次数："+count);
    }
    /**
     *@Description 拿到当前点的下一步的坐标x,y值
     *@Author zhangshenming
     *@Param arr, array
     *@Date 2021/8/25 15:48
     *@Return int[]
     */
    private static int[] moveNextStep(int[] arr) {
        return getNextStep(arr[0],arr[1],arr[2]);
    }
    /**
     *@Description 修正版的判断是否出界
     *@Author zhangshenming
     *@Param arr, array, set, flag
     *@Date 2021/8/27 0:07
     *@Return boolean
     */
    private static boolean isNextStepOutOfBoundsOrMoved(int[]arr,int[][]array,Set<Integer>set){
        //初始化一个数组用以表示下一步
        int[]nextStep = new int[3];
        //获取下一步的坐标值
        nextStep=getNextStep(arr[0],arr[1],arr[2]);
        //判断横坐标是否出界,true表示出界，false表示没出界
        if((nextStep[0]>=array.length) || (nextStep[0]<0)){
            return true;
        }
        //判断纵坐标是否出界；true表示出界，false表示没出界
        if((nextStep[1]>=array.length) || (nextStep[1]<0)){
            return true;
        }
        //判断下一个点是否已经走过，true表示已经走过，false表示没走过
        if(set.contains(array[nextStep[0]][nextStep[1]])){
            return true;
        }
        return false;
    }
    /**
     *@Description 尝试走一步,flag是true，出界；反之，没出界
     *@Author zhangshenming
     *@Param x, y, length
     *@Date 2021/8/21 20:30
     *@Return boolean
     */
    private static boolean isNextStepOutOfBoundsOld(int[]arr,int[][]array,Set<Integer>set,boolean flag){
        int a = arr[2]%4;
        switch(a){
           case 0: if(arr[0] >= array.length || set.contains(array[arr[0]][arr[1]])){
                      flag = true;
                   }
                   break;
           case 1:if(arr[1] >= array.length || set.contains(array[arr[0]][arr[1]])){
                     flag = true;
                    }
                   break;
           case 2:if(arr[0] < 0 || set.contains(array[arr[0]][arr[1]])){
                     flag = true;
                   }
                   break;
           case 3:if(set.contains(array[arr[0]][arr[1]])){
                      flag = true;
                  }
                  break;
           default:break;
       }
       return flag;
    }
    /**
     *@Description 转向或递进一步
     *@Author zhangshenming
     *@Param arr, array
     *@Date 2021/8/27 0:05
     *@Return int[]
     */
    private static int[] turnDirection(int[]arr,int[][]array) {
        switch(arr[2]%4){
            case 0:arr[0]--;
                   arr[1]++;
                   break;
            case 1:arr[1]--;
                   arr[0]--;
                   break;
            case 2:arr[0]++;
                   arr[1]--;
                   break;
            case 3:arr[1]++;
                   arr[0]++;
                   break;
            default:break;
        }
        arr[2]++;
        return arr;
    }
}
