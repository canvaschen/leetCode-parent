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
     * 本意是用 堆 来实现
     *
     * 堆是理论基础，priorityQueue 是具体的实现工具
     *
     *
     * PriorityQueue 默认是 小根堆
     *
     *
     * add : 将指定的元素插入此优先级队列。(add 是加在树的最后面 , 优先队列会 内部重新调整 堆的结构)
     *
     * 调整之后 .. 最小的数据就在最上面
     *
     * 内部结构不一定 ... 但是 根上一定是 最小的
     *
     * 第 K 个最大值 ： 我只要剩 K 个值 在堆里就好了
     *
     * priorityQueue : 优先级队列  基于heap 来实现的
     *
     *
     * 时间复杂度 : O(n) ?
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
