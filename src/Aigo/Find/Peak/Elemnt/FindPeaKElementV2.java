package Aigo.Find.Peak.Elemnt;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 9:27
 * @Version 1.0.0
 */
public class FindPeaKElementV2 extends FindPeakElementSuper{
    /**
     * 二分法
     * @param nums
     * @return
     */
    public int findPeakElement2(int[]nums){
        return binarySearch(nums);
    }
    public int binarySearch(int[]nums){
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        int index = -1;
        while(left < right){
            middle = (right - left)/2 + left;
            if(comparator(nums,middle-1,middle) < 0 && comparator(nums,middle,middle+1) > 0){
                index = middle;
                break;
            }
            if(comparator(nums,middle,middle+1) < 0){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return index;
    }
    //用来处理边界情况
    public int[]get(int[]nums,int index){
        if(index == -1 || index == nums.length){
            return new int[]{0,0};
        }
        return new int[]{1,nums[index]};
    }
    public int comparator(int[]nums,int start,int end){
        int[]nums1 = get(nums,start);
        int[]nums2 = get(nums,end);
        if(nums1[0] != nums2[0]){
            return nums1[0] > nums2[0] ? 1 : -1;
        }
        if(nums1[1] == nums2[1]){
            return 0;
        }else{
            return nums1[1] > nums2[1] ? 1 : -1;
        }
    }
    public static void main(String[] args) {
        FindPeaKElementV2 findPeakElementV2 = new FindPeaKElementV2();
        int[]nums = {1,2,3,1};
//        int[]nums = {1,2,1,3,5,6,4};
        int peak = findPeakElementV2.findPeakElement(nums);
        System.out.println(peak);
    }
}
