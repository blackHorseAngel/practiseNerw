package Aigo.Complete.Circuit;

/**
 * @Description https://leetcode.cn/problems/gas-station
 * 在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 * @Author Administrator
 * @Date 2023/7/4 9:43
 * @Version 1.0.0
 */
public class CanCompleteCircuitV1 extends CanCompleteCircuitSuper{
    //TODO 比较慢
    @Override
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //汽油和损耗的和
        int len = gas.length;
        int sum = 0;
        if(len == 1){
            if(gas[0] - cost[0] <  0){
                return -1;
            }else {
                return 0;
            }
        }

        for (int i = 0; i < len; i++) {
           int temp = gas[i]-cost[i];
           if(temp == 0){
               continue;
           }else{
               sum += temp;
           }
            if(sum < 0){
                sum = 0;
                continue;
            }
            int index = i;
            while(true){
                index++;
                index = index%len;
                if(index == i){
                    break;
                }
                int a = gas[index] - cost[index];
                if(a == 0){
                    continue;
                }else{
                    sum += a;
                }
                if(sum < 0){
                    break;
                }
            }
            if(sum >= 0){
               return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CanCompleteCircuitV1 canCompleteCircuitV1 = new CanCompleteCircuitV1();
        //gas的下标3->0(最后回来之后没有油)
        int[]gas = {1,1, 1};
        int[]cost= {1, 1, 1};
//        int[]gas = {1,2,3,4,5};
//        int[]cost= {3,4,5,1,2};
        //-1(无论从哪出发都回不去)
//        int[]gas = {2,3,4};
//        int[]cost = {3,4,3};
        //0
//        int[]gas = {3,1,1};
//        int[]cost = {1,2,2};
        //
        int index = canCompleteCircuitV1.canCompleteCircuit(gas,cost);
        System.out.println(index);
    }
}
