//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 示例 1: 
//
// 
//输入:
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出: 3
//解释: 
//长度最长的公共子数组是 [3, 2, 1]。
// 
//
// 说明: 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.1 第一遍
 - 思路：动态规划。可以画一个表格来帮助理解。横轴为数组 A 的元素，纵轴为数组 B 的元素，表格值为当前为止的最长重复数组的长度；
 1. 状态与选择：状态分别为两个指针指向两个数组的位置；选择为当前元素是否相等；
 2. dp 数组的定义：dp[i][j] 表示位于 A[i]、B[j] 时，最长重复子数组的长度；
 3. base case：当 A 或 B 都只有一个元素的时候，dp 数组的取值将与之前的取值无关，仅由 `A[i] == B[j] or not` 来确定
 4. 状态转移方程：dp[i][j] = A[i] == B[j] ? dp[i- 1][j - 1] + 1 : 0; 每次循环都判断 ans = Math.max(ans, dp[i][j]);
 - 复杂度分析：O（N^2），空间复杂度同。
 */
class Solution {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;
        int ans = 0;
        // int[][] dp = new int[lenA + 1][lenB + 1];
        int[] dp = new int[lenB + 1];
        for (int i = 1; i <= lenA; i++) {
            // for (int j = 1; j <= lenB; j++){
            for (int j = lenB; j >= 1; j--) {
                // Two dimension
                // dp[i][j] = A[i - 1] == B[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                // ans = Math.max(ans, dp[i][j]);

                // One dimension
                dp[j] = A[i - 1] == B[j - 1] ? dp[j - 1] + 1 : 0;
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
