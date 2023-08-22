package aigo.Stack.queue;

import java.util.Stack;

/**
 * @Description https://leetcode.cn/problems/implement-queue-using-stacks/
 * 用两个栈实现队列
 * @Author Administrator
 * @Date 2023/2/22 18:51
 * @Version 1.0.0
 */
public class StackToQueue {
    //输入用
     private Stack<Integer>stackFrom = new Stack<>();
     //输出转换用
     private Stack<Integer>stackTo = new Stack<>();
    //初始化
    public StackToQueue() {

    }
    //往队列中存数
    public void push(int x) {
        stackFrom.push(x);
    }
    //从队列中取数
    public int pop() {
        int a = 0;
        int temp = 0;
        while(stackFrom.size() != 0){
            temp = stackFrom.pop();
            stackTo.push(temp);
        }
        a = stackTo.pop();
        return a;
    }

    public int peek() {
        int a = 0;
        int temp = 0;
        while(stackFrom.size() != 0){
            temp = stackFrom.pop();
            stackTo.push(temp);
        }
        a = stackTo.peek();
       return a;
    }

    public boolean empty() {
        if(stackTo.size() == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StackToQueue stq = new StackToQueue();
        stq.push(1);
        stq.push(2);
        int a = stq.peek();
        System.out.println(a);
        int b = stq.pop();
        System.out.println(b);
        System.out.println(stq.empty());
        stq.pop();
        System.out.println(stq.empty());

    }
}
