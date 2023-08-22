package aigo.merged;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/26 16:47
 * @Version 1.0.0
 */
public class MergedV2 extends MergedSuper{
    //结果集
    List<int[]> resultList = new ArrayList<int[]>();
    //当前区间
    int[]cur = new int[2];
    @Override
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        //将题目给的二维数组进行排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1],o2[1]);
            } else {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        cur = intervals[0];
        int index = 1;
        while (index < intervals.length) {
            if ((cur[1] <= intervals[index][1]) && (cur[1] >= intervals[index][0])) {
                cur[1] = intervals[index][1];
                resultList.add(cur);
            } else if (cur[1] < intervals[index][1]) {
                cur = intervals[index];
            }
            index++;
        }

        return (int[][]) resultList.toArray();
    }
    public static void main(String[] args) {
        //{{1,6},{8,10},{15,18}}
//        int[][] intervals = {{2, 6},{1, 3},{15, 18},{8, 10}};
        //{{1,5}}
        int[][]intervals = {{1,4},{4,5}};
        MergedV2 mergedV2 = new MergedV2();
        int[][] result = mergedV2.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }
}
