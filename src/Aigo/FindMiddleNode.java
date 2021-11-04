package Aigo;

/**
 *@Desprition https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *给定一个头结点为head的非空单链表,返回链表的中间结点.如果有两个中间结点,则返回第二个中间结点。
 *@Author zhangshenming
 *@Date 2021/9/19 14:47
 *@Version 1.0
 */
public class FindMiddleNode {
  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 /**
  *@Description 两次遍历，第一次找出链表的长度，第二次找出中间值，其中根据长度的奇偶情况
  *@Author zhangshenming
  *@Param head
  *@Date 2021/10/3 11:00
  *@Return Aigo.FindMiddleNode.ListNode
  */
    public static ListNode middleNode(ListNode head) {
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
        ListNode node = middleNode(head);
        System.out.println("-------------------------------");
        System.out.println(node.val);
    }
/*
    private static ListNode arr2list(int arr[]){
      ListNode head = new ListNode();
      head.val = arr[0];
      head.next = null;
      ListNode tail = head;
      for (int index=1; index<arr.length){
          ListNode node = new ListNode();
          node.next = null;
          node.val = arr[index];
          tail.next = node;
          tail = node;
      }
      return head;
    }*/
}
