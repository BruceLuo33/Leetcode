//指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。 
//
// 
//
// 示例 1： 
//
// 输入：Y = 1992, M = 7
//输出：31
// 
//
// 示例 2： 
//
// 输入：Y = 2000, M = 2
//输出：29
// 
//
// 示例 3： 
//
// 输入：Y = 1900, M = 2
//输出：28
// 
//
// 
//
// 提示： 
//
// 
// 1583 <= Y <= 2100 
// 1 <= M <= 12 
// 
//


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.26 第一遍
 - 思路：闰年的定义
 */
class Solution {
    public int numberOfDays(int Y, int M) {
        int[] monthDay = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (M != 2) return monthDay[M - 1];
        if (isLeapYear(Y)) return 29;
        return monthDay[1];
    }
    private boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
