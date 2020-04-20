//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode listOneEnd = null, listTwoEnd = null;
        int i = 0;
        while (head != null) {
            // i 的初始值要设置为零，并且 i++ 要在三个 if 判断之前
            // 因为若在最后才进行 i++，则因为 continue 的存在，
            // 会使得在 m ~ n 这一部分没有执行 i++。造成环形链表，不停的互相指向。
            i += 1;
            if (i == m ) {
                // listOneEnd 指向 m 之前链表的最后一个node
                // listTwoEnd 指向当前的 m 节点，在翻转之后，这将成为最后一个node
                listOneEnd = prev;
                listTwoEnd = head;
            }
            if (i > m && i < n) {
                // 翻转链表
                // 将后一个 node 的指针指向前一个 node
                ListNode tmp = head.next;
                head.next = prev;
                prev = head;
                head = tmp;
                continue; // 在这个 if 语句中，已经进行了指针的移动，不再需要额外移动指针
            }
            if (i == n) {
                // 链表翻转在此结束，然后进行链表拼接
                // leftOneEnd 指向
                ListNode tmp = head.next;
                head.next = prev;
                listOneEnd.next = head;
                listTwoEnd.next = tmp;
                break;
            }
            // 在三种情况之外，需要手动额外移动 prev 与 head 指针
            head = head.next;
            prev = prev.next;
//            i += 1;
        }
        return sentinel.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
