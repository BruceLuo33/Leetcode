//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。 
//
// 
//
// 示例 1: 
//输入: 
//
// "bbbab"
// 
//
// 输出: 
//
// 4
// 
//
// 一个可能的最长回文子序列为 "bbbb"。 
//
// 示例 2: 
//输入: 
//
// "cbbd"
// 
//
// 输出: 
//
// 2
// 
//
// 一个可能的最长回文子序列为 "bb"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母 
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.17 第一遍
 - 思路：动态规划。
 1. 涉及到“子序列” + “最值”，用动态规划；如果是两个字符串，则需要一个 dp[m][n] 大小的数组，而这里的“回文序列”实际上是需要一个 `dp[m][m]` 大小的数组；
 2. 对于某一个 `dp[i][j]`，它代表的是从 `s[i] ~ s[j]`，它的大小如何确定呢？实际上这么来的：假设 `dp[i+1][j-1]` 已经是回文子串了，那么如果 s[i] == s[j]，说明可以添加进去，也就是 `dp[i][j] = dp[i+1][j-1] + 2`;
 3. 如果不相等，那么说明这两个值**不能同时出现**在回文子串中，那么将二者分别加入原子串，并取二者中的较大值；
 - 复杂度分析：O(N^2)
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] sChar = s.toCharArray();
        int m = sChar.length;
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) dp[i][i] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                if (sChar[i] == sChar[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][m-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
