//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
4.27 第一遍，5.4 第二遍，8.7 第三遍，12.1 第四遍
思路一：递归。
- 要判断两个树是否相等，需要从两个角度：结构和值；
  - 结构：如果 p 和 q 都是 null，那么说明这两个树 or 当前子树结构相等；而如果只有一个为 null，代表某一棵树走到头的时候，另一个还没有，因此结构不相等；
  - 值：这个很简单，直接判断 val 是否相等；
- 判断完当前根节点之后，再去递归的判断左子树和右子树
思路二：DFS，用栈实现。
复杂度：O（N），空间复杂度：O（1）
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
