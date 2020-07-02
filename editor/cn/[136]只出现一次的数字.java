//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.2 第一遍
 - 思路：
 1. 一开始想到可以用 HashMap，但是有两个问题，第一个就是如何找到 value 为 1 对应的 key，因为 HashMap 只有 containsValue 和 get 方法；同时，还会增加额外空间，不符合题意；
 2. 复杂度其实最佳也只能是 O（N），因为要遍历整个数组，难度其实在于空间复杂度，不能使用额外的空间复杂度这一个问题。
 3. 看了评论区才知道，这道题要用位运算。
 */
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int n : nums) {
            a = a ^ n;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
