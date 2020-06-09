//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.26 第一遍，5.27 第二遍，6.9 第三遍
 - 思路一：动态规划。考虑从最后开始思考，设置一个 amount + 1 长度的数组，每一个 dp[i] 的值都是从其值减去所有的 coin 的结果中的最小值：
 1. 例如，dp[11] = Math,min(dp[10], dp[6], dp[1])，coins = [1, 5, 10], amount = 11；
 2. 因为我们不确定 coins 中元素的个数，所以需要遍历 coins 中的所有元素，每次比较 dp[i] 与 dp[i - coin] + 1，并更新较小值为新的 dp[i]；
 3. 之所以要将 dp[i - coin] 的值加一，是因为 “- coin” 的这个操作就已经将状态回退了，例如当我们比较 `dp[11]` 与 `dp[10]` 的时候，dp[10] 就已经是减掉了一个零钱，所以需要将其加一再比较。
 - 复杂度分析：O（N*k）
 - 思路二：BFS。这道题其实也可以理解为，从 amount 出发，每次将 `amout - each coin` 放入 queue，并更新visited。
 1. 如果 diff = curAmount - c == 0，代表 BFS 刚好走到了终点，return depth 结束
 2. 如果 diff < 0，说明这个 coin 太大了，同时因为 coins 数组是从小到大排列的，之后的数字只会比这个 c 更大，所以直接 break 循环；
 3. 如果没有访问过，那么就将其加入 queue，同时visisted 标记为 true；
 4. visited 用 Set 和 boolean 数组都可以，但是后者速度会快很多：134 ms -> 25 ms

 */
class Solution {

    // Solution Two: BFS
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        if (amount == 0) return 0;
        Arrays.sort(coins);
        Queue<Integer> queue = new LinkedList<>();
        // Set<Integer> visited = new HashSet<>();
        boolean[] visited = new boolean[amount + 1];
        queue.offer(amount);
        // visited.add(amount);
        visited[amount] = true;
        int depth = 0;
        while (!queue.isEmpty()) {
            depth += 1;
            int size = queue.size();
            while (size > 0) {
                size -= 1;
                int curAmount = queue.poll();
                for (int c : coins) {
                    int diff = curAmount - c;
                    if (diff == 0) return depth;
                    if (diff < 0) break;
                    // if (visited.contains(diff)) continue;
                    if (!visited[diff]) {
                        queue.offer(diff);
                        // visited.add(diff);
                        visited[diff] = true;
                    }

                }
            }
        }
        return -1;

    }


    // Solution One: Dynamic Programming
    // public int coinChange(int[] coins, int amount) {
    //     if (coins.length == 0) return -1;
    //     if (amount == 0) return 0;
    //     int[] dp = new int[amount + 1];
    //     Arrays.fill(dp, 1, dp.length, amount + 1);
    //     for (int i = 0; i < dp.length; i++) {
    //         for (int c : coins) {
    //             if (i < c) continue;
    //             dp[i] = Math.min(dp[i], dp[i-c] + 1);
    //         }
    //     }
    //     return dp[amount] == amount + 1 ? - 1 : dp[amount];
    // }


}
//leetcode submit region end(Prohibit modification and deletion)
