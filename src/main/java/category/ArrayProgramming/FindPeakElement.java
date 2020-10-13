package category.ArrayProgramming;


/**
 * @author yzchen
 * @create 2020-01-16
 * @desc
 *
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *
 * 你的解法应该是 O(logN) 时间复杂度的
 *
 * 寻找峰值  162
 *
 **/
public class FindPeakElement {

    /**
     * 如果要列出所有的峰值怎么办？
     *
     * 有时间复杂度的要求
     *
     * **/
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(findPeakElement(nums));


    }

    /**
     * 递归 + 二分法
     * **/
    public static int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    /**
     * 递归处理 ... 一直在往一边靠
     *
     * 这样的话 .. 只会找到最近的一个 ... 离二分最近的一个
     *
     * 因为一直在往 峰值靠 ,最后就到了 峰值处 ，一个点
     *
     * 因为 取整 自带减一 , mid 大的时候 .. 不用 mid -1
     *
     * **/
    public static int search(int[] nums, int l, int r) {

        if (l == r){
            return l;
        }
        int mid = (l + r) / 2;
        // 峰值 往大的那一侧偏
        if (nums[mid] > nums[mid + 1]){
            return search(nums, l, mid);
        }else {
            return search(nums, mid + 1, r);
        }
    }






    /**
     * 动态规划来处理
     *
     * **/











}
