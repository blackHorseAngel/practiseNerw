package aigo.Unique.paths;


import java.util.*;

/**
 * @Description https://leetcode.cn/problems/unique-paths
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 输入：m = 3, n = 7
 * 输出：28
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 输入：m = 7, n = 3
 * 输出：28
 * 输入：m = 3, n = 3
 * 输出：6
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * @Author Administrator
 * @Date 2023/6/22 7:35
 * @Version 1.0.0
 */
public class UniquePathV1 extends UniquePathSuper {
    /**
     * 坐标点对象
     */
    static class Point {
        /**
         * x坐标
         */
        private int x;
        /**
         * y坐标
         */
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return getX() == point.getX() && getY() == point.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }

    @Override
    public int uniquePaths(int m, int n) {
        //x坐标，对应边界m;y坐标，对应边界n;
        Point point = new Point();
        //第一位是方向，1表示向右走，2表示向下走;第二位代表结果
        int[] directionAndResult = new int[2];
        //存储走过的点的位置
        Set<Point> set = new HashSet<>();
        //原点加入set
        set.add(point);
        //假设第一步往右走
        directionAndResult[0] = 1;
        //计算成功走出来的路径
        countPaths(m, n, point, directionAndResult, set);
        return directionAndResult[1];
    }

    /**
     * @param m
     * @param n
     * @param point
     * @param directionAndResult
     */
    private void countPaths(int m, int n, Point point, int[] directionAndResult, Set<Point> set) {
        //退出条件：set中的点的个数等于m和n的乘积
        if (set.size() == m * n) {
            return;
        }
        //如果point走到end的时候，即(m-1,n-1)，成功次数+1，并返回上一步
        if (point.x == m - 1 && point.y == n - 1) {
            directionAndResult[1]++;
            return;
        }
        //假设向右走一步，如果没有越界，横坐标process[0]++，如果越界，纵坐标process[1]++
        if (tryNextStep(m, n, point, directionAndResult)) {
            point.x++;
        } else {
            point.y++;
        }
        //如果set不包含这个点的坐标，那么把这个点加入set中，如果包含，结束
        if (!set.contains(point)) {
            set.add(new Point(point.x, point.y));
        } else {
            return;
        }
        countPaths(m, n, point, directionAndResult, set);


    }

    /**
     * @param m
     * @param n
     * @param point
     * @return
     */
    private boolean tryNextStep(int m, int n, Point point, int[] directionAndResult) {
            //表示向右走越界了，修改方向为向下走
            if (point.x + 1 >= m) {
                directionAndResult[0] = 2;
                return false;
            }
            //表示向下走越界了，修改方向为向右走
            if (point.y + 1 >= n) {
                directionAndResult[0] = 1;
                return false;
            }
        return true;
    }

    public static void main(String[] args) {
        UniquePathV1 uniquePathV1 = new UniquePathV1();
        //28
//        int m = 3;
//        int n = 7;
        //3
//        int m = 3;
//        int n = 2;
        //28
        int m =7;
        int n =3;
        //6
//        int m = 3;
//        int n = 3;
        int count = uniquePathV1.uniquePaths(m, n);
        System.out.println(count);

    }
}
