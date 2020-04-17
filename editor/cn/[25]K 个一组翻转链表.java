//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode sub_head = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode toNull = head;
        while (sub_head != null) {
            int i = k;
            //找到子链表的尾部
            while (i - 1 > 0) {
                toNull = toNull.next;
                if (toNull == null) {
                    return dummy.next;
                }
                i--;
            }
            ListNode temp = toNull.next;
            //将子链表断开
            toNull.next = null;
            ListNode new_sub_head = reverse(sub_head);
            //将倒置后的链表接到 tail 后边
            tail.next = new_sub_head;
            //更新 tail
            tail = sub_head; //sub_head 由于倒置其实是新链表的尾部
            sub_head = temp;
            toNull = sub_head;
            //将后边断开的链表接回来
            tail.next = sub_head;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head) {
        ListNode current_head = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = current_head;
            current_head = head;
            head = next;
        }
        return current_head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
