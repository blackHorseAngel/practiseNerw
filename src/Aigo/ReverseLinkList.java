package Aigo;

import Aigo.POJO.ListNode;

import java.util.*;

/**
 *@Desprition 判断一个链表是否是回文结构，链表长度是N，时间复杂度O(N),额外空间复杂度O(1)
 *@Author zhangshenming
 *@Date 2021/10/7 22:42
 *@Version 1.0
 */
public class ReverseLinkList {
    /**
     *@Description
     *@Author zhangshenming
     *@Param head
     *@Date 2021/10/13 22:45
     *@Return boolean
     */
    public static boolean isReversed2(ListNode head){
        if(head == null){
            return false;
        }
        List<Integer>list = new ArrayList<Integer>();
        ListNode currNode = head;
        int count = 0;
        while(currNode != null){
            list.add(currNode.val);
            currNode = currNode.nextNode;
        }
        boolean flag = false;
        for(int i = 0;i < list.size();i++){
            if(list.get(i).equals(list.get(list.size() - 1 - i))){
                flag = true;
            }else{
                break;
            }
        }
        return flag;
    }
    /**
     *@Description 借助栈的先进后出的规则来实现
     *@Author zhangshenming
     *@Param head
     *@Date 2021/10/7 22:44
     *@Return boolean
     */
    public static boolean isReversed1(ListNode head){
        if(head == null){
            return false;
        }
        Stack<Integer>stack = new Stack<Integer>();
        ListNode node = head;
        while(node != null){
            stack.push(node.val);
            node = node.nextNode;
        }
        ListNode newNode = head;
        boolean flag = true;
        while(newNode != null){
            if(newNode.val == stack.pop()){
                newNode = newNode.nextNode;
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }
    /**
     *@Description 保证空间复杂度为1
     *@Author zhangshenming
     *@Param head
     *@Date 2021/10/7 23:27
     *@Return boolean
     */
    public static boolean isReversed3(ListNode head){
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode != null){
            
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
//        ListNode node1 = new ListNode(2);
        head.nextNode = node1;
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = null;
        boolean flag1 = isReversed1(head);
        System.out.println("该链表是回文链表：" + flag1);
        boolean flag2 = isReversed2(head);
        System.out.println("该链表是回文链表：" + flag2);
    }
}
