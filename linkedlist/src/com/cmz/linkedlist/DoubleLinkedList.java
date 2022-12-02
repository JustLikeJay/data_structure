package com.cmz.linkedlist;

/**
 * @author cmz
 * @date 2022/11/24
 * @Description
 */
public class DoubleLinkedList {

    //初始化一个头节点
    private Node2 headNode = new Node2(0,"","");

    //得到头节点
    public Node2 getHeadNode() {
        return headNode;
    }

    //按顺序添加节点
    public void addByOrder(Node2 node){
        //引入一个辅助变量temp,找到要插入节点的前一个位置
        Node2 temp = headNode;
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
            temp.next.pre = node;
        }
        temp.next = node;
        node.pre = temp;
    }

    //添加节点到链表尾部
    public void add(Node2 node){
        //引入一个辅助变量temp,遍历目前的链表,找到最后一个节点
        Node2 temp = headNode;
        while (temp.next != null) {
            //temp.next==null时,说明找到了尾节点
            //未找到,继续向后移
            temp = temp.next;
        }
        //当退出while循环时,temp就指向了链表的最后
        //形成一个双向链表
        temp.next = node;
        node.pre = temp;
    }

    //修改节点的信息,根据no编号来修改
    public void update(Node2 node){
        Node2 temp = headNode;
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

    //从双向链表中删除一个节点
    //对于双向链表,直接找到要删除的节点
    //找到后,自我删除即可
    public void deleteNode(int no){
        Node2 temp = headNode.next;
        boolean flag = false;
        while (true){
            if (temp == null){ //已经到链表最后节点的next
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next; //temp后移,遍历
        }

        //判断flag
        if (flag){
            //可以删除
            temp.pre.next = temp.next;
            //如果是最后一个节点,执行下面语句会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
            System.out.printf("节点%d删除成功\n",no);
        }else {
            System.out.printf("要删除的节点:%d不存在\n",no);
        }

    }



    //遍历双向链表
    //显示链表[遍历]
    public void list(){
        //判断链表是否未空
        if (headNode.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动,因此我们需要一个辅助变量temp用来遍历

        //由于链表不为空,所以至少有一个元素
        Node2 temp = headNode.next;

        //遍历链表,当temp.next == null,说明已经到达尾部
        while (temp != null){

            //输出
            System.out.println(temp);

            //后移
            temp = temp.next;
        }


    }
}
