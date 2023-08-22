package aigo.merged;

import java.util.Arrays;

/**
 * @Description https://leetcode.cn/problems/merge-intervals
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * @Author Administrator
 * @Date 2023/6/24 9:19
 * @Version 1.0.0
 */
public class MergedV1 extends MergedSuper {
    @Override
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        //将题目给的二维数组进行排序
        Arrays.sort(intervals, (o1, o2) -> {
//            if (o1[0] == o2[0]) {
//                return o1[1] - o2[1];
//                return Integer.compare(o1[1],o2[1]);
//            } else {
//                return o1[0] - o2[0];
                return Integer.compare(o1[0],o2[0]);
//            }
        });
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int slowIndex = 0;
        int fastIndex = 1;
        while (fastIndex < intervals.length) {
                if ((intervals[slowIndex][1] <= intervals[fastIndex][1]) && (intervals[slowIndex][1] >= intervals[fastIndex][0])) {
                    intervals[slowIndex][1] = intervals[fastIndex][1];
                } else if (intervals[slowIndex][1] < intervals[fastIndex][1]) {
                    slowIndex++;
                    intervals[slowIndex] = intervals[fastIndex];
                }
                fastIndex++;
        }
//        int[][] result = new int[slowIndex+1][];
//        for (int i = 0; i <= slowIndex; i++) {
//            result[i] = intervals[i]
//        }
        return  Arrays.copyOf(intervals,slowIndex+1);
    }

    public static void main(String[] args) {
        //{{1,6},{8,10},{15,18}}
//        int[][] intervals = {{2, 6},{1, 3},{15, 18},{8, 10}};
        //{{1,5}}
        int[][]intervals = {{1,4},{4,5}};
        MergedV1 mergedV1 = new MergedV1();
        int[][] result = mergedV1.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

}
