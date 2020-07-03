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
/**
 4.16 第一遍，4.22 第二遍，5.6 第三遍，7.2 第四遍
 - 思路：
 1. 如果是空节点 or 单节点，直接返回 head;
 2. 设置 sentinel 节点指向初始的 head，方便最终结果返回，这也是很多链表题的技巧;
 3. 设置 nextMove 节点，保证 nextMove.next 一直指向 head;
 4. 设置 tmp 保存反转节点之后的 node，即 head.next.next;
 - 注意：在循环的最后，要记得将 head 也指向tmp，亦即之前的 head.next.next，否则会出现以下情况

 ```Java
 Original: 1 -> 2 -> 3 -> 4
 First swap: 2 -> 1 -> 3 -> 4
 Second swap: 2 -> 3 -> 1 -> 4 (×)
 2 -> 1 -> 4 -> 3 (√)
 ```
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode nextNodeMove = sentinel;
        while (head != null && head.next != null) {
            ListNode tmp = head.next.next;
            nextNodeMove.next = head.next;
            head.next.next = head;
            head.next = tmp;
            nextNodeMove = head;
            head = tmp;
        }
        return sentinel.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
