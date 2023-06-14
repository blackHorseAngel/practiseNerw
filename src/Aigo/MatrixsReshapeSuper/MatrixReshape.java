package Aigo.MatrixsReshapeSuper;

import static Aigo.util.Print.printDoubleArray;

/**
 * @Description https://leetcode.cn/problems/reshape-the-matrix
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * 给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 *
 *  将整数x 映射回其在矩阵中的下标，即 i = x / n   j = x % n
 *  设nums 本身为 m 行 n 列，如果 mn ≠ rc，那么二者包含的元素个数不相同，因此无法进行重塑；
 *  否则，对于x∈[0,mn)，第 x 个元素在 nums 中对应的下标为 (x/n,x%n)，而在新的重塑矩阵中对应的下标为(x/c,x%c)。我们直接进行赋值即可。
 *
 * @Author Administrator
 * @Date 2023/2/28 9:39
 * @Version 1.0.0
 */
public class MatrixReshape extends MaxtrixReshaperSuper {

    //
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if((m * n) != (c * r)){
            return mat;
        }
       int[][]newMatrix = new int[r][c];
       for(int x = 0 ; x < m * n ; ++m){
          newMatrix[x/c][x%c] = mat[x/n][x%n];
       }
       return newMatrix;
    }

    public static void main(String[] args) {
       int[][]matrix = new int[][]{{1,2},{3,4}};
       MatrixReshape matrixReshape = new MatrixReshape();
       int[][]newMatrix = matrixReshape.matrixReshape(matrix,1,4);
       printDoubleArray(newMatrix);
    }
}
