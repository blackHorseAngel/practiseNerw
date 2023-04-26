package Aigo;

/**
 * @Description https://leetcode.cn/problems/container-with-most-water
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 *
 * 输入：height = [1,1]
 * 输出：1
 *n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 * @Author Administrator
 * @Date 2023/4/10 18:10
 * @Version 1.0.0
 */
public class MaxArea {
   //
    public static int maxArea(int[] height) {
        int p = 0;
        int q = height.length - 1;
        int area = 0;
        int capicity = 0;
        while( p < q){
            if(height[p] > height[q]){
                area = (q-p) * height[q];
                q--;
            }else{
                area = (q-p) * height[p];
                p++;
            }
            capicity = Math.max(area,capicity);
        }
        return capicity;
    }

    public static void main(String[] args) {
        //49
//        int[]height = {1,8,6,2,5,4,8,3,7};
        //1
        int[]height = {1,1};
        int max = maxArea(height);
        System.out.println(max);
    }
}
