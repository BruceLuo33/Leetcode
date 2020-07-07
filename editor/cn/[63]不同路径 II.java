//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
5.24 第一遍，7.7 第二遍
- 思路：动态规划。
  1. 状态与选择：状态即为当位于某一个格子时，有多少条路径能从起点到达这个位置；选择即为下一步是往右或者是往左；
  2. dp 数组的定义：dp[i][j] 表示当机器人位于 i 行 j 列时，从起点能到达这个位置的路径数目；
  3. base case：如果[0,0] 为 1，那么直接返回0，如果不是，dp[i][0] = 0 or 1, dp[0][j] = 0 or 1，如果上边和左边没有阻碍，就都初始化为 1，如果有 1，则当前格子和之后的格子都为 0；
  4. 状态转移方程：状态的转移，来自于选择：
     - 如果当前格子就是 1，那么从起点到这里直接就是 0 条可能；
     - 如果左或者上方格子是 1，那么对应路径可能性为 0；
     - 如果都不为零，则 dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
- 复杂度分析:O(M*N)
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
