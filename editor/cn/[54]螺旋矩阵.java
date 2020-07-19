//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.19 第一遍
 - 思路：螺旋遍历，本质上还是一条边一条边的进行遍历。那么我们每次都将已经遍历过的边去掉，剩下的就是如同剥洋葱一样的不断减少的数组。这个过程通过控制上下左右四个变量来实现。
 - 复杂度分析：O（M*N）
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;
        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m - 1;
        int left = 0, right = n - 1;
        while (true) {
            for (int i = left; i <= right; i++) ans.add(matrix[up][i]);
            up += 1;
            if (up > down) break;

            for (int i = up; i <= down; i++) ans.add(matrix[i][right]);
            right -= 1;
            if (left > right) break;

            for (int i = right; i >= left; i--) ans.add(matrix[down][i]);
            down -= 1;
            if (up > down) break;

            for (int i = down; i >= up; i--) ans.add(matrix[i][left]);
            left += 1;
            if (left > right) break;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
