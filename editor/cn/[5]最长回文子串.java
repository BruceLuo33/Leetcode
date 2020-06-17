//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.17 第一遍
 - 思路：动态规划。
 1. 首先弄清楚题目需要的是什么：“子串”，代表的是一个连续的字符串，而不是“子序列”。后者并不要求连续；
 2. 对于子串问题，应该设置 dp 为二维矩阵；

 */
class Solution {
    public String longestPalindrome(String s) {
        int m = s.length();
        if (m < 2) return s;
        boolean[][] dp = new boolean[m][m];
        char[] sChar = s.toCharArray();
        int maxLen = 1, begin = 0;
        for (int i = 0; i < m; i++) dp[i][i] = true;
        for (int j = 1; j < m ; j++) {
            for (int i = 0; i < j; i++) {
                if (sChar[i] != sChar[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
