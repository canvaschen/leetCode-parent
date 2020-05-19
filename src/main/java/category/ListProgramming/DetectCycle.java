package category.ListProgramming;

import common.po.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yzchen
 * @create 2019-12-12
 * @desc
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 环形链表 II
 *
 **/
public class DetectCycle {

    /**
     *
     * hash 方法
     * **/
    public ListNode detectCycle(ListNode head) {

        // 获取入环点
        Set<ListNode> set = new HashSet<>();

        while(head!= null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }


    /**
     *  --------------------------------------  分割线  ------------------------------------------
     *
     * 因为是要 输出 节点数据 ，所有 分成两步
     *
     * 找到相遇点，获取入环节点
     *
     * 相遇点可以在 任何位置，但是 入环点只有一个
     *
     * 同一起点,快指针走了 慢指针两倍的路，然后，慢指针从头开始 ，快指针从 相遇点 (中点)开始，以相同的速度往前跑。他们在往各自的 target (入环点前进)，他们会同时到达
     *
     * 其实 类似于 复制了一条赛道
     *
     * 为什么一开始，快指针不在中点直接走，因为 有环，算不出来长度，copy 不了赛道
     *
     * **/
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode intersect = null;
        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                intersect = tortoise;
                break;
            }
        }

        if (intersect == null) {
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }




}
