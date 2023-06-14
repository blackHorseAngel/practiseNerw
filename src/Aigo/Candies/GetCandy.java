package Aigo.Candies;

import java.util.HashSet;
import java.util.Set;

/**
 *@Desprition
 * Alice有n枚糖,其中第i枚糖的类型为candyType[i].Alice注意到她的体重正在增长,所以前去拜访了一位医生。
 * 医生建议Alice要少摄入糖分,只吃掉她所有糖的n/2即可(n是一个偶数).Alice非常喜欢这些糖,她想要在遵循医生建议的情况下,尽可能吃到最多不同种类的糖。
 * 给你一个长度为n的整数数组candyType返回:Alice在仅吃掉n/2枚糖的情况下,可以吃到糖的最多种类数。
 * 输入：candyType=[1,1,2,2,3,3]
 * 输出：3
 * 解释：Alice只能吃6/2=3枚糖,由于只有3种糖,她可以每种吃一枚。
 * 输入：candyType=[1,1,2,3]
 * 输出：2
 * 解释：Alice只能吃4/2=2枚糖,不管她选择吃的种类是[1,2]、[1,3]还是[2,3]，她只能吃到两种不同类的糖。
 * 输入：candyType=[6,6,6,6]
 * 输出：1
 * 解释：Alice只能吃4/2=2枚糖,尽管她能吃2枚,但只能吃到1种糖。
 *@Author zhangshenming
 *@Date 2021/11/17 10:51
 *@Version 1.0
 */
public class GetCandy extends CandiedSuper {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i:candyType){
            set.add(i);
        }
        return Math.min(set.size(),candyType.length/2);
    }

    public static void main(String[] args) {
        //输出两种类型的糖果
        int[]candyType1 = {1,1,2,3};
        //输出3种类型的糖果
        int[]candyType2 = {1,1,2,2,3,3};
        //输出1种类型的糖果
        int[]candyType3 = {1,1,1,1};
        GetCandy getCandy = new GetCandy();
        int candyKind = getCandy.distributeCandies(candyType1);
        System.out.println("能够得到的糖果的种类最多是："+candyKind);
    }
}
