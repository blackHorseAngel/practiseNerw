package Aigo.util;
import Aigo.POJO.ListNode;
import Aigo.POJO.TreeNode;

import java.util.Random;

/**
 *@Desprition 初始化一切（一维数组，二维数组，链表，）
 *@Author zhangshenming
 *@Date 2021/7/31 18:56
 *@Version 1.0
 */
public class Init {
    /**
     *@Description 初始化一个以为数组
     *@Author zhangshenming
     *@Param length
     *@Date 2021/8/17 23:29
     *@Return int[]
     */
    public static int[]initArray(int length){
        int[]array = new int[length];
        for (int i = 0 ; i < length ; i++){
            array[i] = new Random().nextInt(50);
        }
        return array;
    }
    /**
     *@Description 初始化二维数组
     *@Author zhangshenming
     *@Param length
     *@Date 2021/8/14 16:36
     *@Return int[][]
     */
    public static int[][]initMatrix(int length) {
        int[][] arr = new int[length][length];
        int m = 1;
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < length; x++) {
                arr[x][y] = m;
                m++;
            }
        }
        return arr;
    }
    /**
     * @decription 初始化一个空的二维数组
     * @author zhangshenming
     * @date 2021/12/22 17:38
     * @param length
     * @return int[][]
     */
    public static int[][]initBlankMatrix(int length){
        return new int[length][length];
    }

    /**
     *@Description 初始化链表--尾部插入
     *@Author zhangshenming
     *@Param n
     *@Date 2021/10/3 10:22
     *@Return void
     */
    public static void initNodeForTail(int n){
        ListNode head = new ListNode(1);
        for(int i = 2 ; i < n ; i++){
            ListNode node = new ListNode(i);
            head.next = node;
            head = head.next;
        }
    }
    /**
     *@Description 初始化链表--头部插入
     *@Author zhangshenming
     *@Param n
     *@Date 2021/10/3 16:28
     *@Return void
     */
    public static void initNodeForHead(int n){
        ListNode head = new ListNode(n);
        for(int i = n-1 ; i > 0 ; i--){
            ListNode node = new ListNode(i);
            node.next = head;
            head = node;
        }
    }

    /***
     *@Description TODO
     *@Author zhangshenming
     *@Param [n]
     *@Date 2021/11/28 14:21
     *@Return void
     */
    public static void initTreeNode(int n){
        TreeNode rootNode = new TreeNode(n);
    }
}
