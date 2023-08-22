package aigo.Complete.circuit;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/7/4 9:43
 * @Version 1.0.0
 */
public class CanCompleteCircuitSuper {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        return 0;
    }

    public static void main(String[] args) {
        CanCompleteCircuitSuper[] canCompleteCircuitSupers = {new CanCompleteCircuitV1(), new CanCompleteCircuitV2()};
        //gas的下标3->0(最后回来之后没有油)     -1(无论从哪出发都回不去)    0
        int[][] gas = {{1, 2, 3, 4, 5}, {2, 3, 4}, {3, 1, 1}};
        int[][] cost = {{3, 4, 5, 1, 2}, {3, 4, 3}, {1, 2, 2}};
        for (int i = 0; i < gas.length; i++) {
            for (CanCompleteCircuitSuper canCompleteCircuit : canCompleteCircuitSupers) {
                long startTime = System.currentTimeMillis();
                int result = canCompleteCircuit.canCompleteCircuit(gas[i], cost[i]);
                long endTime = System.currentTimeMillis();
                System.out.println(canCompleteCircuit.getClass().getName() + ":" + result);
                System.out.println(canCompleteCircuit.getClass().getName() + "运行时间是：" + (endTime - startTime));
            }
        }
    }
}
