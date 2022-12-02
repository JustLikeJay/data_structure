package com.cmz.linkedlist;

/**
 * @author cmz
 * @date 2022/11/24
 * @Description
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");
        //创建节点
        Node2 node1 = new Node2(1, "小虎", "2200");
        Node2 node2 = new Node2(2, "左手", "懦手");
        Node2 node3 = new Node2(3, "JK", "敢打");
        Node2 updateNode1 = new Node2(3, "小老虎", "999");
        Node2 node4 = new Node2(4, "Wayward", "纳尔");

        //创建一个双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node2);
        System.out.println("原来的链表:");
        doubleLinkedList.list();

        //修改节点
        doubleLinkedList.update(updateNode1);
        System.out.println("修改后的链表:");
        doubleLinkedList.list();

        //删除节点
        doubleLinkedList.deleteNode(4);
        System.out.println("删除后的链表:");
        doubleLinkedList.list();
    }
}
