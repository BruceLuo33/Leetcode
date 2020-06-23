//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.23 第一遍
 - 思路：动态规划。对于两个字符串的问题，一般都是考虑一个 dp 矩阵，分别对应两个指针指向字符串的最后，然后一步步往前走，缩小问题规模。
 1. 状态与选择：选择即为两个指针所指的 char 是否相等；状态对应两个string；
 2. dp 数组的定义：`dp[i][j]` 表示 `s1[0..i], s2[0..j]` 之间的最小编辑距离；
 3. base case：当 word1/word2 走到了起点，直接返回剩下字符串的长度，`dp[i][0], dp[0][j]`；
 4. 状态转移方程：分为两种情况，判断依据为 `s1[i], s2[j]` 是否相等：
 - `s1[i] == s2[j]`，那么不需要对两个字符串进行操作，`dp[i][j] = dp[i-1][j-1]`;
 - `s1[i] != s2[j]`，那么就需要从三种操作中选取最小值：
 1. 替换：`dp[i-1][j-1] + 1`，意思是s1[i] 替换成与 s2[j] 相等的 char，同时因为完成了一次替换，因此此时的两个指针都需要往前走一步，即 i-1, j-1，这个动作需要一个操作步骤来完成，因此 + 1；
 2. 删除：`dp[i-1][j] + 1`，将 s1[i] 删除，此时 s1 对应的指针自然要往前走一步，而因为没有对 s2 进行操作，所以 s2[j] 保持不变；
 3. 插入：`dp[i][j-1] + 1`，将 s1[i] 位置插入一个与 s2[j] 相等的 char，因此 s2 的指针要往前移动一位，因为对 s1[i] 没有进行操作，所以保持不变；
 - 注意：因为 base case 单独占了一行/列，所以与背包问题相同，这里的第 i/j 个字符分别为 s1[i-1], s2[j-1]；
 - 复杂度分析：O(N^2)
 */

class Solution {
    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int m = s1.length, n = s2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
