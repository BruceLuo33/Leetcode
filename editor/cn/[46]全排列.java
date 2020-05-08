//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 5.8 第一遍
    // 思路一：回溯。
    // 注意：在result.add(路径)这里，括号内要写 `new LinkedList<Integer>(track)` 而不能简单的写 `track`。否则会出现空链表。
    // 复杂度分析：O（N）
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        helper(nums, track);
        return ans;
    }

    private void helper(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            ans.add(new LinkedList<Integer>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;

            track.add(nums[i]);
            helper(nums, track);
            track.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
