package com.cmz;

/**
 * @author cmz
 * @date 2022/11/29
 * @Description
 */
public class ArrayStack {

    public int maxSize;
    public int[] stack;
    public int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public void push(int num){
        if (isFull()){
            System.out.println("栈已满,无法再存储更多数据");
            return;
        }
        top++;
        stack[top] = num;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空,没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list(){
        if (isEmpty()){
            System.out.println("栈中没有数据可以展示");
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.println(stack[i]);
        }
    }


    //返回栈顶元素的值
    public int peek(){
        return stack[top];
    }

    //判断是否是运算符
    public boolean isOp(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch =='('|| ch==')';
    }

    //返回运算符的优先级
    //数字越大,优先级越高
    public int priority(int op){
        if (op == '(' || op == ')'){
            return 2;
        }
        else if (op == '*' || op == '/'){
            return 1;
        }else if (op == '+' || op == '-'){
            return 0;
        }else {
            return -1; //假定当前表达式只有四则运算
        }
    }

    //计算
    public int cal(int num1,int num2,int op){
        int res = 0; //res用于存放计算结果
        switch (op){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 /num1;
                break;
        }
        return res;
    }



}
