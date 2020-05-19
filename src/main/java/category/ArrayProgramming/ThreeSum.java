package category.ArrayProgramming;

import java.util.*;

/**
 * @author yzchen
 * @create 2019-11-21
 * @desc 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * <p>
 * 三数之和
 **/
public class ThreeSum {

    public static void main(String[] args) {

        int [] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

    }

    /**
     * 暴力法(超时)
     **/
    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Set<String> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        System.out.println(nums);
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0){
                break;
            }
            int L = i+1;
            int R = len -1;
            while(L<R){
                // 双指针 向中间移动
                String str = nums[i] +","+ nums[L] +","+ nums[R];
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0 && !set.contains(str)){
                    set.add(str);
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    L++ ;
                    R--;
                }else if(sum > 0){
                    R--;
                }else {
                    L++;
                }
            }
        }
        return ans;
    }


    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3){
            return ans;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0){
                // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                // 去重
                continue;
            }
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]){
                        L++; // 去重
                    }
                    while (L<R && nums[R] == nums[R-1]){
                        R--; // 去重
                    }
                    L++;
                    R--;
                } else if (sum < 0){
                    L++;
                } else if (sum > 0){
                    R--;
                }
            }
        }
        return ans;
    }


}
