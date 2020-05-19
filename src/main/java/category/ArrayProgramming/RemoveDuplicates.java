package category.ArrayProgramming;

/**
 * @author yzchen
 * @create 2019-11-27
 * @desc
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *
 * 删除排序数组中的重复项
 *
 *
 **/
public class RemoveDuplicates {


    /**
     * 双指针 , 一次遍历
     *
     * 虽然是 计算长度，但是 数组结构是要改变的
     *
     * **/
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        // 双指针法 , 因为返回的是长度，所以不用删除数据，直接做统计就可以
        // 实际数据结构 发生了改变 , 看到有用的数据 就往前堆
        // 还有就是注意 返回值 需要 + 1
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }


    public static void main(String [] args){

        int [] nums = {1,1};

        System.out.println(removeDuplicates(nums));

    }




}
