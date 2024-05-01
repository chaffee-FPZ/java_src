package pers.chaffee.leetcode;

/**
 *
 * 27. Remove Element
 * 26. 删除有序数组中的重复项
 */
public class day02 {

    public static void main(String[] args) {
        /**
        输入：nums = [3,2,2,3], val = 3
        输出：2, nums = [2,2]
        解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，
         而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
         */
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4,4,5,6};
        int val = 3;
//        removeElement(nums,val);
        int ret = removeDuplicates(nums);
        StringBuilder ss = new StringBuilder();
        ss.append("返回几个：").append(ret).append("\n");
        for (int i : nums) {
            ss.append(i).append(",");
        }
        System.out.println(ss);
    }

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return nums.length;
    }


    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int max = len;
        for (int i = 1; i < max; i++) {
            if (nums[i] == nums[i-1]) {
                int key = nums[i];
                for (int k = i; k < len - 1; k++) {
                    nums[k] = nums[k + 1];
                }
                nums[len - 1] = key;
                i = i-1;
                max--;
            }
        }
        return max;
    }
}
