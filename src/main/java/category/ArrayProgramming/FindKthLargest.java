package category.ArrayProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yzchen
 * @create 2019-12-13
 * @desc
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 *
 * 数组中的第K个最大元素
 *
 **/
public class FindKthLargest {



    /**
     * 先排序 再直接取 ，时间复杂度 : O(NlogN)  空间复杂度 O(1)
     *
     * **/
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    /**
     * 本意是用 堆 来实现
     *
     * priorityQueue : 优先级队列  基于heap 来实现的
     *
     * **/
    public int findKthLargest1(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.comparingInt(n1 -> n1));

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k){
                heap.poll();
            }
        }

        // output
        return heap.poll();
    }




}
