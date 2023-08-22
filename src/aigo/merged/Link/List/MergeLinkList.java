package aigo.merged.Link.List;
import aigo.POJO.ListNode;
/**
 *@Desprition https://leetcode.cn/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *@Author zhangshenming
 *@Date 2021/10/7 9:48
 *@Version 1.0
 */
public class MergeLinkList extends MergeLinkedListSuper {

    /**
     *@Description 需要考虑两个链表的长度一致和不一致两个方面，每个链表引入一个指针，新和成的链表引入头部节点和一个指针即可
     *@Author zhangshenming
     *@Param l1, l2
     *@Date 2021/10/7 9:51
     *@Return Aigo.POJO.ListNode
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
           return null;
        }else if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode head = null;
        ListNode newNode = null;
        if(list1.val >= list2.val){
            head = list2;
            newNode = head;
            node2 = node2.next;
            while((node1 !=null) && (node2 != null)){
                if(node1.val >= node2.val){
                    newNode.next = node2;
                    node2 = node2.next;
                }else if(node1.val < node2.val){
                    newNode.next = node1;
                    node1 = node1.next;
                }
                   newNode = newNode.next;
            }
        }else{
            head = list1;
            newNode = head;
            node1 = node1.next;
            while((node1 !=null) && (node2 != null)){
                if(node1.val >= node2.val){
                    newNode.next = node2;
                    node2 = node2.next;
                }else if(node1.val < node2.val){
                    newNode.next = node1;
                    node1 = node1.next;
                }
                newNode = newNode.next;
            }
        }
        while(node1 != null){
            newNode.next = node1;
            node1 = node1.next;
            newNode = newNode.next;
        }
        while(node2 != null){
            newNode.next = node2;
            node2 = node2.next;
            newNode = newNode.next;
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
//        head1.next = node11;
//        node11.next = node12;
//        node12.next = node13;
//        node13.next = node14;
//        node14.next = node15;
//        node15.next = node16;
//        ListNode head2 = new ListNode(1);
//        ListNode node21 = new ListNode(2);
//        ListNode node22 = new ListNode(4);
//        ListNode node23 = new ListNode(6);
//        ListNode node24 = new ListNode(8);
//        ListNode node25 = new ListNode(10);
//        ListNode node26 = new ListNode(12);
//        ListNode node27 = new ListNode(14);
//        head2.next = node21;
//        node21.next = node22;
//        node22.next = node23;
//        node23.next = node24;
//        node24.next = node25;
//        node25.next = node26;
//        node26.next = node27;
        //链表1：[1,2,4] 链表2：[1,3,4]
        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        head1.next = node11;
        node11.next = node12;
        node12.next = null;
        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        head2.next = node21;
        node21.next = node22;
        node22.next = null;
        MergeLinkList mergeLinkList = new MergeLinkList();
        ListNode head3 = mergeLinkList.mergeTwoLists(head1,head2);
        System.out.println("合成的新的链表是：");
        ListNode node = head3;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
