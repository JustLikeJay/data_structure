package com.cmz.question.one;

/**
 * @author cmz
 * @date 2022/11/29
 * @Description
 */
public class Test {
    public static void main(String[] args) {

/*        ListNode node3 = new ListNode(3,null);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);


        ListNode node6 = new ListNode(6,null);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);

        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(node1, node4);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }*/

        ListNode[] listNodes = new ListNode[3];
        ListNode node3 = new ListNode(3,null);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        listNodes[0] = node1;

        ListNode node6 = new ListNode(6,null);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        listNodes[1] = node4;

        ListNode node9 = new ListNode(9,null);
        ListNode node8 = new ListNode(8,node9);
        listNodes[2] = node8;
        Solution solution = new Solution();
        ListNode node = solution.mergeKLists(listNodes);
        System.out.println(node);
    }
}
