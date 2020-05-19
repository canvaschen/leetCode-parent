package category.ArrayProgramming;

/**
 * @author yzchen
 * @create 2019-12-06
 * @desc
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 *
 * 搜索旋转排序数组
 **/
public class Search {


    public static void main(String args[]){

        int [] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,3));
    }

    /**
     * 先判断 转折点 .. 再判断 target 点位.. 共4种情况
     *
     *
     *
     *
     * **/
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int L = 0;
        int R = nums.length - 1;
        int mid;
        // 取出中间值，然后，比较 和 target 是否是同一个
        while (R-L>1) {
            System.out.println(L + " " + R);
            // 不考虑奇偶性 取整
            mid = (L + R) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //转折点的位置
            if (nums[L] <= nums[mid]) {
                // 前长后短
                if (target >= nums[L] && target < nums[mid]) {

                    R = mid;
                } else {
                    L = mid;
                }
            } else {
                // 前短后长
                if (target <= nums[R] && target > nums[mid]) {
                    L = mid;
                } else {
                    R = mid;
                }
            }
        }

        // 问题收归 最终态 L ,mid ,R,target
        if(nums[L] == target){
            return L;
        }else if(nums[R] == target){
            return R;
        }else {
            return -1;
        }
    }









}
