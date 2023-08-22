package aigo.Set.zeroes;


import java.util.*;

/**
 * @Description https://leetcode.cn/problems/set-matrix-zeroes/
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * @Author Administrator
 * @Date 2023/3/1 14:53
 * @Version 1.0.0
 */
public class SetZeroes {
    class Point{
        private int x;
        private int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
    //
    public  void setZeroes(int[][] matrix) {
        System.out.println("开始打印原始矩阵的样子");
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                System.out.print(matrix[i][j]);
                System.out.print("    ");
            }
            System.out.println();
        }
        Set<Point> set = new HashSet<>();
        Point point = null;
        for(int i =0 ; i < matrix.length ; i++){
            for (int j = 0 ; j < matrix[0].length ; j++){
                point  = new Point();
                if (matrix[i][j] == 0){
                    point.x = i;
                    point.y = j;
                    set.add(point);
                }
            }
        }
        for(Point p : set){
            for(int i = 0 ; i < matrix.length ; i++){
                for(int j = 0 ; j < matrix[i].length ; j++){
                    if(i == p.x || j == p.y){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.println("打印经过原地算法处理之后的矩阵的样子");
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                System.out.print(matrix[i][j]);
                System.out.print("    ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        SetZeroes zeroes = new SetZeroes();
//        int[][]matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        int[][]matrix = new int[][]{{0,1,2,0},{3,4,5,2},{0,3,1,0}};
        zeroes.setZeroes(matrix);

    }
}
