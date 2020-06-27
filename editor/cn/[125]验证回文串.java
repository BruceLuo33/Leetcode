//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.27 第一遍
 - 思路：前后双指针。
 1. 判断是否是数字或者是字母：Character.isLetterOrDigit();
 2. 全部转成大写：(c & 0xDF)；全部转成小写：(c | 0x20)
 - 复杂度分析：O（N）
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) return true;
        int first = 0, last = s.length() - 1;
        char[] sChar = s.toCharArray();
        while (first <= last) {
            char i = sChar[first], j = sChar[last];
            if (!Character.isLetterOrDigit(i)) {
                first += 1;
                continue;
            }
            if (!Character.isLetterOrDigit(j)) {
                last -= 1;
                continue;
            }
            if ((i & 0xDF) == (j & 0xDF)) {
                first += 1;
                last -= 1;
            } else return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
