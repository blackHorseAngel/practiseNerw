package aigo.find.Middle.Node;

import aigo.POJO.ListNode;

/**
 *@Desprition https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 给定一个头结点为head的非空单链表,返回链表的中间结点.如果有两个中间结点,则返回第二个中间结点。
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 * 链表的结点数范围是 [1, 100]
 * 1 <= Node.val <= 100
 *@Author zhangshenming
 *@Date 2021/9/19 14:47
 *@Version 1.0
 */
public class FindMiddleNodeV1 extends FindMiddleNodeSuper {

 /**
  *@Description 两次遍历，第一次找出链表的长度，第二次找出中间值，其中根据长度的奇偶情况
  *@Author zhangshenming
  *@Param head
  *@Date 2021/10/3 11:00
  *@Return Aigo.Find.Middle.Node.FindMiddleNode.ListNode
  */
    public ListNode middleNode(ListNode head) {
      int length = 1;
      int index = 0;
      ListNode pNode = head;
      while(pNode.next != null){
          length++;
          pNode = pNode.next;
      }
      ListNode qNode = head;
       index = length/2;
          for (int i = 1;i <= index;i++){
                qNode = qNode.next;
          }
        return qNode;
    }

    public static void main(String[] args) {
        FindMiddleNodeV1 findMiddleNodeV1 = new FindMiddleNodeV1();
        /*ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 2;i <= 5;i++){
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }*/
        /*ListNode nowNode = head;
        while(nowNode != null){
              System.out.print(nowNode.val);
              nowNode = nowNode.next;
          }*/
        ListNode head = new ListNode(5);
        for(int i = 4;i > 0;i--){
            ListNode node = new ListNode(i);
            node.next = head;
            head = node;
        }
        System.out.println("链表中的元素是：");
        ListNode nowNode = head;
        while(nowNode != null){
            System.out.println(nowNode.val);
            nowNode = nowNode.next;
        }
        ListNode node = findMiddleNodeV1.middleNode(head);
        System.out.println("-------------------------------");
        System.out.println(node.val);
    }
}
