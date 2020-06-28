//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.28 第一遍
 - 思路：模运算、队列。
 */
class Solution {
    public int reverse(int x) {
        if (x / 10 == 0) return x; // one digit
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        if (ans > Integer.MAX_VALUE ) return 0;
        return (int)ans == ans ? (int)ans : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
