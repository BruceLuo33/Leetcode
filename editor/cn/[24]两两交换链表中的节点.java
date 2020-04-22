//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        // 4.16 第一遍，4.22 第二遍
        // 思路：链表的转换更新。画出指针与node的图就行了

        // 4.22 codes
        if (head == null || head.next == null) return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode move = sentinel;
        while (head != null && head.next!= null) {
            ListNode tmp = head.next.next;
            move.next = head.next;
            head.next.next = head;
            head.next = tmp;
            move = head;
            head = tmp;
        }
        return sentinel.next;

        // 4.16 codes
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cur = sentinel;
        while (cur.next != null && cur.next.next != null) {
//            ListNode nodeOne = head;
            ListNode nodeOne = cur.next;
            ListNode nodeTwo = cur.next.next;
            cur.next = nodeTwo;
            nodeOne.next = nodeTwo.next;
            nodeTwo.next = nodeOne;
            cur = nodeOne;
        }
        return sentinel.next;
    }



}
//leetcode submit region end(Prohibit modification and deletion)
