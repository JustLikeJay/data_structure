package com.cmz.queue;

import java.util.Scanner;

/**
 * @author cmz
 * @date 2022/11/18
 * @Description
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列");
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArrayQueue.displayQueue();
                    break;
                case 'a':
                    System.out.print("请输入一个数:");
                    int i = scanner.nextInt();
                    circleArrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int res = circleArrayQueue.getQueue();
                        System.out.println("取出的数据是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArrayQueue.headQueue();
                        System.out.println("队列头的数据是:" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
