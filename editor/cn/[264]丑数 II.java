//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        // 4.25 第一遍
        // 思路：和263不同，这里是需要将丑数的规律找出来，类似于找到一个通项公式。
        // 通过观察可以发现，每一个丑数，都是 2x1、3x1、5x1 …… 2xN、3xN、5xN 来得出的，
        // 然后再排序，就得到了最终的丑数序列。
        // 注意：在判断最小值

        int[] ans = new int[n];
        ans[0] = 1;
        int factor2 = 0, factor3 = 0, factor5 = 0;
        int index2 = 0, index3 = 0, index5 = 0;

        for (int i = 1; i < n; i++){
            factor2 = 2 * ans[index2];
            factor3 = 3 * ans[index3];
            factor5 = 5 * ans[index5];
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ans[i] = min;
            if (factor2 == min) index2 += 1;
            if (factor3 == min) index3 += 1;
            if (factor5 == min) index5 += 1;
        }
        return ans[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
