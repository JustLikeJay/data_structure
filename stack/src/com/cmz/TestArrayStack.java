package com.cmz;

/**
 * @author cmz
 * @date 2022/11/29
 * @Description
 */
public class TestArrayStack {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.list();
        arrayStack.push(5);
        System.out.println("----------------");
        arrayStack.pop();
        arrayStack.list();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
    }
}
