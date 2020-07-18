//给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。 
//
// 示例 1: 
//
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出: false 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int lenOne = s1.length();
        int lenTwo = s2.length();
        int lenThree = s3.length();
        if (lenOne + lenTwo != lenThree) return false;
        boolean[][] dp = new boolean[lenOne + 1][lenTwo + 1];
        dp[0][0] = true;
        for (int i = 0; i <= lenOne; i++) {
            for (int j = 0; j <= lenTwo; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[lenOne][lenTwo];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
