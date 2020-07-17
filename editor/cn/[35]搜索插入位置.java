//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.23 第一遍，7.17 第二遍
 思路：二分查找

 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int start = 0, end = nums.length - 1;
        if (nums[start] > target) return 0;
        if (nums[end] < target) return end + 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return start;

        // Solution two:
        // if (nums == null || nums.length == 0) return 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (target > nums[i]) continue;
        //     else return i;
        // }
        // return nums.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
