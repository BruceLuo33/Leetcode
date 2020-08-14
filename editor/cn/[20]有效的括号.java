//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.28 第一遍，8.14 第二遍
 - 思路：栈。题目的要求并不仅仅是左括号的数量等于右括号，而且还要中间没有其他括号：
 1. 遇到左括号，就将其对应的右括号压入栈；
 2. 如果不是左括号，就判断是否等于栈顶元素，如果不是，说明两个对应的括号中间有其他左括号，return false；
 3. 如果是空栈，也要return false；
 4. 最后的返回项，不是 true，因为可能 string 中全都是左括号，这样 for 循环也不会报错，因此需要返回 stack.isEmpty();
 - 复杂度分析：O（N）
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 1) return false;
        char[] sChar = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : sChar) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
