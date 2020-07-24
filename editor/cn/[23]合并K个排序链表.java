//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 7.24 第一遍
 - 思路一：小顶堆
 - 思路二：分治
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return helper(0, lists.length - 1, lists);
    }
    private ListNode helper(int begin, int end, ListNode[] lists) {
        if (begin == end) return lists[begin];
        int mid = begin + (end - begin) / 2;
        ListNode left = helper(begin, mid, lists);
        ListNode right = helper(mid + 1, end, lists);
        return merge(left, right);
    }
    private ListNode merge(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        } else if (a.val < b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }

// Solution One：
    // public ListNode mergeKLists(ListNode[] lists) {
    // if (lists == null || lists.length == 0) return null;
    // PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
    //     @Override
    //     public int compare(ListNode one, ListNode two) {
    //         return one.val - two.val;
    //     }
    // });

    // for (ListNode node : lists) {
    //     while (node != null) {
    //         pq.add(node);
    //         node = node.next;
    //     }
    // }
    // ListNode sentinel = new ListNode(0);
    // ListNode head = sentinel;
    // while(!pq.isEmpty()) {
    //     head.next = pq.remove();
    //     head = head.next;
    // }
    // // 这一步很重要，为了防止形成环
    // head.next = null;
    // return sentinel.next;
    // }
}
//leetcode submit region end(Prohibit modification and deletion)
