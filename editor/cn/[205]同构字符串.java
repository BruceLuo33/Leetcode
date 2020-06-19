//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.19 第一遍
 - 思路：HashMap
 1. 主要是对应关系，每一个 s 中的字符，都要唯一对应 t 中的字符，即 key 为 s 字符，value 为 t 字符
 2. 如果 map 中没有 s[i]，一开始想着可以直接put map，但是还有一种情况没考虑到，就是这时候如果 map 中还有 t[i]，那么说明就不是一一对应的关系了，要 return false；
 3. 如果有 s[i]，但是对应的 value 不等于 t[i]，也不是一一对应，return false；
 - 复杂度分析：O(N)
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < sChar.length; i++) {
            char tmpS = sChar[i];
            char tmpT = tChar[i];
            if (!map.containsKey(tmpS) ) {
                if (map.containsValue(tmpT)) return false;
                map.put(tmpS, tmpT);
            } else {
                if (map.get(tmpS) != tmpT) return false;
            }

        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
