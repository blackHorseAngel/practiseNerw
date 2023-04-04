package Aigo;

import Aigo.POJO.ListNode;

/**
 * @Description https://leetcode.cn/problems/add-two-numbers
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * @Author Administrator
 * @Date 2023/3/8 14:41
 * @Version 1.0.0
 */
public class AddTwoNumbers {
    //把l1和l2分别整理成两个字符串，然后进行大数加法
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //将链表1转成字符串str1
        String str1 = transfertoStr(l1);
        //将链表2转成字符串str2
        String str2 = transfertoStr(l2);
        //str2永远是比str1短的字符串
        String tempStr = "";
        if(str1.length() < str2.length()){
            tempStr = str1;
            str1 = str2;
            str2 = tempStr;
        }
        //两个字符串中的数字求和
        String sumStr = sum(str1,str2);
        //将求得的和字符串转换成链表
        ListNode node = transfertoLinkList(sumStr);
        return node;
    }

    private static ListNode transfertoLinkList(String str) {
        ListNode head = new ListNode(Integer.parseInt(String.valueOf(str.charAt(0))));
        ListNode firstNode = head;
        for (int i = 1 ; i <str.length() ; i++){
            ListNode curNode = new ListNode(Integer.parseInt(String.valueOf(str.charAt(i))));
            firstNode.nextNode = curNode;
            firstNode = firstNode.nextNode;
        }
        return head;
    }

    public static String sum(String str1, String str2) {
        StringBuilder builder = new StringBuilder();
        int temp = 0;
        int up = 0;
        for(int i = 0 ; i < str2.length() ; i++){
            temp = Integer.parseInt(String.valueOf(str2.charAt(i))) + Integer.parseInt(String.valueOf(str1.charAt(i))) + up;
            if(temp >= 10){
                temp = temp - 10;
                up = 1;
            }else{
                up = 0;
            }
            builder.append(temp);
        }
        for(int j = str2.length() ; j < str1.length() ; j++){
            temp = Integer.parseInt(String.valueOf(str1.charAt(j))) + up;
            if(temp >= 10){
                temp = temp - 10;
                up = 1;
            }else{
                up = 0;
            }
            builder.append(temp);
        }
        if(up == 1){
            builder.append(up);
        }
        String sumStr = builder.toString();
        return sumStr;
    }

    //将链表转换成字符串备用
    public static String transfertoStr(ListNode node){
        StringBuilder builder = new StringBuilder();
        String str = "";
        while(node != null){
            builder.append(node.val);
            node = node.nextNode;
        }
        str = builder.toString();
        return str;
    }
    public static void main(String[] args) {
        //807 head = 8
//        ListNode head1 = new ListNode(2);
//        ListNode listNode11 = new ListNode(4);
//        head1.nextNode = listNode11;
//        ListNode listNode12 = new ListNode(3);
//        listNode11.nextNode = listNode12;
//        listNode12.nextNode = null;
//        ListNode head2 = new ListNode(5);
//        ListNode listNode21 = new ListNode(6);
//        head2.nextNode = listNode21;
//        ListNode listNode22 = new ListNode(4);
//        listNode21.nextNode = listNode22;
//        listNode22.nextNode = null;
        //0 head=0
//        ListNode head1 = new ListNode(0);
//        head1.nextNode = null;
//        ListNode head2 = new ListNode(0);
//        head2.nextNode = null;
        //80009991 head = 8
        ListNode head1 = new ListNode(9);
        ListNode listNode11 = new ListNode(9);
        head1.nextNode = listNode11;
        ListNode listNode12 = new ListNode(9);
        listNode11.nextNode = listNode12;
        ListNode listNode13 = new ListNode(9);
        listNode12.nextNode = listNode13;
        ListNode listNode14 = new ListNode(9);
        listNode13.nextNode = listNode14;
        ListNode listNode15 = new ListNode(9);
        listNode14.nextNode = listNode15;
        ListNode listNode16 = new ListNode(9);
        listNode15.nextNode = listNode16;
        listNode16.nextNode = null;
        ListNode head2 = new ListNode(9);
        ListNode listNode21 = new ListNode(9);
        head2.nextNode = listNode21;
        ListNode listNode22 = new ListNode(9);
        listNode21.nextNode = listNode22;
        ListNode listNode23 = new ListNode(9);
        listNode22.nextNode = listNode23;
        listNode23.nextNode = null;
        ListNode node = addTwoNumbers(head1,head2);
        while(node != null){
            System.out.println(node.val);
            node = node.nextNode;
        }
    }


}
