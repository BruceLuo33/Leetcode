//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 4.11 第一遍，4.22 第二遍
        // 思路：双指针。遍历整个数组。如果 3sum > target，则将最右端的指针内移，否则左移。
        // 因为需要判断指针移动方向，即 3sum 与 target 的相对大小。所以需要对数组先sort
        // 注意：因为复杂度比较高，需要多用去重。首先可以判断 min/max 和 0 的关系，如果都取不到，则返回空数组
        // 注意： 在for循环中，除了判断second 和 third 是否重复的情况，还要判断first 是否重复，如果是，就要 continue。
        // 复杂度分析：O（N^2 + NlogN），空间复杂度 O（1）

        // 4.22 codes:
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length <= 2 || nums == null) return ans;
        int first, second, third = nums.length - 1, sum;
        int maxValue = nums[third] + nums[third - 1] + nums[third - 2];
        int minValue = nums[0] + nums[1] + nums[2];
        if (maxValue < 0) return ans;
        if (minValue > 0) return ans;

        for (first = 0; first < nums.length - 2; first++) {
            second = first + 1;
            third = nums.length - 1;
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            while (second < third) {
                sum = nums[first] + nums[second] + nums[third];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    second += 1;
                    third -= 1;
                    while (second < third && nums[second] == nums[second - 1]) second += 1;
                    while (second < third && nums[third] == nums[third + 1]) third -= 1;
                }
                else if (sum > 0) {
                    third -= 1;
                    // while (second < third && nums[third] == nums[third + 1]) third -= 1;
                }
                else {
                    second += 1;
                    // while (second < third && nums[second] == nums[second - 1]) second += 1;
                }
            }
        }
        return ans;


        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = i + 1, last = nums.length - 1;
            int sum = nums[i] + nums[first] + nums[last];
            int target = -nums[i];
            while (first < last) {
                if (nums[first] + nums[last] == target) {
//                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[first], nums[last]));
                    first += 1;
                    last -= 1;
                    while (first < last && nums[first] == nums[first - 1]) {
                        first += 1;
                    }
                    while (first < last && nums[last] == nums[last + 1]) {
                        last -= 1;
                    }
                } else if (nums[first] + nums[last] > target) {
                    last -= 1;
                } else {
                    first += 1;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
