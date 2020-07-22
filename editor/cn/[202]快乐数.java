//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。 
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.22 第一遍
 - 思路：快慢指针。slow 每次快乐一次，fast 每次快乐两次，如果两者相遇，说明要不就是陷入了死循环，要不就是都等于了 1，最后返回 fast ?= 1 就可以了
 */
class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        int result = 0;
        int slow = n, fast = n;
        do {
            slow = add(slow);
            fast = add(fast);
            fast = add(fast);
        } while (fast != slow);
        return fast == 1;
    }
    private int add(int k) {
        int ans = 0;
        while (k > 0) {
            ans += (k % 10) * (k % 10);
            k /= 10;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
