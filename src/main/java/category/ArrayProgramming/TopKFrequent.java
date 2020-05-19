package category.ArrayProgramming;

import java.util.*;

/**
 * @author yzchen
 * @create 2020-05-15
 * @desc
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 *
 **/
public class TopKFrequent {

    /**
     * 堆
     *
     * PriorityQueue 基于 堆的 优先级 队列
     * 小顶堆
     * poll() 从顶部删除元素
     *
     * **/
    public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // 定义 heap , 小的在前面
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k){
                // 把顶上的 少的移除掉
                heap.poll();
            }
        }

        // build output list
        List<Integer> result = new LinkedList();
        while (!heap.isEmpty()){
            result.add(heap.poll());
        }
        // 因为是小顶堆，所以，结果需要反转
        Collections.reverse(result);
        return result;
    }















}