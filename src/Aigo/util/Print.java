package Aigo.util;

import Aigo.FindMiddleNode;
import Aigo.POJO.ListNode;

/**
 *@Desprition 各种打印（打印一维数组，二维数组，链表，）
 *@Author zhangshenming
 *@Date 2021/8/18 9:24
 *@Version 1.0
 */
public class Print {
    /**
     *@Description 打印一维数组
     *@Author zhangshenming
     *@Param array
     *@Date 2021/8/17 23:31
     *@Return void
     */
    public static void printArray(int[] array) {
        System.out.print("数组中的元素：");
        for(int i : array){
            System.out.print(i+",");
        }
        System.out.println();
}
    /**
     *@Description 打印二维数组
     *@Author zhangshenming
     *@Param array
     *@Date 2021/8/14 16:36
     *@Return void
     */
    public static void printDoubleArray(int[][]array) {
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
//                System.out.println("数组序号是：" + x + y + " : " + array[x][y]);
                System.out.print(array[x][y]);
                if(array[x][y]<10){
                    System.out.print("   ");
                }else{
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }
    /**
     *@Description
     *@Author zhangshenming
     *@Param head
     *@Date 2021/10/3 18:03
     *@Return void
     */
    public static void printListNode(ListNode head){
        System.out.println("链表中的元素是：");
        ListNode nowNode = head;
        while(nowNode != null){
            System.out.println(nowNode.val);
            nowNode = nowNode.nextNode;
        }
    }
}
