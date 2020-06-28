//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.29 第一遍
 - 思路：动态规划。
 1. 状态与选择：状态即为当前位于 String s 的哪一个位置，选择即为一个数字or两个数字组成一个 char
 2. dp 数组的定义：dp[i]表示 s[0..i] 共有多少种组合方法；
 3. base case：先要清除特殊情况：s 长度为零，return 0；s 长度为 1，但是为'0'，也无法解码成某个字母；
 4. 状态转移方程：
 - 如果连续的两位数满足条件，则有两种可能：一个数字决定一个字母 or 两个数字决定一个字母：dp[i] = dp[i-1] + dp[i-2]；
 - 如果连续的两位数不满足条件，需要进一步分辨：
 1. 当前数字是 0，对于一个数组合而言，就无法满足了，只能往前看，即 dp[i] = dp[i - 2]
 2. 不是零，但是考虑到前一个数字超过了 26，则不能走两步，只能走一步，dp[i] = dp[i-1]
 - 复杂度分析：O（N）
 */

class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        if (len == 1 && s.charAt(0) == '0') return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        char[] sChar = s.toCharArray();
        for (int i = 0; i < len; i++) {
            dp[i + 1] = sChar[i] == '0' ? 0 : dp[i];
            if (i > 0 && (sChar[i - 1] == '1' || (sChar[i - 1] == '2' && sChar[i] <= '6'))) {
                dp[i + 1] += dp [i - 1];
            }
        }
        return dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
