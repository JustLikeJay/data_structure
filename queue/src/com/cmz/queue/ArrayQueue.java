package com.cmz.queue;

/**
 * @author cmz
 * @date 2022/11/17
 * @Description
 */
public class ArrayQueue {

    private int maxSize; //表示数组的最大容量
    private int front; //指向队列头前面的一个位置
    private int rear; //指向队列尾
    private int[] arr; //该数组用于存放数据,模拟队列


    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满,不能再加入数据了");
            return;
        }
        rear++;
        arr[rear] = n;
    }


    //数据出队列
    public int getQueue(){
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空,不能取数据");
        }
        front++; //front后移
        return arr[front];
    }
    
    //展示所有数据
    public void displayQueue(){
        if (isEmpty()){
            System.out.println("队列为空,没有数据");
            return;
        }
        for (int i = front + 1; i < rear + 1; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,没有数据");
        }
        return arr[front + 1];
    }

}
