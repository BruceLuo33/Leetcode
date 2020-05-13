//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.13 第一遍
 思路：BFS。


 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[wordList.size()];
        int depth = 0;
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {
            isVisited[idx] = true;
        }
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth += 1;
            while (size > 0) {
                String start = queue.poll();
                size -= 1;
                for (int j = 0; j < wordList.size(); ++j) {
                    if (isVisited[j]) {
                        continue;
                    }
                    String tmp = wordList.get(j);
                    if (!convert(start, tmp)) {
                        continue;
                    }
                    if (tmp.equals(endWord)) {
                        return depth + 1;
                    }
                    isVisited[j] = true;
                    queue.offer(tmp);
                }
            }
        }
        return 0;
    }

    private boolean convert(String one, String two) {
        // if (one.length() != two.length()) return false;
        int count = 0;
        for (int i = 0; i < one.length(); ++i) {
            if (one.charAt(i) != two.charAt(i)) {
                // count += 1;
                ++ count;
                if (count > 1) return false;
            }
        }
        return count == 1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
