//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2: 
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
// 
//
// 示例 3: 
//
// 输入: amount = 10, coins = [10] 
//输出: 1
// 
//
// 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= amount (总金额) <= 5000 
// 1 <= coin (硬币面额) <= 5000 
// 硬币种类不超过 500 种 
// 结果符合 32 位符号整数 
// 
//


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.23 第一遍
 - 思路：动态规划、背包问题。
   1. 状态与选择：状态有两个，可以选择的物品 & 背包的容量；选择有两个，可以装进背包或者不可以装进背包
   2. dp 数组定义：dp[i][j] 表示使用前 i 个物品的时候，凑成总数为 j 的方式数量
   3. base case：dp[i][0] = 1， dp[0][j] = 0。即如果 amount = 0，所有的都不选也是一种解法；但如果硬币数量是0，那么是不可能凑出来amount；
   4. 状态转移方程：根据选择，来思考状态转移的逻辑：
 - 如果不将当前 coin 放入背包，那么当前的状态应该继承之前的状态，即 `dp[i][j] = dp[i-1][j]`;
 - 如果将当前coin 放入背包，也只有在不超过amount 的情况下才能放入，即必须要 `amount - coin >= 0`，此时 `dp[i][j] = dp[i-1][j - coins[i-1]]`，因为从 1 开始循环，所以第 i 个 coin 实际上是 coins[i-1]
 - 综合来看，如果 `amount - coin >= 0`，有放或者是不放两个选择，即`dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]`；否则，如果 coin 大于 amount，就只有可能不放了，此时 `dp[i][j] = dp[i-1][j-1]`
 - 复杂度分析：O(N^2)
 */
class Solution {
    // public int change(int amount, int[] coins) {
    //     int m = coins.length;
    //     int[][] dp = new int[m + 1][amount + 1];
    //     for (int i = 0; i <= m; i++) dp[i][0] = 1;
    //     for (int i = 1; i <= m; i++) {
    //         for (int j = 1; j <= amount; j++) {
    //             if (j - coins[i - 1] >= 0) {
    //                 dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
    //             } else {
    //                 dp[i][j] = dp[i - 1][j];
    //             }
    //         }
    //     }
    //     return dp[m][amount];
    // }

    // 一维
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j - coin >= 0) dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
