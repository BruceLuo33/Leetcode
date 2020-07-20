//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.20 第一遍
 - 思路一：双指针。遍历数组，然后分别从每个位置往左右移动一个指针，找到最远的一个不小于 height[i] 的坐标，该位置的最大面积即为 heights[i] * (right - left + 1);
 - 复杂度分析：O(N^2)
 - 思路二：单调栈。
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        // Solution Two:
        if (heights == null || heights.length == 0) return 0;
        int m = heights.length;
        if (m == 1) return heights[0];
        int ans = 0;
        int[] newHeights = new int[m + 2];
        System.arraycopy(heights, 0, newHeights, 1, m);
        m += 2;
        // 创建 stack
        Deque<Integer> stack = new ArrayDeque<>(m);
        stack.addLast(0);

        for (int i = 1; i < m; i++) {
            while (newHeights[i] < newHeights[stack.peekLast()]) {
                int curHeight = newHeights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                ans = Math.max(ans, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return ans;



        // Solution One:
        // if (heights == null || heights.length == 0) return 0;
        // int m = heights.length;
        // int ans = 0;
        // for (int i = 0; i < m; i++) {
        //     // int left = i - 1, right = i + 1;
        //     int left = i, right = i;
        //     int tmpHeight = heights[i];
        //     while (left > 0 && heights[left - 1] >= tmpHeight) {
        //         left -= 1;
        //     }
        //     while (right < m - 1 && heights[right + 1] >= tmpHeight) {
        //         right += 1;
        //     }

        //     ans = Math.max(ans, tmpHeight * (right - left + 1));
        // }
        // return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
