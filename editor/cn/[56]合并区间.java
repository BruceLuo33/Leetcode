//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.15 第一遍
 - 思路：贪心算法。
 1. 先对所有子区间的左边界进行排序，那么我们的问题就从要比较左边界 + 右边界，变成了只要考虑右边界了；
 2. 比较上一个区间和这一个区间的值，具体而言，上一个区间的右边界 compair[1] 和这一个区间的左边界 cur[0] 的相对大小
 - 如果 compair[1] < cur[0]，说明这两个区间根本就没有交集，那么将 cur 加入到 ans；
 - else，说明这两个区间有交集，但是注意，不能简单的就认为 cur[1] > compair[1]，事实上前一个区间可能更长，所以要将 compair[1] 更新为两者中的较大值
 3. 最后返回的是 int[][]，所以还需要将 List 转换成 int[][]
 复杂度分析：O(N*logN)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curIntervals = intervals[i];
            int[] compair = ans.get(ans.size() - 1);
            if (curIntervals[0] > compair[1]) {
                ans.add(curIntervals);
            } else {
                compair[1] = Math.max(curIntervals[1], compair[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
