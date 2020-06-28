//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.28 第一遍
 - 思路：循环。
 - 注意：要先去掉末尾的空格（如果有的话）
 - 复杂度分析：O（N）

 */
class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int len = s.length();
        int count = 0;
        char[] sChar = s.toCharArray();
        int end = len - 1;
        for (int last = len - 1; last >= 0; last--) {
            end = last;
            if (sChar[last] != ' ') break;
        }
        for (int last = end; last >= 0; last--) {
            if (sChar[last] == ' ') return count;
            count += 1;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
