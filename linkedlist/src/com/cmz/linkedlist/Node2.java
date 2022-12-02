package com.cmz.linkedlist;

/**
 * @author cmz
 * @date 2022/11/24
 * @Description
 */
public class Node2 {
    public int no; //排名
    public String name; //名字
    public String nickname; //昵称
    public Node2 next; //指向下个节点,默认为null
    public Node2 pre; //指向上个节点,默认为null

    //构造器
    public Node2(int no, String name, String nickname) {
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
