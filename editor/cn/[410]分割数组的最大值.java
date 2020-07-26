//给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 注意: 
//数组长度 n 满足以下条件: 
//
// 
// 1 ≤ n ≤ 1000 
// 1 ≤ m ≤ min(50, n) 
// 
//
// 示例: 
//
// 
//输入:
//nums = [7,2,5,10,8]
//m = 2
//
//输出:
//18
//
//解释:
//一共有四种方法将nums分割为2个子数组。
//其中最好的方式是将其分为[7,2,5] 和 [10,8]，
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
// 
// Related Topics 二分查找 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.25 第一遍
 - 思路：贪心算法
 */
class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = 0;
        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }
        while (left < right) {
            int subSet = 1;
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int n : nums) {
                if (sum + n > mid) {
                    sum = 0;
                    subSet += 1;
                }
                sum += n;
            }
            if (subSet > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
