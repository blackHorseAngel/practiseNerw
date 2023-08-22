package aigo.YangHui.triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode.cn/problems/pascals-triangle/?envType=study-plan&id=shu-ju-jie-gou-ru-men&plan=data-structures&plan_progress=jfjr95m
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 输入: numRows = 1
 * 输出: [[1]]
 * 1 <= numRows <= 30
 * @Author Administrator
 * @Date 2023/2/28 16:06
 * @Version 1.0.0
 */
public class PascalsTriangle extends YangHuiTriangleSuper {
    //
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer>elements = null;
        Integer[][]arr = new Integer[numRows+1][numRows+1];
        for(int i = 0 ; i < numRows + 1 ; i++){
            elements = new ArrayList<>();
            for(int j = 0 ; j < i + 1 ; j++){
                if(j == 0 || j == i){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                }
                elements.add(arr[i][j]);
            }
            results.add(elements);
        }
        return results;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>>results = pascalsTriangle.generate(5);
        for(List<Integer>lists:results){
            for (int i:lists){
                System.out.print(i);
                System.out.print("   ");
            }
            System.out.println();
        }

    }
}
