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
 * 寻找重复数  287
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
     * 数组相当于待办列表，下一步 你要做什么
     *
     * 当只有一个人在 跑的时候 : 路径 分 两段 , 平地阶段 ，初始点 ，环段
     *
     * 模型转换 :  平地阶段的 路径有多长 p ，环形阶段的有多长 c 其实都不重要
     *
     * 两个人开始跑的时候 :  1. 慢的人在 平地段 ，快的人在 初始点 (这个场景存在但无法感知)
     *                    2. 慢的人在 初始点 ，快的人在环内 (追逐 游戏开始)
     *                    3. 弗洛伊德 理论 (两个人在圈内跑，就一定会相遇，且相遇点就是 初始点 (value))
     *
     *
     *
     *
     * 关于 弗洛伊德 理论 的验证 : 两倍的速度差
     *
     *  a1 = p ,
     *  a2 = 2p ,
     *
     *
     *
     *  1  3  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2
     *  1  3  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2  4  2
     *  1  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2
     *
     *
     *
     * **/
    public static int findDuplicate(int[] nums) {

        int tortoise = nums[0];
        int hare = nums[0];

        String tortoiseStr = tortoise +"  ";
        String hareStr = hare +"  ";

        int count =0;

        // 找到入环点 位置  这边输出的值 是作为 坐标来使用的
        while (true){
            // 走一步，和 走两步的人 终究会相遇
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];

            tortoiseStr = tortoiseStr + tortoise + "  ";

//            if(tortoise == hare){
//                break;
//            }
            count ++;
            if(count > 25){
                break;
            }
        }
        System.out.println(tortoiseStr);
        System.out.println(tortoise);

        // 找到重复数据
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        System.out.println(ptr1);
        return ptr1;
    }

    public static void main(String [] args) {

        // 这边check 一下 链表的生成
        int[] nums = {1, 3, 4, 2, 2, 5};
        findDuplicate(nums);


    }

}
