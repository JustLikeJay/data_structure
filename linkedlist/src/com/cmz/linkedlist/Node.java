package com.cmz.linkedlist;

/**
 * @author cmz
 * @date 2022/11/20
 * @Description
 */
public class Node {
    public int no; //排名
    public String name; //名字
    public String nickname; //昵称
    public Node next; //指向下个节点

    //构造器
    public Node(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + "}";
    }


}
