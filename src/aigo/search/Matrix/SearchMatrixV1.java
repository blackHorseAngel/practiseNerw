package aigo.search.Matrix;

/**
 * @Description https://leetcode.cn/problems/search-a-2d-matrix
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * @Author Administrator
 * @Date 2023/2/28 8:20
 * @Version 1.0.0
 */
public class SearchMatrixV1 extends SearchMatrixSuper {
    //矩阵（二维数组）遍历
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;
        for (int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                if(matrix[i][j] == target){
                    flag =  true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
//        int[][]matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][]matrix = new int[][]{{1,3}};
        int target = 3;
        SearchMatrixV1 searchMatrixV1 = new SearchMatrixV1();
        boolean flag = searchMatrixV1.searchMatrix(matrix,target);
        System.out.println(flag);
    }
}
