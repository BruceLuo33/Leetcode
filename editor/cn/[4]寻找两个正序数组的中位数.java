//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.1 第一遍
 - 思路：二分查找。将目标从找中位数，转为求第 k 大的元素。

 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenOne = nums1.length;
        int lenTwo = nums2.length;
        int left = (lenOne + lenTwo + 1) / 2;
        int right = (lenOne + lenTwo + 2) / 2;
        return (findKthNum(nums1, nums2, 0, 0, lenOne - 1, lenTwo - 1, left) + findKthNum(nums1, nums2, 0, 0, lenOne - 1, lenTwo - 1, right)) * 0.5;
    }

    private int findKthNum(int[] nums1, int[] nums2, int startOne, int startTwo, int endOne, int endTwo, int k) {
        int subLenOne = endOne - startOne + 1;
        int subLenTwo = endTwo - startTwo + 1;
        // 确保 subLenOne 是较短的那一个
        if (subLenOne > subLenTwo) return findKthNum(nums2, nums1, startTwo, startOne, endTwo, endOne, k);
        if (subLenOne == 0) return nums2[startTwo + k - 1];
        if (k == 1) return Math.min(nums1[startOne], nums2[startTwo]);

        int i = startOne + Math.min(k / 2, subLenOne) - 1;
        int j = startTwo + Math.min(k / 2, subLenTwo) - 1;

        if (nums1[i] > nums2[j]) {
            return findKthNum(nums1, nums2, startOne, j + 1, endOne, endTwo, k - (j - startTwo + 1));
        } else {
            return findKthNum(nums1, nums2, i + 1, startTwo, endOne, endTwo, k - (i - startOne + 1));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
