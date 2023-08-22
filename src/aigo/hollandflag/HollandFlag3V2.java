package aigo.hollandflag;

import java.util.ArrayList;
import java.util.List;

import static aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 9:02
 * @Version 1.0.0
 */
public class HollandFlag3V2 extends HollandFlagSuper{
    /**
     *@Description
     *@Author zhangshenming
     *@Param array, target
     *@Date 2021/11/21 2:22
     *@Return int[]
     */
    public int[]handle1(int[]array,int target){
        List<Integer> lessList = new ArrayList<Integer>();
        List<Integer> greaterList = new ArrayList<Integer>();
        List<Integer> equalList = new ArrayList<Integer>();
        for(int i:array){
            if(i < target){
                lessList.add(i);
            }else if(i > target){
                greaterList.add(i);
            }else{
                equalList.add(i);
            }
        }
        int lessListSize = lessList.size();
        for(int j = 0;j < lessListSize;j++){
            array[j] = lessList.get(j);
        }
        int equalListSize = greaterList.size();
        for(int m = 0;m < equalListSize;m++){
            array[lessListSize+m] = equalList.get(m);
        }
        int greaterListSize = greaterList.size();
        for(int n = 0;n < greaterListSize;n++){
            array[lessListSize+equalListSize+n] = greaterList.get(n);
        }
        return array;
    }
    public static void main(String[] args) {
        HollandFlag3V2 hollandFlag3V2 = new HollandFlag3V2();
        // int[]array = {5,1,2,3,8,7,4,5,4,7,8,3,2,1,5};
        int[]array = {1, 5 , 6};
        int target = 5;
        int[]result = hollandFlag3V2.handle(array,target);
        printArray(result);
    }
}
