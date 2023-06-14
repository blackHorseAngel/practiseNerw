package Aigo.YangHui.Triangle;

import java.util.*;

/**
 *@Desprition https://leetcode-cn.com/problems/pascals-triangle-ii/
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *@Author zhangshenming
 *@Date 2021/9/5 23:33
 *@Version 1.0
 */
public class Yanghui extends YangHuiTriangleSuper {
    /**
     *@Description
     *@Author zhangshenming
     *@Param rowIndex
     *@Date 2021/9/5 23:35
     *@Return java.util.List<java.lang.Integer>
     */
    public List<Integer> getRow(int rowIndex) {
        Integer[][]arr = new Integer[rowIndex+1][rowIndex+1];
        for(int i = 1 ; i < rowIndex + 1 ; i++){
            for(int j = 0;j < i + 1;j++){
                if(j == 0 || j == i){
                    arr[i][j] = 1;
                }else{
                  arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }
        return Arrays.asList(arr[rowIndex]);
    }

    public static void main(String[] args) {
        Yanghui yanghui = new Yanghui();
        List<Integer>list = yanghui.getRow(5);
        for(int i = 0 ; i < list.size() ; i++){
            System.out.print(list.get(i));
            System.out.print(" ");
        }
    }
}
