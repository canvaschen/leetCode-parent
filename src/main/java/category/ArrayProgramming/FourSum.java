package category.ArrayProgramming;

import java.util.*;

/**
 * @author yzchen
 * @create 2019-11-25
 * @desc
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 *  四数之和
 **/
public class FourSum {

    public static void main(String[] args) {

        int [] nums = {-2,-1, 0, 0, 1, 2};
        System.out.println(doFourSum(nums,0));

    }

    public static List<List<Integer>> doFourSum(int[] nums, int target) {

        // 拼接返回值
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums == null || nums.length < 4){
            return result;
        }

        // 排序 + 双指针法  + SET 去重

        Arrays.sort(nums);
        Set<String> sets = new HashSet<String>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > 2; j--) {
                int s = i + 1;
                int e = j - 1;
                while (s < e) {
                    if (nums[i] + nums[s] + nums[e] + nums[j] == target) {
                        sets.add(nums[i] + "," + nums[s] + "," + nums[e] + "," + nums[j]);
                        e--;
                        s++;
                    } else if (nums[i] + nums[s] + nums[e] + nums[j] > target) {
                        e--;
                    } else {
                        s++;
                    }
                }
            }
        }

        Iterator it1 = sets.iterator();
        while (it1.hasNext()) {
            String[] arr = it1.next().toString().split(",");
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < arr.length; i++) {
                list.add(Integer.parseInt(arr[i]));
            }
            result.add(list);
        }
        return result;
    }


}
