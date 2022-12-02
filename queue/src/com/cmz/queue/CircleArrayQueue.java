package com.cmz.queue;

/**
 * @author cmz
 * @date 2022/11/18
 * @Description
 */
public class CircleArrayQueue {

    private int maxSize; //表示数组的最大容量
    private int front; //指向队列头
    private int rear; //指向队列尾后面的一个位置
    private int[] arr; //该数组用于存放数据,模拟队列


    //创建队列的构造器
    public CircleArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否为满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }


    //数据出队列
    public int getQueue(){
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空,不能取数据");
        }
        int res = arr[front];
        front = (front + 1) % maxSize;
        return res;
    }

    //展示所有数据
    public void displayQueue(){
        if (isEmpty()){
            System.out.println("队列为空,没有数据");
            return;
        }
        int size = (rear + maxSize - front) % maxSize;
        for (int i = front; i < front + size; i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,没有数据");
        }
        return arr[front];
    }
}
