//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2: 
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        // 5.11 第一遍
        // 思路：一开始想的很简单，认为就是求奇数项和偶数项哪个大。这个读题太不仔细了。后面发现这是个动态规划问题，找到状态转移方程就可以了。
        // 代码中的变量，如果我们比较的是第 k 个位置的大小，prev 实际上是 k-2 位置上的最大值，cur 是 k - 1 位置上的最大值。
        // 复杂度分析：O（N），因为要遍历整个数组

        int prev = 0, cur = 0;
        for (int i : nums) {
            int tmp = cur;
            cur = Math.max(prev + i, cur);
            prev = tmp;
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
