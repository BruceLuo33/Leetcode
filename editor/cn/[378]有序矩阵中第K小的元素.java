//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例： 
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 
//
// 提示： 
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.2 第一遍
 - 思路：二维二分法。
 1. 左上角元素是下界，右下角元素是上界，划定出一个值域，第 k 小的元素肯定在这个值域中
 2. 我们对值域进行二分查找，逼近值域中的目标值——第 k 小的元素
 3. 算出中间值，并求出矩阵里小于等于这个中间值的有几个，用 count 来记录个数
 4. count 和 k 比较，如果比 k 小，说明中间值小了，调整值域范围，否则，说明中间值大了，调整值域范围，一步步锁定目标值
 5. 可以从 matrix 的左下角或者右上角出发，和 240.搜索二维矩阵II 这道题一样。

 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (findKth(matrix, k, mid, n) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int findKth(int[][] matrix, int k, int mid, int n) {
        int row = n - 1;
        int col = 0;
        int count = 0;
        while (row >= 0 && col < n) {
            if (mid >= matrix[row][col]) {
                count += row + 1;
                col += 1;
            } else {
                row -= 1;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
