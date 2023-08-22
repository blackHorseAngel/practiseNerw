package aigo.remove.LinkList.NNode;

import aigo.POJO.ListNode;

/**
 * @Description https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 输入：head = [1], n = 1
 * 输出：[]
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 进阶：你能尝试使用一趟扫描实现吗？
 * @Author Administrator
 * @Date 2023/6/17 8:54
 * @Version 1.0.0
 */
public class RemoveNNodeV1 extends RemoveNNodeSuper{
    @Override
    public ListNode removeNthFromEnd(final ListNode head, int n) {
        int count = 0;
        ListNode curNode = head;
        while(curNode != null){
            count++;
            curNode = curNode.next;
        }
        ListNode node = head;
        int actualCount = count - n;
            if(actualCount == 0){
                if(node.next != null){
                    return head.next;
                }else{
                    return null;
                }
            }
            int tempCount = 0;
            while(node != null){
                tempCount++;
                if(tempCount == actualCount){
                    node.next = node.next.next;
                break;
                }else{
                    node = node.next;
                }
            }
        return head;
    }

    public static void main(String[] args) {
        //1
//        ListNode headNode = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        headNode.next = node1;
//        ListNode node2 = new ListNode(3);
//        node1.next = node2;
//        ListNode node3 = new ListNode(4);
//        node2.next = node3;
//        ListNode node4 = new ListNode(5);
//        node3.next = node4;
//        int n = 2;
        //null
//        ListNode headNode = new ListNode(1);
//        int n = 1;
        //1
        ListNode headNode = new ListNode(1);
        ListNode node1 = new ListNode(2);
        headNode.next = node1;
        int n = 2;
        RemoveNNodeV1 removeNNodeV1 = new RemoveNNodeV1();
        ListNode head = removeNNodeV1.removeNthFromEnd(headNode,n);
        System.out.println(head.val);
    }
}
