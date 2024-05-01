package pers.chaffee.leetcode;

import java.lang.reflect.Member;
import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 */
public class day01 {
    public static void main(String[] args) {
        /**
         * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
         * 输出：[1,2,2,3,5,6]
         * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
         * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
         */

        /**
         * 示例 2：
         *
         * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
         * 输出：[1]
         * 解释：需要合并 [1] 和 [] 。
         * 合并结果是 [1] 。
         * 示例 3：
         *
         * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
         * 输出：[1]
         * 解释：需要合并的数组是 [] 和 [1] 。
         * 合并结果是 [1] 。
         * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
         */
//        int[] nums1 = new int[]{1,2,3,0,0,0};
//        int[] nums2 = new int[]{2,5,6};
        int[] nums1 = new int[]{4,5,6,0,0,0};
        int[] nums2 = new int[]{1,2,3};
//        int[] nums1 = new int[]{1,3,1,7,8,4};
//        int[] nums2 = new int[]{2,5,6};
        merge(nums1,nums1.length,nums2,nums2.length);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int count = 0;
        for (int i : nums1) {
            if (i == 0) continue;
            nums3[count++] = i;
        }
        for (int i : nums2) {
            if (i == 0) continue;
            nums3[count++] = i;
        }
        //冒泡排序
//        bubblingSort(nums3);
//        quickSort(nums3,0,nums3.length-1);
        insertSort(nums3);
        StringBuilder ss = new StringBuilder();
//        int countNotZero = 0;//不为0的个数
//        for (int i : nums3) {
//           if (i != 0) {
//               countNotZero ++;
//           }
//        }
//        for (int i = 0, j = 0; i < nums3.length; i++) {
//            if (nums3[i] != 0) {
//                nums1[j] = nums3[i];
//                ss.append(nums1[j]).append(",");
//                j++;
//            }
//        }

        for (int i : nums3) {
            ss.append(i).append(",");
        }
        System.out.println(ss);
    }


    public static void mergeFromLeetCode(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }


    //冒泡排序
    public static void bubblingSort(int[] nums3){
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums3.length - i -1; j++) {
                if (nums3[j+1] < nums3[j]) {
                    int current = nums3[j];
                    nums3[j] = nums3[j+1];
                    nums3[j+1] = current;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] nums, int i,int j){
        if (i >= j) return;
        if (nums.length == 0) return;
        int first = i;
        int last = j;
        int key = nums[i];
        boolean blFirst = false;
        while (first != last){
            if (blFirst){
                if (nums[first] > key){
                    nums[last] = nums[first];
                    blFirst = false;
                }else first++;
            }else {
                if (nums[last] < key){
                    nums[first] = nums[last];
                    blFirst = true;
                }else last--;
            }
        }
        nums[first] = key;
        quickSort(nums, i, first-1);
        quickSort(nums, first + 1, j);
    }


    /**
     * 插入排序
     * 思想：依次拿出数组的元素放入一个有序的数组中
     * 不需要再新增一个数组，增加了空间复杂度
     * @param nums
     */
    public static void insertSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] <= nums[j] && ((j - 1 < 0) || ((j - 1 >= 0) && nums[i] >= nums[j - 1]))) {
                    int key = nums[i];
                    for (int k = i; k > j; k--) {
                        nums[k] = nums[k - 1];
                    }
                    nums[j] = key;
                }
            }
        }
    }
}
