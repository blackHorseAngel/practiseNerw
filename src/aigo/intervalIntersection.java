package aigo;

/**
 * @Description https://leetcode.cn/problems/interval-list-intersections
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而secondList[j] = [startj, endj] 。
 * 每个区间列表都是成对 不相交 的，并且 已经排序 。返回这 两个区间列表的交集 。形式上，闭区间[a, b]（其中a <= b）表示实数x的集合，而a <= x <= b 。
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *输入：firstList = [[1,3],[5,9]], secondList = []
 * 输出：[]
 * 输入：firstList = [], secondList = [[4,8],[10,12]]
 * 输出：[]
 * 输入：firstList = [[1,7]], secondList = [[3,10]]
 * 输出：[[3,7]]
 * 0 <= firstList.length, secondList.length <= 1000
 * firstList.length + secondList.length >= 1
 * 0 <= starti < endi <= 109
 * endi < starti+1
 * 0 <= startj < endj <= 109
 * endj < startj+1
 *
 * @Author Administrator
 * @Date 2023/3/7 17:51
 * @Version 1.0.0
 */
public class intervalIntersection {
    //
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0){
            return new int[][]{};
        }

        return null;
    }
    public static void main(String[] args) {
        int[][]firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][]secondList = {{1,5},{8,12},{15,24},{25,26}};
    }
}
