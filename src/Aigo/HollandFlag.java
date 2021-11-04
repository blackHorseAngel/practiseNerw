package Aigo;

/**
 *@Desprition 给定一个数组，将这个数组按照大于等于小于某个数的划分成三块区域。
 *@Author zhangshenming
 *@Date 2021/10/27 11:04
 *@Version 1.0
 */
public class HollandFlag {
    /**
     *@Description
     *@Author zhangshenming
     *@Param array
     *@Date 2021/10/27 11:04
     *@Return int[]
     */
    public static int[]handle(int[]array,int target){
        //创建该数组的左指针
        int left = 0;
        //创建该数组的右指针
        int right = array.length - 1;
        int temp1 = 0;
        while(left != right){
            if(array[left] == target || array[right] == target){
                break;
            }
            if(array[left] > target && array[right] < target){
                temp1 = array[left];
                array[left] = array[right];
                array[right] = temp1;
            }
            if(array[left] < target){
                left++;
            }
            if(array[right] > target){
                right--;
            }
        }
        int temp2 = 0;
        int index1 = 0;
        while(left != right){
            index1 = left+1;
            if(array[index1] > target){
                temp2 = array[index1];
                array[index1] = array[right];
                array[right] = temp2;
                left++;
                right--;
            }else if(array[index1] < target){
                temp2 = array[left];
                array[left] = array[index1];
                array[index1] = temp2;
                left++;
            }else if(array[index1] == target){
                left++;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[]array = {5,1,2,3,8,7,4,5,4,7,8,3,2,1,5};
        int[]arr = handle(array,5);
        for (int i:arr) {
            System.out.print(i+" ");
        }
    }
}
