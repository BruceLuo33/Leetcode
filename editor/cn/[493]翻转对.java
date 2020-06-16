//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.16 第一遍
 - 思路：归并排序。
 1. 首先是递归，递归之后，要统计逆序对个数：
 - 左指针从 left，右指针从 middle + 1，分别开始；
 - 如果 `r > right || nums[l] / 2.0 <= nums[r]`，说明 r 已经到了边界或者不是逆序对，因此需要往右边移动一位 l，并且将 count 添加到 ans 中；
 - else，说明是一个逆序对且 r 还在区间内，因此将 count++ 同时将 r 右移一位，继续寻找逆序对；
 - 因为递归的原因，count = 0 的初始化要写在 for-loop 之前；
 2. 然后是归并，新建一个 tmp 数组，用三个 while 来往 tmp 中填入值
 - `while (l <= middle && r <= right)`，进行排序，如果 nums[l] < nums[r]，代表左边的应该填入 tmp，同时将 tmp 的 idx 与 l += 1；反之，则是 idx 和 r += 1；
 - `while (l <= middle)`，进行了上一步操作，有可能左半边还没有归并完成，需要继续 `tmp[idx++] = nums[l++]`
 - `while (r <= right)`，同上
 - 复杂度分析：O(NlogN)；
 */
class Solution {
    public int ans;
    public int reversePairs(int[] nums) {
        ans = 0;
        if (nums.length < 2) return ans;
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int middle = (left + right) >> 1;
        // int middle = left + (right - left) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);
        int count = 0;
        // Count
        for (int l = left, r = middle + 1; l <= middle; ) {
            if (r > right || nums[l] / 2.0 <= nums[r]) {
                l += 1;
                ans += count;
            } else {
                r += 1;
                count += 1;
            }
        }
        // Merge Sort
        int[] tmp = new int[right - left + 1];
        int idx = 0;
        int l = left, r = middle + 1;
        while (l <= middle && r <= right) {
            tmp[idx++] = nums[l] <= nums[r] ? nums[l++] : nums[r++];
        }
        while (l <= middle) {
            tmp[idx++] = nums[l++];
        }
        while (r <= right) {
            tmp[idx++] = nums[r++];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[left + i] = tmp[i];
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
