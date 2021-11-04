package Aigo;
import Aigo.POJO.ListNode;
/**
 *@Desprition 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *@Author zhangshenming
 *@Date 2021/10/7 9:48
 *@Version 1.0
 */
public class MergeLinkList {
    /**
     *@Description 需要考虑两个链表的长度一致和不一致两个方面，每个链表引入一个指针，新和成的链表引入头部节点和一个指针即可
     *@Author zhangshenming
     *@Param l1, l2
     *@Date 2021/10/7 9:51
     *@Return Aigo.POJO.ListNode
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
           return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head = null;
        ListNode newNode = null;
        if(l1.val >= l2.val){
            head = l2;
            newNode = head;
            node2 = node2.nextNode;
            while((node1 !=null) && (node2 != null)){
                if(node1.val >= node2.val){
                    newNode.nextNode = node2;
                    node2 = node2.nextNode;
                }else if(node1.val < node2.val){
                    newNode.nextNode = node1;
                    node1 = node1.nextNode;
                }
                   newNode = newNode.nextNode;
            }
        }else{
            head = l1;
            newNode = head;
            node1 = node1.nextNode;
            while((node1 !=null) && (node2 != null)){
                if(node1.val >= node2.val){
                    newNode.nextNode = node2;
                    node2 = node2.nextNode;
                }else if(node1.val < node2.val){
                    newNode.nextNode = node1;
                    node1 = node1.nextNode;
                }
                newNode = newNode.nextNode;
            }
        }
        while(node1 != null){
            newNode.nextNode = node1;
            node1 = node1.nextNode;
            newNode = newNode.nextNode;
        }
        while(node2 != null){
            newNode.nextNode = node2;
            node2 = node2.nextNode;
            newNode = newNode.nextNode;
        }
        return head;
    }

    public static void main(String[] args) {
        //链表1：[1,2,5,7,9,10,11],链表2：[1,2,4,6,8,10,12]
//        ListNode head1 = new ListNode(1);
//        ListNode node11 = new ListNode(3);
//        ListNode node12 = new ListNode(5);
//        ListNode node13 = new ListNode(7);
//        ListNode node14 = new ListNode(9);
//        ListNode node15 = new ListNode(10);
//        ListNode node16 = new ListNode(11);
//        head1.nextNode = node11;
//        node11.nextNode = node12;
//        node12.nextNode = node13;
//        node13.nextNode = node14;
//        node14.nextNode = node15;
//        node15.nextNode = node16;
//        ListNode head2 = new ListNode(1);
//        ListNode node21 = new ListNode(2);
//        ListNode node22 = new ListNode(4);
//        ListNode node23 = new ListNode(6);
//        ListNode node24 = new ListNode(8);
//        ListNode node25 = new ListNode(10);
//        ListNode node26 = new ListNode(12);
//        ListNode node27 = new ListNode(14);
//        head2.nextNode = node21;
//        node21.nextNode = node22;
//        node22.nextNode = node23;
//        node23.nextNode = node24;
//        node24.nextNode = node25;
//        node25.nextNode = node26;
//        node26.nextNode = node27;
        //链表1：[1,2,4] 链表2：[1,3,4]
        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        head1.nextNode = node11;
        node11.nextNode = node12;
        node12.nextNode = null;
        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        head2.nextNode = node21;
        node21.nextNode = node22;
        node22.nextNode = null;
        ListNode head3 = mergeTwoLists(head1,head2);
        System.out.println("合成的新的链表是：");
        ListNode node = head3;
        while(node != null){
            System.out.println(node.val);
            node = node.nextNode;
        }
    }
}
