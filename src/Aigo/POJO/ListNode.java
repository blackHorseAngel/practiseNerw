package Aigo.POJO;
/**
 *@Desprition 链表实体类
 *@Author zhangshenming
 *@Date 2021/7/31 18:57
 *@Version 1.0
 */
public class ListNode {
    /**
     *@Description 链表中当前节点的值
     *@Author zhangshenming
     *@Date 2021/7/31 19:10
     */
    public int val;
    /**
     *@Description 链表中当前节点的指针
     *@Author zhangshenming
     *@Date 2021/7/31 19:11
     */
    public ListNode nextNode;
    /**
     *@Description 链表的有参构造函数
     *@Author zhangshenming
     *@Date 2021/7/31 19:11
     */
    public ListNode(int val) {
        this.val = val;
    }

    /***
     *@Description 带俩个参数的构造器
     *@Author zhangshenming
     *@Param  val
     *@param  next
     *@Date 2021/10/2 9:57
     *@Return
     */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.nextNode = nextNode;
    }
}
