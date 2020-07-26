//返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。 
//
// 
//
// 示例 1： 
//
// 输入："cdadabcc"
//输出："adbc"
// 
//
// 示例 2： 
//
// 输入："abcd"
//输出："abcd"
// 
//
// 示例 3： 
//
// 输入："ecbacba"
//输出："eacb"
// 
//
// 示例 4： 
//
// 输入："leetcode"
//输出："letcod"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 1000 
// text 由小写英文字母组成 
// 
//
// 
//
// 注意：本题目与 316 https://leetcode-cn.com/problems/remove-duplicate-letters/ 相同 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestSubsequence(String text) {
        int m = text.length();
        char[] sChar = text.toCharArray();
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
