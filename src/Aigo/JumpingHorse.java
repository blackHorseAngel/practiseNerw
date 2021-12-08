package Aigo;

import Aigo.util.Init;

import java.util.HashMap;
import java.util.Map;

/**
 *@Desprition 国际象棋中的马从棋盘上的任意一个格子出发，不重复的跳完整个棋盘并打印出每一步的步数
 *@Author zhangshenming
 *@Date 2021/11/23 22:03
 *@Version 1.0
 */
public class JumpingHorse {
    public static void jumpingHorse(int[][] array, int x, int y) {
        //用来记录每次的坐标和方向:direction[0],x-step[1],y-step[2]
        int[] step = new int[192];
        //方向：
        // 0:(x+1,y+2);
        // 1:(x+2,y+1);
        // 2:(x-1,y+2);
        // 3:(x-2,y+1);
        // 4:(x-1,y-2);
        // 5:(x-2,y-1);
        // 6:(x+1,y-2);
        // 7:(x+2,y-1);
        //存放函数间调用的参数值：0-方向；1-step数组中x对应的下标；2-step数组中y对应的下标；3-step数组中方向对应的下标；
        //4-x对应的步；5-y对应的步；6-棋盘长度(固定值)
        int[]storage = new int[7];
        storage[0] = 0;
        storage[1] = 1;
        storage[2] = 2;
        storage[3] = 3;
        storage[4] = x;
        storage[5] = y;
        storage[6] = array.length;
        while((step[191] == 0) || (step[190] == 0) || (step[189] == 0)){
                switch (storage[0]%8){
                    case 0:moveTo0(step,storage);
                           break;
                    case 1:moveTo1(step,storage);
                           break;
                    case 2:moveTo2(step,storage);
                           break;
                    case 3:moveTo3(step,storage);
                           break;
                    case 4:moveTo4(step,storage);
                           break;
                    case 5:moveTo5(step,storage);
                           break;
                    case 6:moveTo6(step,storage);
                           break;
                    case 7:moveTo7(step,storage);
                           break;
                    default:break;
                }
        }

    }

    /**
     * @Description 移动到方向0后需要走的步
     * @Author zhangshenming
     * @Param step, length
     * @Date 2021/11/23 23:54
     * @Return int[]
     */
    public static void moveTo0(int[] step, int[]storage) {
        int direction0 = storage[0];
        int i = storage[1];
        int j = storage[2];
        int k = storage[3];
        int x = storage[4];
        int y = storage[5];
        int length = storage[6];
        while ((x + 1 <= length) && (y + 2 <= length)) {
            if(step[i] != 0){

            }
                i += 3;
                j += 3;
                k += 3;
            step[i] = x + 1;
            step[j] = y + 2;
            step[k] = direction0;

        }
        storage[0] = direction0 + 1;
        storage[1] = i;
        storage[2] = j;
        storage[3] = k;
        storage[4] = x;
        storage[5] = y;
    }

    /**
     * @Description 移动到方向1后需要走的步数
     * @Author zhangshenming
     * @Param step, length
     * @Date 2021/11/23 23:52
     * @Return int[]
     */
    public static void moveTo1(int[] step, int[]storage) {
        int direction1 = storage[0];
        int i = storage[1];
        int j = storage[2];
        int k = storage[3];
        int x = storage[4];
        int y = storage[5];
        int length = storage[6];
        while ((x + 2 <= length) && (y + 1 <= length)) {
            if (i != 0) {
                i += 3;
                j += 3;
                k += 3;
            }
            step[i] = x + 2;
            step[j] = y + 1;
            step[k] = direction1;
            if (i == 0) {
                i += 3;
                j += 3;
                k += 3;
            }
        }
        storage[0] = direction1 + 1;
        storage[1] = i;
        storage[2] = j;
        storage[3] = k;
        storage[4] = x;
        storage[5] = y;
    }

    /**
     * @Description 移动到方向2后需要走的步
     * @Author zhangshenming
     * @Param step, length
     * @Date 2021/11/23 23:51
     * @Return int[]
     */
    public static void moveTo2(int[] step, int[]storage) {
        int direction2 = storage[0];
        int i = storage[1];
        int j = storage[2];
        int k = storage[3];
        int x = storage[4];
        int y = storage[5];
        int length = storage[6];
        while ((x - 1 <= length) && (y + 2 <= length)) {
            if (i != 0) {
                i += 3;
                j += 3;
                k += 3;
            }
            step[i] = x - 1;
            step[j] = y + 2;
            step[k] = direction2;
            if (i == 0) {
                i += 3;
                j += 3;
                k += 3;
            }
        }
        storage[0] = direction2 + 1;
        storage[1] = i;
        storage[2] = j;
        storage[3] = k;
        storage[4] = x;
        storage[5] = y;
    }

