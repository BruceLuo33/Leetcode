//给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1: 
//
// 输入: "bcabc"
//输出: "abc"
// 
//
// 示例 2: 
//
// 输入: "cbacdcbc"
//输出: "acdb" 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
// Related Topics 栈 贪心算法


//leetcode submit region begin(Prohibit modification and deletion)
/**
 7.26 第一遍
 - 思路：单调栈，关键在于 visited 数组的作用，在 while 循环之后，如果曾经放入过栈中，就不能继续将其防入栈中，同时要将freq -= 1；
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        int m = s.length();
        char[] sChar = s.toCharArray();
        int[] freq = new int[26];
        boolean[] isVisited = new boolean[26];
        for (char c : sChar) {
            freq[c - 'a'] += 1;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            while (stack.size() > 0 && stack.peekLast() > sChar[i] && freq[stack.peekLast() - 'a'] > 1 && !isVisited[sChar[i] - 'a']) {
                Character tmp = stack.pollLast();
                freq[tmp - 'a'] -= 1;
                isVisited[tmp - 'a'] = false;
            }
            if (isVisited[sChar[i] - 'a']) {
                freq[sChar[i] - 'a'] -= 1;
                continue;
            }
            stack.offerLast(sChar[i]);
            isVisited[sChar[i] - 'a'] = true;
        }
        char[] ans = new char[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.pollFirst();
        }
        return new String(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
