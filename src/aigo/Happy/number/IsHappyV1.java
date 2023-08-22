package aigo.Happy.number;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description https://leetcode.cn/problems/happy-number
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 输入：n = 2
 * 输出：false
 * 1 <= n <= 231 - 1
 * @Author Administrator
 * @Date 2023/7/3 18:03
 * @Version 1.0.0
 */
public class IsHappyV1 extends IsHappySuper{
    @Override
    public boolean isHappy(int n) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        return judgeNumber(n,map);
    }

    /**
     *
     * @param n
     * @param map
     * @return
     */
    private boolean  judgeNumber(int n,Map<Integer,Integer> map) {
        if(n == 1){
            return true;
        }
        //求和的结果
        int sum = 0;
        int num = n;
        while(num != 0){
            int a = num % 10;
            num /= 10;
            sum += Math.pow(a,2);
        }
        if(map.containsKey(sum)){
           return false;
        }else{
            map.put(sum,1);
        }
        boolean f = judgeNumber(sum,map);
        if(f){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        IsHappyV1 isHappyV1 = new IsHappyV1();
        //true false
//        int[]n = new int[]{19,2};
//        for (int i = 0; i < n.length; i++) {
//            boolean flag = isHappyV1.isHappy(n[i]);
//            System.out.println(flag);
//
//        }
        System.out.println(isHappyV1.isHappy(2));
    }
}
