//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
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
4.24 第一遍，7.28 第二遍
思路一：递归。从 root 出发，最大的深度等于 1+ 左/右 的node 最大深度。
思路二：BFS
复杂度分析：O（N），空间复杂度：O（1）
*/
class Solution {
    public int maxDepth(TreeNode root) {
        // Solution One
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        // Solution Two
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int depth = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                depth += 1;
                for (int i = 0; i < size; i++) {
                    TreeNode tmpNode = queue.poll();
                    if (tmpNode.left != null) queue.offer(tmpNode.left);
                    if (tmpNode.right != null) queue.offer(tmpNode.right);
                }
            }
            return depth;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
