package com.cmz.linkedlist;

/**
 * @author cmz
 * @date 2022/11/24
 * @Description
 */
public class Josepfu {

    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个first节点,当前没有编号
    private Boy first = null;
    //添加小孩节点,构建成一个环形队列
    public void add(int nums){
        //对nums做一个数据验证
        if (nums < 1){
            System.out.println("输入的num值应该大于等于1");
            return;
        }
        Boy curBoy = null; //辅助指针,构建环形链表
        //使用for循环来创建环形链表
        for (int i = 1; i <= nums ; i++) {
            //根据编号,创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1){
                first = boy;
                first.setNext(first); //构成环
                curBoy = first;
            }else {
                //构成环
                curBoy.setNext(boy);
                boy.setNext(first);
                //辅助指针后移
                curBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy(){
        if (first == null){
            System.out.println("没有任何小孩");
            return;
        }

        //因为first不能动,所以需要一个辅助指针
        Boy curBoy = first;
        while (true){
            System.out.println("小孩的编号是" + curBoy.getNo());
            if (curBoy.getNext() == first){ //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();
        }

    }

    /**
     *
     * @param startNo 表示从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少个小孩
     */
    //根据用户的输入,计算出小孩出圈的顺序
    public void countBoy(int startNo,int countNum,int nums){
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("你的参数输入不合理,请重新输入");
            return;
        }
        Boy helper = first; //辅助指针,帮助完成出圈
        //事先应该指向环形链表的最后一个节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        //小孩报数前,先移动到开始位置,helper和first各移动startNo - 1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //小孩报数时,移动countNum - 1次,然后出圈
        //循环操作,直到剩下一个节点
        while (helper != first){
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first所指节点,就是要出圈的节点
            System.out.println("小孩" + first.getNo() + "出圈");
            //这时将小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后一个小孩编号是" + first.getNo());

    }
}


//创建一个Boy类,表示一个节点
class Boy{
    private int no; //编号
    private Boy next; //指向下一个节点,默认null

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
