//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.20 第一遍
 - 思路一：同向双指针
 - 复杂度分析：O（N^2）
 - 思路二：两端双指针，不用 for 循环，而是使用 while 循环，减少次数
 - 复杂度分析: O（N）
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0 || numbers[0] > target) return null;
        int m = numbers.length;
        int left = 0, right = m - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right -= 1;
            } else if (sum < target) {
                left += 1;
            }
        }

        // Previous, O(N^2)
        // for (int i = 0; i < m - 1; i++) {
        //     for (int j = i + 1; j < m; j++) {
        //         if (numbers[i] + numbers[j] == target) {
        //              return new int[]{left + 1, right + 1};
        //         } else if (numbers[i] + numbers[j] > target) break;

        //     }
        // }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
