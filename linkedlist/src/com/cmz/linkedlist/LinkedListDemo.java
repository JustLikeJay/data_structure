package com.cmz.linkedlist;

/**
 * @author cmz
 * @date 2022/11/20
 * @Description
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        //测试
        //创建节点
        Node node1 = new Node(1, "小虎", "2200");
        Node node2 = new Node(7, "左手", "懦手");
        Node node3 = new Node(2, "JK", "敢打");
        Node node4 = new Node(5, "Wayward", "纳尔");

        Node updateNode1 = new Node(3, "小老虎", "999");

        LinkedList linkedList = new LinkedList();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.deleteNode(7);
        System.out.println("原来的链表1为:");
        linkedList.list();

        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(node3);
        linkedList1.add(node4);
        System.out.println("原来的链表2为:");
        linkedList1.list();


        /*System.out.println("合并后的链表为:");
        LinkedList mergeList = LinkedList.mergeList(linkedList.getHeadNode(), linkedList1.getHeadNode());
        mergeList.list();*/

/*        System.out.print("链表反转后:");
        LinkedList.reverseList(linkedList.getHeadNode());
        linkedList.list();*/

/*        System.out.println("测试逆序打印单链表");
        LinkedList.reversePrint(linkedList.getHeadNode());*/


/*        LinkedList linkedList1 = new LinkedList();
        linkedList1.addByOrder(node1);
        linkedList1.addByOrder(node3);
        linkedList1.addByOrder(node2);
        linkedList1.list();

        linkedList1.update(updateNode1);
        linkedList1.list();

        linkedList1.deleteNode(1);
        linkedList1.list();

        System.out.println("有效的节点个数为:" + LinkedList.getLen(linkedList1.getHeadNode()));

        Node lastIndexNode = linkedList1.findLastIndexNode(2, linkedList1.getHeadNode());
        System.out.println("倒数第2个节点为:" + lastIndexNode);*/


    }
}
