package category.ListProgramming;

import common.po.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yzchen
 * @create 2019-11-29
 * @desc
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 环形链表
 *
 *
 **/
public class HasCycle {

    /**
     * HashSet 处理就可以
     * **/
    public boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<ListNode>();

        while(head!=null){

            // 如果 最后一个 为空 ，那就是 false
            if(head.next == null){
                return false;
            }

            // 如果 在 set 中 存在那就是 true
            if (set.contains(head)){
                return true;
            }

            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 龟兔赛跑的问题，有环的话，先走的 会和 后走的相遇
     *
     * **/
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
