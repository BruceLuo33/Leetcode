//根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。 
//
// 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dea
//d）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律： 
//
// 
// 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡； 
// 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活； 
// 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡； 
// 如果死细胞周围正好有三个活细胞，则该位置死细胞复活； 
// 
//
// 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生
//和死亡是同时发生的。 
//
// 
//
// 示例： 
//
// 输入： 
//[
//  [0,1,0],
//  [0,0,1],
//  [1,1,1],
//  [0,0,0]
//]
//输出：
//[
//  [0,0,0],
//  [1,0,1],
//  [0,1,1],
//  [0,1,0]
//] 
//
// 
//
// 进阶： 
//
// 
// 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。 
// 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？ 
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.19 第一遍
 - 思路：题目要求要用原地算法解决，以开始没想到要怎么处理，后面看了解答才想到不一定只能用0/1，还可以用 2/3 来表示中间的过渡状态，然后在最后的时候将其还原。
 - 四个状态：0-死亡，1-存活，2-从存活到死亡，3-从死亡到存活
 - 如果 board[i][j] 等于 1 or 2，代表上一轮是活着的，及变化之前是活着的
 - 注意：判断 if 内的条件时，要根据索引不能越界来判断，例如 board[i - 1][j] 就只需要 i > 0 而不需要判断 j > 0
 - 复杂度分析：O（M*N）
 */
class Solution {
    public void gameOfLife(int[][] board) {
        // base case:
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        // Start change:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;
                // 上方
                if (i > 0) {
                    liveCount += (board[i - 1][j] == 1 || board[i - 1][j] == 2) ? 1 : 0;
                }
                // 下方
                if (i < m - 1) {
                    liveCount += (board[i + 1][j] == 1 || board[i + 1][j] == 2) ? 1 : 0;
                }
                // 左方
                if (j > 0) {
                    liveCount += (board[i][j - 1] == 1 || board[i][j - 1] == 2) ? 1 : 0;
                }
                // 右方
                if (j < n - 1) {
                    liveCount += (board[i][j + 1] == 1 || board[i][j + 1] == 2) ? 1 : 0;
                }
                // 左上
                if (i > 0 && j > 0) {
                    liveCount += (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2) ? 1 : 0;
                }
                // 右上
                if (i > 0 && j < n - 1) {
                    liveCount += (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2) ? 1 : 0;
                }
                // 左下
                if (i < m - 1 && j > 0) {
                    liveCount += (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2) ? 1 : 0;
                }
                // 右下
                if (i < m - 1 && j < n - 1) {
                    liveCount += (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2) ? 1 : 0;
                }

                // 将状态从 0/1 改成 0/1/2/3
                // 不变的情况：liveCount == 2 or 3，活细胞仍然不变
                if ((liveCount < 2 || liveCount > 3 ) && board[i][j] == 1) {
                    board[i][j] = 2;
                } else if (liveCount == 3 && board[i][j] == 0) {
                    board[i][j] = 3;
                }
            }
        }

        // Recover:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
