package category.ArrayProgramming;

import java.util.Arrays;

/**
 * @author yzchen
 * @create 2019-11-22
 * @desc
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 *
 * 最接近的三数之和
 *
 **/
public class ThreeSumClosest {

    public static void main(String[] args) {

        int[] h = {-1,0,1,1,55};
        System.out.println(doThreeSumClosest(h,3));

    }


    /**
     * 排序 + 双指针
     *
     * 排序之后 可以进行 s,e 的 前后移动，这边不用考虑 二分法
     * **/
    public static int doThreeSumClosest(int[] nums, int target) {

        // 双指针 + 排序
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int result = 0;
        for(int i=0;i<nums.length;i++){
            int s= i+1;
            int e= nums.length-1;
            while (s<e) {
                int gap = Math.abs(nums[i] + nums[s] + nums[e] - target);
                if (gap == 0) {
                    return target;
                }
                if (gap <= min) {
                    min = gap;
                    result = nums[i] + nums[s] + nums[e];
                }
                // 移动
                if (nums[i] + nums[s] + nums[e] > target) {
                    e--;
                }else {
                    s++;
                }

            }
        }
        return result;
    }









}
