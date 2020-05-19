package category.ListProgramming;

import common.po.ListNode;

/**
 * @author yzchen
 * @create 2019-11-26
 * @desc 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 *
 * 两两交换链表中的节点
 *
 **/
public class SwapPairs {


    public static ListNode doSwapPairs(ListNode head) {

       // 递归 : 类似于倒叙，从最底下开始计算 , 最前面的反而是最后计算
       //  返回 出去的  next 实际上是新的 head
       // head 和 next 的指针互换
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = doSwapPairs(next.next);
        next.next = head;
        return next;
    }



}
