package aigo.Complete.circuit;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/7/24 7:32
 * @Version 1.0.0
 */
public class CanCompleteCircuitV2 extends CanCompleteCircuitSuper {
    private int len = 0;
    private int[]gasConsumption;
    @Override
    public int canCompleteCircuit(int[] gas, int[] cost) {
        len = gas.length;
        gasConsumption = new int[len];
        //汽油和损耗的和
        for (int i = 0; i < len; i++) {
            int remaining = 0;
            int index = i;
            while (true) {
                int temp = gas[index] - cost[index];
                gasConsumption[index] = temp;
                remaining += temp;
                if (remaining < 0) {
                    break;
                }
                if(i>0){

                }
                index++;
                index = index % len;
                if (index == i) {
                    if (remaining >= 0) {
                        return index;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[100000];
        int[] cost = new int[100000];
        for (int i = 0; i < 100000; i++) {
            if (i == 99999) {
                gas[i] = 2;
            }
            if (i == 99998) {
                cost[i] = 1;
            }
        }
//        printArray(gas);
//        System.out.println("-----------------------------------------");
//        printArray(cost);
        System.out.println(new CanCompleteCircuitV2().canCompleteCircuit(gas,cost));
    }
}
