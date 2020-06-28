//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
/**
 4.10 第一遍；4.22 第二遍，6.28 第三遍
 - 思路：双指针。从数组的两端往中间遍历。
 1. 因为面积 = 距离 x 较短挡板。所以要想找到更大的面积，应该移动短挡板。
 2. 这是因为：如果移动长挡板，只会出现面积不变或者更小两个可能。
 3. 将每次的面积与 maxArea 中对比，判断是否更新最大面积。
 */

class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int maxArea = 0;
        int relativeMin = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            relativeMin = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, relativeMin * (right - left));
            if (relativeMin == height[left]) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
