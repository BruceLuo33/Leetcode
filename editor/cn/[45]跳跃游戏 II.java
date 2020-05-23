//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.15 第一遍，5.23 第二遍
 思路：贪心算法，和 55 题思路还是比较相似，
 1. 以第一个位置为起跳点，例如 `nums[0] = 3`，说明第一个格子能跳三格，nums[3] 为第二个节点，count = 2；
 2. 然后，找到这三格中的最大数值，代表的即为这三个格子中最远能达到的距离，它即为下一个节点。
 3. 因为最后一个位置代表已经到达目标，所以循环终止条件应该为 `i < nums.length - 1`
 复杂度分析：O（N）
 */

class Solution {
    public int jump(int[] nums) {
        int pos = 0, nextPos = 0, count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextPos = Math.max(i + nums[i], nextPos);
            if (nextPos >= nums.length - 1) {
                return count + 1;
            }
            if (i == pos) {
                count += 1;
                pos = nextPos;
            }

        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
