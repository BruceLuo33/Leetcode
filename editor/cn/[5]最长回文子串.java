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
 6.17 第一遍，6.21 第二遍
 - 思路一：动态规划。
 1. 首先弄清楚题目需要的是什么：“子串”，代表的是一个连续的字符串，而不是“子序列”。后者并不要求连续；
 2. 对于子串问题，应该设置 dp 为二维 boolean 矩阵，和 1143、516 类似，dp[i][j] 表示的意思是子串 s[i..j]是否为回文子串，如果 `dp[i][j] == true`，说明是，否则不是；
 3. 对于状态转移方程，考虑这种情况：如果子串只有一个或者是两个字符，那么我们很容易判断 true or false，这也就是 base case；
 4. 而对于更加 general 的情况，就需要用到前面的 dp 数组了，因为此时不会再产生数组越界问题，所以直接 `dp[i][j] = dp[i + 1][j - 1]` 即可;
 5. 对于这种二维数组的情况，需要考虑 `dp[i][j]` 需要预先知道哪个方位的数据，从上面可以看出，我们需要先知道 `dp[i+1][j-1]` 的值，也就是左下角，因此两层 for 循环的终点应该是右上角
 - 复杂度分析：O(N^2)，空间复杂度：O(N^2)
 - 思路二：
sdfsfsfd
 */
class Solution {
    public String longestPalindrome(String s) {
        int m = s.length();
        if (m < 2) return s;
        boolean[][] dp = new boolean[m][m];
        char[] sChar = s.toCharArray();
        int begin = 0, maxLen = 0;
        for (int i = 0; i < m; i++) dp[i][i] = true;
        for (int i = m - 1; i >=0; i--) {
            for (int j = i; j < m; j++) {
                if (sChar[i] != sChar[j]) dp[i][j] = false;
                else  {
                    if (j - i + 1 < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
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
