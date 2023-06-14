package Aigo.Search.Matrix;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 17:11
 * @Version 1.0.0
 */
public class SearchMatrixV2 extends SearchMatrixSuper{
    //坐标轴法
    public boolean searchMatrix(int[][]matrix,int target){
        int row = matrix.length - 1;
        int col = 0;
        while(row >= 0 && col < matrix[0].length){
            if(matrix[row][col] == target){
                return true;
            }else{
                if(matrix[row][col] < target){
                    col++;
                }else{
                    row--;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
//        int[][]matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][]matrix = new int[][]{{1,3}};
        int target = 3;
        SearchMatrixV2 searchMatrixV2 = new SearchMatrixV2();
        boolean flag = searchMatrixV2.searchMatrix(matrix,target);
        System.out.println(flag);
    }
}
