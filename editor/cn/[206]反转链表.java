//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 4.20 第一遍，7.2 第三遍
 - 思路：链表的题，画图就是了。
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode tmp = null;
        if (head == null) return prev;
        while (head != null) {
            tmp = head.next; //保存 Node2 之后的链表
            head.next = prev; // 将 Node1 指向前节点。在第一步中是指向一个空节点
            prev = head; // 将prev/head 指针向后各自移动一步
            head = tmp;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
