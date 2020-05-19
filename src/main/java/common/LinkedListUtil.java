package common;

import common.po.ListNode;

/**
 * @author yzchen
 * @create 2019-05-10
 * @desc
 **/
public class LinkedListUtil {

    /**
     * 创建一个普通的 整数链表
     **/
    public static ListNode createCommonIntOne(int[] nums) {
        int size = nums.length;
        ListNode head = new ListNode(0);
        head.setVal(nums[0]);
        head.setNext(null);
        ListNode tail = head;

        for (int i = 1; i < size; i++) {
            ListNode node = new ListNode(0);
            node.setVal(nums[i]);
            node.setNext(null);
            tail.setNext(node);
            tail = node;
            if(i==1){
                head.setNext(tail);
            }
        }
        return head;
    }

    public static void main(String [] args){

        // 这边check 一下 链表的生成
        int [] nums = {2,3,4,9,1,11};
        ListNode node = createCommonIntOne(nums);

        while (node != null){
            System.out.println(node.getVal());
            node = node.getNext();
        }

    }





}
