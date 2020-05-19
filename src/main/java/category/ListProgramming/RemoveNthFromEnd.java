package category.ListProgramming;

import common.po.ListNode;

/**
 * @author yzchen
 * @create 2019-11-25
 * @desc
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 *
 * 删除链表的倒数第N个节点
 *
 **/
public class RemoveNthFromEnd {


    /**
     * 双指针 ,一次遍历
     *
     * 让 第二个点 和 第一个点 保持 n 个间距，当第一个指针到达末位时，第二个指针后面一个删除就可以了
     *
     * 卡 n 个间距
     * **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }








}
