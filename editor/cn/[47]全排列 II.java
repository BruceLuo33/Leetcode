//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
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
