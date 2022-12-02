package com.cmz.linkedlist;

import javafx.scene.chart.ValueAxis;

import java.util.Stack;

/**
 * @author cmz
 * @date 2022/11/20
 * @Description
 */

public class LinkedList {

    //初始化一个头节点
    private Node headNode = new Node(0,"","");

    public Node getHeadNode() {
        return headNode;
    }

    //添加节点到链表尾部
    //思路:要插入到链表的最后面,应该找到目前链表的最后一个节点
    //然后将其next域改为node节点
    public void add(Node node){
        //引入一个辅助变量temp,遍历目前的链表,找到最后一个节点
        Node temp = headNode;
        while (temp.next != null) {
            //temp.next==null时,说明找到了尾节点
            //未找到,继续向后移
            temp = temp.next;
        }
        temp.next = node;
    }

    //按顺序添加节点
    public void addByOrder(Node node){
        //引入一个辅助变量temp,找到要插入节点的前一个位置
        Node temp = headNode;
        boolean flag = false;

        while (true){
            if (temp.next == null){
                break;
            }else if (temp.next.no > node.no){
                flag = true;
                break;
            }else if (temp.next.no == node.no){
                System.out.printf("节点:%d已经存在,不可重复插入 \n",node.no);
                return;
            }
            temp = temp.next;
        }

        if (flag){
            node.next = temp.next;
        }
        temp.next = node;
    }

    //修改节点的信息,根据no编号来修改
    public void  update(Node node){
        Node temp = headNode;
        if (temp.next == null){
            System.out.println("该链表为空表,无法修改");
            return;
        }

        //自己写的
        while (true){
            if (temp.no == node.no){
                temp.name = node.name;
                temp.nickname = node.nickname;
                System.out.printf("节点%d已成功修改\n",node.no);
                break;
            }else if (temp.next == null){
                System.out.println("该节点不存在");
                break;
            }
            temp = temp.next;
        }

        //hsp
/*        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }

            if (temp.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.name = node.name;
            temp.nickname = node.nickname;
            System.out.printf("节点%d已成功修改\n",node.no);
        }else {
            System.out.println("该节点不存在");
        }*/

    }

    //删除节点
    public void deleteNode(int no){
        Node temp = headNode;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }

            if (temp.next.no == no){
                flag = true;
                break;
            }

            temp = temp.next; //temp后移,遍历
        }

        //判断flag
        if (flag){
            //可以删除
            temp.next = temp.next.next;
            System.out.printf("节点%d删除成功\n",no);
        }else {
            System.out.printf("要删除的节点:%d不存在\n",no);
        }

    }

    //获取单链表有效节点个数 (不计头节点)
    /**
     *
     * @param headNode 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLen(Node headNode){
        if (headNode.next == null){
            return 0; //空链表
        }
        int length = 0;
        Node cur = headNode.next;
        while (cur != null){
            length++;
            cur = cur.next; //遍历
        }

        return length;
    }

    //查找单链表的倒数第k个节点
    //思路分析:1.编写一个方法,接收一个head节点,同时接收一个index
    //2.index,表示是链表的倒数第index个节点
    //3.先把链表从到到尾遍历,求出链表的总长度
    //4.得到长度后,我们从链表的第一个开始遍历(size-index)个,就可以得到
    //5.如果找到了,则返回该节点,否则返回null
    public Node findLastIndexNode(int index,Node headNode){
        if (headNode.next == null){
            System.out.println("该链表为空链表");
            return null;
        }

        //第一次遍历,得到链表长度
        int len = getLen(headNode);

        if (index > len){
            System.out.println("输入的k大于链表长度");
            return null;
        }

        if (index <= 0){
            System.out.println("k应该大于等于0");
            return null;
        }

        //定义一个辅助变量temp,for循环定位到倒数的index
        Node cur = headNode.next;
        for (int i = 0; i < len - index; i++) {
            cur = cur.next;
        }

        return cur;
    }


    //单链表反转
    //思路:1.先定义一个节点 reverseHead = new Node();
    //2.从头到尾遍历原来的链表,每遍历一个节点,就将他取出,并放在新的链表的reverseHead的最前端
    //3.原来的链表的headNode.next = reverseHead.next;
    public static void reverseList(Node headNode){
        //如果当前链表为空链表,或者只有一个节点,无需翻转,直接返回
        if (headNode.next == null || headNode.next.next == null){
            return;
        }

        //定义一个辅助的变量,帮助我们遍历原来的链表
        Node cur = headNode.next;
        Node next; //指向当前节点的下一个节点
        Node reverseHead = new Node(0, "", "");


        while (cur != null){
            //next指向原表当前节点的下一个节点
            next = cur.next;

            //插到reverseHead的最前端
            cur.next = reverseHead.next;
            reverseHead.next = cur;

            //将下一个节点的地址赋给cur
            cur = next;
        }
        headNode.next = reverseHead.next;

    }


    //从尾到头打印单链表
    //思路:1.上面的题目要求就是逆序打印单链表
    //方法1:先将单链表进行反转操作,然后再遍历即可.这样做带来的问题是会破坏原来的单链表的结构,不推荐
    //方法2:可以利用栈这个数据结构,将各个节点压入栈中,然后利用栈的先进后出的结构特点,就实现了逆序打印的效果
    public static void reversePrint(Node headNode){
        if (headNode.next == null){
            return; //空链表,无法打印
        }
        //创建一个栈,将各个节点压入栈
        Stack<Node> stack = new Stack<>();
        Node cur = headNode.next;
        //将链表的所有节点压入栈
        while (cur != null){
            stack.push(cur);
            cur = cur.next; //cur后移,压入下一个节点
        }
        //将栈中的节点进行遍历
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }


    //合并两个有序单链表,要求合并之后仍然有序
    public static LinkedList mergeList(Node headNode1,Node headNode2){
        LinkedList linkedList = new LinkedList();
        Node temp = linkedList.headNode;


        if (headNode1.next == null && headNode2.next == null){
            System.out.println("两个都是空链表");
            return linkedList;
        }

        Node next1 = headNode1.next;
        Node next2 = headNode2.next;
        while (next1 != null && next2 != null){
            if (next1.no < next2.no){
                temp.next = next1;
                temp = temp.next;
                next1= next1.next;
            }else {
                temp.next = next2;
                temp = temp.next;
                next2= next2.next;
            }
        }

        while (next1 != null){
            temp.next = next1;
            next1 = next1.next;
            temp = temp.next;
        }

        while (next2 != null){
            temp.next = next2;
            next2 = next2.next;
            temp = temp.next;
        }
        return linkedList;
    }


    //显示链表[遍历]
    public void list(){
        //判断链表是否未空
        if (headNode.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动,因此我们需要一个辅助变量temp用来遍历

        //由于链表不为空,所以至少有一个元素
        Node temp = headNode.next;

        //遍历链表,当temp.next == null,说明已经到达尾部
        while (temp != null){

            //输出
            System.out.println(temp);

            //后移
            temp = temp.next;
        }


    }
}
