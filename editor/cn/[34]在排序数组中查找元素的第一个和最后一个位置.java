//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 685 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 思路一：简单的从左到右进行遍历，复杂度 O（N）
 * 思路二：二分搜索。先通过二分找到和目标值相等的index，然后分别往左右扩展
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Solution one:
        /*
        int[] ans = {-1, -1};
        if (nums == null || nums.length ==0) {
            return ans;
        }
        int len = nums.length;
        boolean first = false;
        for (int i = 0; i < len; i++) {
            if ( nums[i] == target && first == false) {
                first = true;
                ans[0] = i;
                ans[1] = i;
                break;
            }
        }
        int pos = ans[0] + 1;
        int count = 0;
        while (first && pos < len && nums[pos] == target) {
            count += 1;
            pos += 1;
        }
        ans[1] = ans[0] + count;
        return ans;
         */

        // Solution two:
        int[] ans = {-1, -1};
        if (nums == null || nums.length ==0) {
            return ans;
        }
        int len = nums.length;
        int index = findMid(nums, target);
        if (index == -1) {
            return ans;
        }
        int left = index, right = index;
        while (left >= 0 && nums[left] == target) {
            left -= 1;
        }
        while (right < len && nums[right] == target) {
            right += 1;
        }
        ans[0] = left + 1;
        ans[1] = right - 1;
        return ans;
    }

    private int findMid(int[] nums, int target) {
        int first = 0, end = nums.length - 1;
        while (first <= end) {
            int mid = first + (end - first) / 2;
            int midVal = nums[mid];
            if (midVal > target) {
                end = mid - 1;
            } else if (midVal < target) {
                first = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)












