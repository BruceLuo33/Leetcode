//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.11 第一遍
 - 思路：位运算 + 动态规划。
 1. 方法一，i&(i-1) 可以清零最低位的 1，最低位不一定就是从右到左第一位。而这个数字是一定比 i 小的，也就是说一定是出现在 ans 数组里面过的，然后因为减去了一个 1，再将 ans 数组 +1 就可以了；
 2. 方法二：i >> 1 代表的是将 i/2，如果 i 是偶数，那么 ans[i] == ans[i >> 1]，而如果是 i 是奇数，则 ans[i] = ans[i >> 1] + 1，代表比 i/2 多了一个最低位的 1，因为是否 +1 和奇偶有关，所以用 i&1 来表示。
 */
class Solution {
    /**
     // Solution one:
     public int[] countBits(int num) {
     int[] ans = new int[num + 1];
     for (int i = 1; i <= num; i++) {
     ans[i] = ans[i & (i-1)] + 1;
     }
     return ans;
     }
     */
    // Solution two:
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
