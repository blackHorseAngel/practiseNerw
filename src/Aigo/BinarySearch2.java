package Aigo;


/**
 *@Desprition https://leetcode-cn.com/problems/search-insert-position/submissions/
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *@Author zhangshenming
 *@Date 2021/8/29 17:29
 *@Version 1.0
 */
public class BinarySearch2 {
    /**
     *@Description 查找出添加下一个元素的位置
     *@Author zhangshenming
     *@Param array
     *@Date 2021/8/29 17:32
     *@Return int
     */
    public static int searchInsert(int[] array,int target){
        int low = 0;
        int high = array.length-1;
        int mid = 0;
        if(target < array[0]){
            return 0;
        }else if(target > array[array.length-1]){
            return array.length;
        }
        while(true){
            mid = (low + high)/2;
            if(target > array[mid]){
                if(target < array[mid+1]){
                    return mid+1;
                }
                low = mid+1;
            }else if(target < array[mid]){
                if(target > array[mid-1]){
                    return mid;
                }
                high = mid-1;
            }else{
                return mid;
            }
        }
//        return -1;
    }

    public static void main(String[] args) {
//        int[]array = initArray(5);
//        Arrays.sort(array);
//        printArray(array);
        int[]array = {-3,0,3,5,9,12};
        int a = searchInsert(array,8);
        System.out.println("添加下一个元素的位置是："+a);

    }
}
