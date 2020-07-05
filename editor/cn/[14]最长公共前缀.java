//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.5 第一遍
 - 思路：纵向匹配
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        // Find the dimension of grid matrix
        int m = strs.length;
        int n = Integer.MAX_VALUE;
        for (String s : strs) {
            n = Math.min(n, s.length());
        }
        char[][] grid = new char[m][n];
        // char[] ans = new char[n];
        String ans = "";
        for (int i = 0; i < m; i++) {
            grid[i] = strs[i].toCharArray();
        }
        // 利用 outer 跳出双层循环
        outer: for (int j = 0; j < n; j++) {
            boolean flag = true;
            for (int i = 1; i < m; i++) {
                if (grid[i][j] != grid[i-1][j]) break outer;
            }
            String tmp = String.valueOf(grid[0][j]);
            ans += tmp;
        }
        return new String(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