    /**
     * @Description 移动到方向3后需要走的步
     * @Author zhangshenming
     * @Param step, length
     * @Date 2021/11/23 23:49
     * @Return int[]
     */
    public static void moveTo3(int[] step, int[]storage) {
        int direction3 = storage[0];
        int i = storage[1];
        int j = storage[2];
        int k = storage[3];
        int x = storage[4];
        int y = storage[5];
        int length = storage[6];
        while ((x - 2 <= length) && (y + 1 <= length)) {
            if (i != 0) {
                i += 3;
                j += 3;
                k += 3;
            }
            step[i] = x - 2;
            step[j] = y + 1;
            step[k] = direction3;
            if (i == 0) {
                i += 3;
                j += 3;
                k += 3;
            }
        }
        storage[0] = direction3 + 1;
        storage[1] = i;
        storage[2] = j;
        storage[3] = k;
        storage[4] = x;
        storage[5] = y;
    }

    /**
     * @Description 移动到方向4后需要走的步
     * @Author zhangshenming
     * @Param step, length
     * @Date 2021/11/23 23:47
     * @Return int[]
     */
    public static void moveTo4(int[] step, int[]storage) {
        int direction4 = storage[0];
        int i = storage[1];
        int j = storage[2];
        int k = storage[3];
        int x = storage[4];
        int y = storage[5];
        int length = storage[6];
        while ((x - 1 <= length) && (y - 2 <= length)) {
            if (i != 0) {
                i += 3;
                j += 3;
                k += 3;
            }
            step[i] = x - 1;
            step[j] = y - 2;
            step[k] = direction4;
            if (i == 0) {
                i += 3;
                j += 3;
                k += 3;
            }
        }
        storage[4] = direction4 + 1;
        storage[1] = i;
        storage[2] = j;
        storage[3] = k;
        storage[4] = x;
        storage[5] = y;
    }

    /**
     * @Description 移动到方向5后需要走的步
     * @Author zhangshenming
     * @Param step, length
     * @Date 2021/11/23 23:46
     * @Return int[]
     */
    public static void moveTo5(int[] step, int[]storage) {
        int direction5 = storage[0];
        int i = storage[1];
        int j = storage[2];
        int k = storage[3];
        int x = storage[4];
        int y = storage[5];
        int length = storage[6];
        while ((x - 2 <= length) && (y - 1 <= length)) {
            if (i != 0) {
                i += 3;
                j += 3;
                k += 3;
            }
            step[i] = x - 2;
            step[j] = y - 1;
            step[k] = direction5;
            if (i == 0) {
                i += 3;
                j += 3;
                k += 3;
            }
        }
        storage[0] = direction5 + 1;
        storage[1] = i;
        storage[2] = j;
        storage[3] = k;
        storage[4] = x;
        storage[5] = y;
    }

    /**
     * @Description 移动到方向6后需要走的步
     * @Author zhangshenming
     * @Param step, length
     * @Date 2021/11/23 23:45
     * @Return int[]
     */
    public static void moveTo6(int[] step, int[]storage) {
        int direction6 = storage[0];
        int i = storage[1];
        int j = storage[2];
        int k = storage[3];
        int x = storage[4];
        int y = storage[5];
        int length = storage[6];
        while ((x + 1 <= length) && (y - 2 <= length)) {
            if (i != 0) {
                i += 3;
                j += 3;
                k += 3;
            }
            step[i] = x + 1;
            step[j] = y - 2;
            step[k] = direction6;
            if (i == 0) {
                i += 3;
                j += 3;
                k += 3;
            }
        }
        storage[0] = direction6 + 1;
        storage[1] = i;
        storage[2] = j;
        storage[3] = k;
        storage[4] = x;
        storage[5] = y;
    }

    /**
     * @Description 移动到方向7的时候需要走的步数
     * @Author zhangshenming
     * @Param step, length
     * @Date 2021/11/23 23:45
     * @Return int[]
     */
    public static void moveTo7(int[] step, int[]storage) {
        int direction7 = storage[0];
        int i = storage[1];
        int j = storage[2];
        int k = storage[3];
        int x = storage[4];
        int y = storage[5];
        int length = storage[6];
        while ((x + 2 <= length) && (y - 1 <= length)) {
            if (i != 0) {
                i += 3;
                j += 3;
                k += 3;
            }
            step[i] = x + 2;
            step[j] = y - 1;
            step[k] = direction7;
            if (i == 0) {
                i += 3;
                j += 3;
                k += 3;
            }
        }
        storage[0] = direction7 + 1;
        storage[1] = i;
        storage[2] = j;
        storage[3] = k;
        storage[4] = x;
        storage[5] = y;
    }

    public static void main(String[] args) {
      int[][]array = Init.initMatrix(8);
      long startTime = System.currentTimeMillis();
      jumpingHorse(array,0,0);
      long endTime = System.currentTimeMillis();
      long time = endTime - startTime;
        System.out.println("马跳完整个国际象棋棋盘需要的时间是：" + time);
       }
    }
