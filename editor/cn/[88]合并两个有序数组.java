//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 4.15 第一遍，4.22 第二遍，5.6 第三遍，6.15 第四遍
 - 思路：双指针，一个指向 nums1 末尾，一个指向 nums2 末尾。比较两个指针指向元素的大小，将较大者放到数组末尾，依次遍历整个数组。
 - 注意：最后还需要用 arraycopy 将 nums2 数组复制到 nums1 数组中。因为当出现这种情况时：`nums1 = [0], m = 0; nums2 = [1], n = 1`，因为我们的指针是指向末尾，即 `oneEnd = m - 1`，此时就不会进入到 `while(oneEnd >= 0 && twoEnd >= 0)` 的循环，导致最终报错。
 - 复杂度：O（min（m，n）），空间复杂度：O（1）

 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int start1 = m - 1, start2 = n - 1;
        while (start1 >= 0 && start2 >= 0) {
            nums1[len--] = nums1[start1] >= nums2[start2] ? nums1[start1--] : nums2[start2--];
        }
        while (start2 >= 0) {
            nums1[len--] = nums2[start2--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
