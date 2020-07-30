//给定一个整数，写一个函数来判断它是否是 3 的幂次方。 
//
// 示例 1: 
//
// 输入: 27
//输出: true
// 
//
// 示例 2: 
//
// 输入: 0
//输出: false 
//
// 示例 3: 
//
// 输入: 9
//输出: true 
//
// 示例 4: 
//
// 输入: 45
//输出: false 
//
// 进阶： 
//你能不使用循环或者递归来完成本题吗？ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.30 第一遍
 - 思路一：循环
 - 思路二：位运算
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        while (n > 2) {
            int residual = n % 3;
            if (residual != 0) return false;
            n = n / 3;
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
