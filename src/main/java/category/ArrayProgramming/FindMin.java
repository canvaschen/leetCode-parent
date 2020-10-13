package category.ArrayProgramming;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yzchen
 * @create 2019-12-10
 * @desc
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 *
 * 寻找旋转排序数组中的最小值  153
 *
 *
 **/
public class FindMin {

    public static void main(String[] args) {

        int[] nums = {2,3,8,1,4,6};

        System.out.println(findMin2(nums));

    }


    /**
     * 搜索转折点，转折点就是最小的点
     *
     * **/
    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;

        // 特例判断 ，已排序的情况
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        // 先判断 结束条件
        // 再考虑 位置转移
        while (right >= left) {
            int mid = (right + left) / 2;
            // 折点特例
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            // 折点特例
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                // mid 在左半区，折点在右半区
                left = mid + 1;
            } else {
                // mid 在右半区，折点在左半区
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 利用小根堆 来处理
     * 数组全部构建成 堆之后 .. 根就是最小的值
     *
     * **/
    public static int findMin2(int[] nums){

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n1 -> n1));

        for(int n :nums){
            heap.add(n);
        }

        return heap.poll();
    }




}
