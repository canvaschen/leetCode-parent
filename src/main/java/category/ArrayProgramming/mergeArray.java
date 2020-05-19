package category.ArrayProgramming;

import java.util.Arrays;

/**
 * @author yzchen
 * @create 2020-05-07
 * @desc
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 *
 *  arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 *
 *  src:源数组;
 *
 *  srcPos:源数组要复制的起始位置;
 *
 *  dest:目的数组;
 *
 *  destPos:目的数组放置的起始位置;
 *
 *  length:复制的长度.
 *
 *
 **/
public class mergeArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 先合并
        System.arraycopy(nums2, 0, nums1, m, n);
        // 再排序
        Arrays.sort(nums1);
    }



}
