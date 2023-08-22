package aigo.Climbing.floor;

/**
 *@Desprition https://leetcode.cn/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * 1 <= n <= 45
 *@Author zhangshenming
 *@Date 2021/8/31 22:18
 *@Version 1.0
 */
public class ClimbingV1 extends ClimbingSuper {
    /**
     *@Description 倒着看，能上到第N层，那么有两种方式：上到第N-1层，再上一层；或上到N-2层，再上两层
     * 上到N-1层有两种方式：上到N-2层，再上一层；或上到N-3层，再上一层；
     * 上到N-2层有两种方式：上到N-3层，再上一层；或上到N-4层，再上两层；
     * ……
     * 上到3层有两种方式：上到2层，再上一层；或上到1层，再上两层；
     * 上到2层有两种方式：上到1层，再上一层；或上到2层；
     * 上到1层只有一种方式：上到1层；
     *@Author zhangshenming
     *@Param n
     *@Date 2021/8/31 22:19
     *@Return int
     */
    public  int climbStairs(int n) {
        int a = 1;
        int b = 0;
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        int sum = 0;
        for(int i = 2;i <= n;i++){
            sum = a + b;
            b = sum-b;
            a = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        ClimbingV1 climbingV1 = new ClimbingV1();
        int a = climbingV1.climbStairs(3);
        System.out.println(a);
    }

}
