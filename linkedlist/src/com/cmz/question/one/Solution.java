package com.cmz.question.one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cmz
 * @date 2022/11/28
 * @Description
 */
public class Solution {
    //两数相加 法1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)  {
        //初始化一个头节点
        ListNode head = new ListNode(0);
        //定义一个辅助指针
        ListNode tail = head;
        //定义一个进位符
        int carry = 0;

        //链表同时有值的部分计算
        while (l1 != null && l2 != null){
            int sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val) / 10;
            tail.next = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;
            tail = tail.next;
        }

        //较长链表的多余部分处理
        while (l1 != null){
            int sum = (carry + l1.val) % 10;
            carry = (carry + l1.val) / 10;
            tail.next = new ListNode(sum);
            l1 = l1.next;
            tail = tail.next;
        }

        while (l2 != null){
            int sum = (carry + l2.val) % 10;
            carry = (carry + l2.val) / 10;
            tail.next = new ListNode(sum);
            l2 = l2.next;
            tail = tail.next;
        }

        //最后一位刚好形成进位的情况
        if (carry == 1){
            tail.next = new ListNode(1);
        }


        return head.next;
    }
    //两数相加 法2
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        //定义一个新联表伪指针，用来指向头指针，返回结果
        ListNode prev = new ListNode(0);
        //定义一个进位数的指针，用来存储当两数之和大于10的时候，
        int carry = 0;
        //定义一个可移动的指针，用来指向存储两个数之和的位置
        ListNode cur = prev;
        //当l1 不等于null或l2 不等于空时，就进入循环
        while(l1!=null || l2!=null){
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int x= l1 !=null ? l1.val : 0;
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int y = l2 !=null ? l2.val : 0;
            //将两个链表的值，进行相加，并加上进位数
            int sum = x + y + carry;
            //计算进位数
            carry = sum / 10;
            //计算两个数的和，此时排除超过10的请况（大于10，取余数）
            sum = sum % 10;
            //将求和数赋值给新链表的节点，
            //注意这个时候不能直接将sum赋值给cur.next = sum。这时候会报，类型不匹配。
            //所以这个时候要创一个新的节点，将值赋予节点
            cur.next = new ListNode(sum);
            //将新链表的节点后移
            cur = cur.next;
            //当链表l1不等于null的时候，将l1 的节点后移
            if(l1 !=null){
                l1 = l1.next;
            }
            //当链表l2 不等于null的时候，将l2的节点后移
            if(l2 !=null){
                l2 = l2.next;
            }
        }
        //如果最后两个数，相加的时候有进位数的时候，就将进位数，赋予链表的新节点。
        //两数相加最多小于20，所以的的值最大只能时1
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        //返回链表的头节点
        return prev.next;
    }

    //移除链表倒数第n个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个数,用来记录链表个数
        int count = 0;
        //定义一个数,待会用来记录正数第几个
        int index;
        //定义一个辅助指针,用来遍历
        ListNode tail = head;

        //计算个数
        while (tail != null){
            count += 1;
            tail = tail.next;
        }

        //移除倒数第n个节点,相当于正数的 (1 + count) - n 的节点
        index = (1 + count) - n;

        //说明该链表有且只有一个节点
        if (index == 1 && n == 1){
            return null;
        }

        //如果移除的是第一个节点
        if (index == 1){
            return head.next;
        }


        //定义一个辅助指针,用来改变链表结构
        ListNode temp = head;
        for (int i = 1; i < index; i++) {
            if (i != index - 1) {
                temp = temp.next;
            }
        }
        temp.next = temp.next.next;


        return head;
    }


    //合并两个升序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null && temp2 != null){
            if (temp1.val < temp2.val){
                tail.next = temp1;
                temp1 = temp1.next;
            }else {
                tail.next = temp2;
                temp2 = temp2.next;
            }
            tail = tail.next;
        }
        tail.next = (temp1 != null ? temp1 : temp2);
        return head.next;
    }

    //合并k个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        //顺序合并
        /*ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoLists(ans, list);
        }
        return ans;*/
        //分治
        return merge(lists, 0, lists.length - 1);
    }

    //归并
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }


    //利用hashset的唯一性
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    //快慢指针
    public boolean hasCycle2(ListNode head){
        if (head == null){
            return false;
        }

        ListNode slow = head,fast = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return false;
            }

            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    //利用hashset的唯一性
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null){
            if (!seen.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }


    //快慢指针
    /*
        我们使用两个指针，fast与slou。它们起始都位于链表的头部。
        随后，slou指针每次向后移动一个位置，而fast指针向后移动两个位置。
        如果链表中存在环，则 fast 指针最终将再次与slow指针在环中相遇。

        设链表中环外部分的长度为a。slow指针进入环后，又走了b的距离与fast 相遇。
        此时，fast 指针已经走完了环的n圈，因此它走过的总距离为a＋ n(b+＋c)+b=a+(n+ 1)b＋nc。

        根据题意，任意时刻，fast 指针走过的距离都为slow指针的2倍。因此，我们有
        a＋(n＋1)b+nc= 2(a＋b)>a=c＋(n —1)(b＋c)
        有了a=c+(n- 1)(b+c)的等量关系，我们会发现:从相遇点到入环点的距离加上n-1圈的环长，恰好等于从链表头部到入环点的距离。
        因此，当发现 slou与fast 相遇时，我们再额外使用一个指针 ptr。
        起始，它指向链表头部;随后，它和slow每次向后移动一个位置。最终，它们会在入环点相遇。
   */
    public ListNode detectCycle2(ListNode head){
        if (head == null){
            return null;
        }
        ListNode slow = head,fast = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }

            if (fast == slow){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
