package Aigo.Reverse.Linked.List;

import Aigo.POJO.ListNode;

import java.util.*;

/**
 *@Desprition 判断一个链表是否是回文结构，链表长度是N，时间复杂度O(N),额外空间复杂度O(1)
 *@Author zhangshenming
 *@Date 2021/10/7 22:42
 *@Version 1.0
 */
public class ReverseLinkListV1 extends ReverseLinkedListSuper {
    /**
     *@Description 使用list来保存linkedList的数据，然后遍历list
     *@Author zhangshenming
     *@Param head
     *@Date 2021/10/13 22:45
     *@Return boolean
     */
    public boolean isReversed(ListNode head){
        if(head == null){
            return false;
        }
        List<Integer>list = new ArrayList<Integer>();
        ListNode currNode = head;
        int count = 0;
        while(currNode != null){
            list.add(currNode.val);
            currNode = currNode.next;
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
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
//        ListNode node1 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ReverseLinkListV1 reverseLinkListV1 = new ReverseLinkListV1();
        boolean flag = reverseLinkListV1.isReversed(head);
        System.out.println("该链表是回文链表：" + flag);
    }
}
