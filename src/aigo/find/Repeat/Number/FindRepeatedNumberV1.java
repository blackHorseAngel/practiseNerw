package aigo.find.Repeat.Number;

import java.util.Arrays;

/**
 *@Desprition 给定一个包含 n + 1个整数的数组nums,其数字都在1到n之间(包括1和n),可知至少存在一个重复的整数。
 *假设nums只有一个重复的整数,找出这个重复的数.必须不修改数组nums且只用常量级O(1)的额外空间。
 *@Author zhangshenming
 *@Date 2021/9/18 22:39
 *@Version 1.0
 */
public class FindRepeatedNumberV1 extends FindRepeatNumberSuper {
    /**
     *@Description 先把数组排序，外层循环遍历数组中的每个数，内存循环使用二分查找法
     *@Author zhangshenming
     *@Param array
     *@Date 2021/9/18 22:40
     *@Return int
     */
    public int find(int[]array){
        if(array.length < 2){
            System.out.println("数组中元素是0或者只有一个元素，没有重复元素");
            return 0;
        }
        Arrays.sort(array);
        int temp = 0;
        int start = 0;
        int end = 0;
        int middle = 0;
        boolean flag = false;
        for(int i = 0 ; i < array.length ; i++){
            temp = array[i];
            start = i + 1;
            end = array.length-1;
            while(start < end){
                middle = (start+end)>>1;
                if(temp > array[middle]){
                    start = middle++;
                }else if(temp < array[middle]){
                    end = middle--;
                }else{
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        FindRepeatedNumberV1 findRepeatNumberV1 = new FindRepeatedNumberV1();
        int[]array = {1,3,9,7,4,6,6};
        int num = findRepeatNumberV1.find(array);
//        int num2 = find2(array);
        System.out.println("查找到的重复的数字是：" + num);
    }
}
