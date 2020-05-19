package category.ArrayProgramming;

/**
 * @author yzchen
 * @create 2020-05-08
 * @desc
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 *
 * 说明:
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 *
 * 寻找重复数
 *
 **/
public class FindDuplicate {



    /**
     *
     * 普通思维 : HashSet (但是 ，空间复杂度要求没有过)
     *
     * 弗洛伊德的乌龟和兔子（循环检测）
     *
     * 关键在于 nums[i] value 在 1 到 n 之间 : 如果每一个 value 都不一样 .. 那么可以遍历整个列表而不相遇，否则 ，一定会相遇
     *
     * **/
    public int findDuplicate(int[] nums) {

        int tortoise = nums[0];
        int hare = nums[0];

        // 找到入环点
        while (tortoise != hare){

            // 走一步，和 走两步的人 终究会相遇
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }

        // 找到重复数据
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

}
