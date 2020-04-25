//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        // 4.25 第一遍
        // 思路：遍历循环。
        // 注意：matrix.length 求的是行数，即 i。
        // 注意：对于二维矩阵，i/j 的相对关系要搞清楚。

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        List<Integer> rowIdx = new ArrayList<>();
        List<Integer> colIdx = new ArrayList<>();
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    rowIdx.add(i);
                    colIdx.add(j);
                }
            }
        }

        for (Integer i : rowIdx) {
            for (int j = 0; j < colLen; j++) {
                matrix[i][j] = 0;
            }
        }

        for (Integer j : colIdx) {
            for (int i = 0; i < rowLen; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
