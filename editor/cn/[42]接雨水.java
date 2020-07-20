//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.20 第一遍
 - 思路：双指针
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 0) return 0;
        int m = height.length;
        int left = 0, right = m - 1;
        int maxLeft = 0, maxRight = 0;
        int ans = 0;
        while (left <= right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (maxLeft < maxRight) {
                ans += maxLeft - height[left];
                left += 1;
            } else {
                ans += maxRight - height[right];
                right -= 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
