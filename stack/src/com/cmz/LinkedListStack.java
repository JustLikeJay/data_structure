package com.cmz;

import java.util.Stack;

/**
 * @author cmz
 * @date 2022/11/30
 * @Description
 */
public class LinkedListStack {

    public int maxSize;

    //作为栈底,相当于头节点
    public LinkedListNode bottom = new LinkedListNode(0);


    public LinkedListStack(int maxSize){
        this.maxSize = maxSize;
    }


    //判断链表是否为空
    public boolean isEmpty(){
        return bottom.next == null;
    }

    //判断链表是否满
    public boolean isFull(){
        boolean result = false;
        int size = 0;
        LinkedListNode temp = bottom.next;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (size == maxSize){
            result = true;
        }
        return result;
    }

    //往栈中添加元素
    public void push(int value){
        if (isFull()){
            System.out.println("栈中元素已满,无法继续添加");
            return;
        }

        LinkedListNode node = new LinkedListNode(value);

        LinkedListNode temp = bottom;

        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = node;
    }

    //移除栈顶元素
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈中已经没有元素了");
        }

        LinkedListNode temp = bottom;
        while (temp.next.next != null){
            temp = temp.next;
        }

        int value = temp.next.value;
        temp.next = null;
        return value;
    }

    //遍历栈
    public void showAll(){
        if (isEmpty()){
            System.out.println("该表为空链表");
            return;
        }
        //创建一个栈,将各个节点压入栈
        Stack<LinkedListNode> stack = new Stack<>();
        LinkedListNode cur = bottom.next;
        //将链表的所有节点压入栈
        while (cur != null){
            stack.push(cur);
            cur = cur.next; //cur后移,压入下一个节点
        }
        //将栈中的节点进行遍历
        while (stack.size() > 0){
            System.out.println(stack.pop().value);
        }
    }
}
