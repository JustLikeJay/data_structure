package com.cmz;

/**
 * @author cmz
 * @date 2022/11/30
 * @Description
 */
public class LinkedListStackDemo {

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack(4);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.showAll();
        stack.push(5);
        int pop1 = stack.pop();
        System.out.println(pop1);
        int pop2 = stack.pop();
        System.out.println(pop2);
        int pop3 = stack.pop();
        System.out.println(pop3);
        int pop4 = stack.pop();
        System.out.println(pop4);
        stack.pop();



    }
}
