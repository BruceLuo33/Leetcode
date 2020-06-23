//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.23 第一遍
 - 思路：动态规划，背包问题。乍一看好像问题比较复杂，可能性很多。但可以先将整个数组求和，然后问题就变成了找到和为 sum/2 的0-1背包问题。
 1. 明确状态和选择：状态为背包的容量和可以选择的物品，选择为每次决定是否将物品装入背包；
 2. dp 数组的定义：`dp[i][j] == true`，表示的意思是前 i 个物品中，可以选出一个组合，使得他们的和等于 j，也就是恰好可以将背包装满；
 3. base case：`dp[0][j] = false, dp[i][0] = true`，这表示的意思是，如果没有可以选的东西，那肯定是false，如果 j = 0，那么也就相当于背包装满了，就是 true；
 4. 状态转移方程：从选择来思考，如果不能装入背包（因为背包容量不够），那么当前的 dp[i][j] 则等于上一个 dp[i-1][j] 的结果；如果可以装入背包，则为 `dp[i-1][j] || dp[i-1][j - nums[i-1]]`来判断。要注意的是，因为base case 的存在，所以实际上dp 数组的大小多了一行/列，因此第 i 个 nums 实际上是 nums[i-1]；
 - 注意：如果nums 的和为奇数，那么要返回 false，因为奇数 / 2 就有小数点了，int 之和不可能得到小数点；
 - 注意：如果想要将二维的 dp 压缩成一维的dp，j 应该从 sum 往 0，即从后往前遍历，因为前面的元素是求过了的。
 - 复杂度分析：O(N*sum)，空间复杂度：O(N*sum), O(sum)
 */
class Solution {
    // public boolean canPartition(int[] nums) {
    //     int sum = 0, m = nums.length;
    //     if (m < 2) return false;
    //     for (int n : nums) sum += n;
    //     if ((sum & 1) == 1) return false;
    //     sum /= 2;
    //     boolean[][] dp = new boolean[m + 1][sum + 1];
    //     for (int i = 0; i <= m; i++) dp[i][0] =true;
    //     for (int i = 1; i <= m; i++) {
    //         for (int j = 1; j <= sum; j++) {
    //             if (j - nums[i-1] < 0) {
    //                 dp[i][j] = dp[i-1][j];
    //             } else {
    //                 dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
    //             }
    //         }
    //     }
    //     return dp[m][sum];
    // }

    // 一维
    public boolean canPartition(int[] nums) {
        int sum = 0, m = nums.length;
        if (m < 2) return false;
        for (int n : nums) sum += n;
        if ((sum & 1) == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int j = sum; j >= 0; j--) {
                if (j - n >= 0) {
                    dp[j] = dp[j] || dp[j - n];
                }
            }
        }
        return dp[sum];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
