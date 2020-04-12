//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i ++) {
            int first = i + 1, last = nums.length-1;

            while (first < last) {
                int sum = nums[i] + nums[first] + nums[last];
                if (Math.abs(ans - target) > Math.abs(sum - target)) {
                    ans = sum;
                }
                if (sum > target)  last -= 1;
                else if (sum < target) first += 1;
                // The next line of code must contains. Otherwise it will exceed required time
                else return sum;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
