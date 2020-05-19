package category.ListProgramming;

/**
 * @author yzchen
 * @create 2019-11-26
 * @desc
 **/
public class MergeKLists {


    public static class ListNode{

        int val;

        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }


    /**
     * 分治法 + 递归
     *
     * **/
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right){
            return lists[left];
        }

        int mid = (left + right) / 2;

        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }


}
