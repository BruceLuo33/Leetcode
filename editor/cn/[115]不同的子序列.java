//给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。 
//
// 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 输入：S = "rabbbit", T = "rabbit"
//输出：3
//解释：
//
//如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2： 
//
// 输入：S = "babgbag", T = "bag"
//输出：5
//解释：
//
//如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.22 第一遍
 - 思路：动态规划
 1. dp 数组的定义：dp[i][j] 表示 `s[0...i]` 中的自序列等于`t[0...j]`的个数；
 2. 状态转移方程：根据上面的 dp 数组的定义，我们要做的是在 s 中搜寻 t，考虑两个情况：
 - 首先，`s[i] == t[j]`，因为我们的目的是在 s 中搜寻 t，具体到`dp[i][j]`，就是要在 `s[0...i]` 中搜寻 `t[0...j]`，所有会有两种结果，一个是前面没有与 s[i] 相等的项，那么就要继续看 `dp[i-1][j-1]`，第二个是前面有相等的项，那么将 s[i] 去掉，然后继续看 dp[i-1][j] 即可。最后的结果就是将二者加起来；
 - 如果 `s[i] != t[j]`，那么直接将 s[i] 去掉，只看 `dp[i-1][j]`
 3. base case：如果 s 为空，那么 `dp[0][j] = 0`，代表的含义是 t 在空串中找不到对应项；如果 t 为空，那么`dp[i][0] = 1`，代表的含义是空串t "" 是 s 的每一个 char 的子集；
 复杂度分析：O(N^2)
 */
class Solution {
    public int numDistinct(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int m = sChar.length, n = tChar.length;
        int[][] dp = new int[m + 1][n + 1];
        // 如果
        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (sChar[i-1] == tChar[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        return dp[m][n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
