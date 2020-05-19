package category.ListProgramming;

import common.po.ListNode;

/**
 * @author yzchen
 * @create 2019-11-28
 * @desc 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 反转一个单链表
 **/
public class ReverseList {


    /**
     * 正常算法
     *
     * curr 是一个 不停往后移动的指针
     * prev 是 curr 前一个节点
     * temp 是 curr 的后一个节点
     *
     * curr 往后挪，接着 prev 往后挪
     *
     * 顺序 : temp , curr.next , pre , curr
     * **/
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


    /**
     * 递归处理
     * **/
    public static ListNode reverse1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // p 其实就是最后 一个元素，然后被当成 新的 head 从下面一直传到了最上层
        ListNode p = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
