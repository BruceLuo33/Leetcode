//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int first = 0, last = nums.length - 1, sum;
        int[] loc = new int[2];
        while (first < last) {
            sum = nums[first] + nums[last];
            if (sum == target) {
                loc[0] = first;
                loc[1] = last;
                return loc;
            }
            while (first < last && first > 0 && nums[first] == nums[first - 1]) first += 1;
            while (first < last && last < nums.length - 1 && nums[last] == nums[last + 1]) last -= 1;
            first += 1;
            last -= 1;
        }
        return loc;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
