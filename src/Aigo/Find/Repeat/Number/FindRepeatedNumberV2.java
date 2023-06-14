package Aigo.Find.Repeat.Number;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 9:33
 * @Version 1.0.0
 */
public class FindRepeatedNumberV2 extends FindRepeatNumberSuper{
    /**
     *@Description 使用set进行排重操作
     *@Author zhangshenming
     *@Param array
     *@Date 2021/9/19 13:51
     *@Return int
     */
    public int find(int []array){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0;i < array.length;i++){
            if(set.contains(array[i])){
                return array[i];
            }else{
                set.add(array[i]);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        FindRepeatedNumberV2 findRepeatNumberV2 = new FindRepeatedNumberV2();
        int[]array = {1,3,9,7,4,6,6};
        int num = findRepeatNumberV2.find(array);
        System.out.println("查找到的重复的数字是：" + num);
    }
}
