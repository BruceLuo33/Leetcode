//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.30 第一遍，6.22 第二遍，7.23 第三遍
 - 思路：动态规划。乍一看这道题和之前做的路径之和一样，不过这里求的是最小的路径，62 题求得是所有路径的可能。自底向上，就需要先考虑 dp 数组的定义和 base case。
 1. dp 数组的定义：定义为到达某个格子 dp[i][j] 的时候，所需要的步数；
 2. base case：因为路径只能是往下或者右边，所以在左边界以及上边界上的值将会是确定的，即当前值加上左边/上方的值；
 3. 状态转移方程：当前格子的值，等于左边或者上面的较小值相加，同时因为改变 grid 的值不影响结果，所以方程为：`grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1])`
 - 复杂度分析：O(N^2)
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++) grid[i][0] += grid[i - 1][0];
        for (int j = 1; j < n; j++) grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
