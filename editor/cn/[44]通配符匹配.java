//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心算法 字符串 动态规划 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.5 第一遍
 - 思路：动态规划
 1. 状态与选择：状态为 s 的第 0-i 个字符和 p 的 0-j 个字符是否匹配；选择即为这两个字符是否相等
 2. dp 数组的定义：dp[i][j] 表示s[0...i] 与 p[0...j] 是否为完全匹配，如果是，其值应为 true；
 3. base case：
 - 考虑到边界情况，当二者都为空时，是匹配的，即 dp[0]][0] = true；
 - 当 s 为空字符串的时候，如果 p 不是非空，p 必须每一个字符都是 '*'
 - 当 p 为空字符串的时候，如果 s 不是非空，dp 数组一定是 false；
 4. 状态转移方程：状态的转移，来自于选择：
 - 如果 s[i] == p[j]，仅考虑单字符匹配的条件下有两种情况，第一，两个字符一样；第二，p[j] == '?'，这两种情况都可以使得单字符匹配，即 dp[i][j] = dp[i - 1][j - 1]；
 - 如果考虑非单字符匹配，又有两种情况：
 1. '*' 匹配空字符，则 dp[i][j] = dp[i][j - 1]，即 s 的指针不移动，但是 p 需要往前移动一位继续匹配；
 2. '*' 匹配多个字符，则 dp[i][j] = dp[i - 1][j]，即 s 往前移动一位继续判断，p 不动；
 3. 最终的结果是这二者的并集，即 dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
 - 复杂度分析：O（M*N）
 */
class Solution {
    public boolean isMatch(String s, String p) {
        // parameter calculation
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        int m = sChar.length, n = pChar.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        // base case
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && (pChar[j - 1] == '*');
        }
        // Transformation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (sChar[i - 1] == pChar[j - 1] || pChar[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j -1];
                } else if (pChar[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
