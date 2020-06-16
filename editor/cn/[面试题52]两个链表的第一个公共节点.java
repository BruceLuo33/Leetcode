//输入两个链表，找出它们的第一个公共节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
//ts/ 
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 6.16 第一遍
 - 思路：双指针法。两种写法：
 - 思路一：
 1. 假设链表A的长度是： a + c，链表B的长度是 b + c，c 为公共部分的长度，a/b 为非公共部分的长度；
 2. 设置 curA 和 curB，分别开始指向 headA & headB，让他们每次往后移动一步，如果到达终点，则将其指向另一个链表的开头，这样每个指针在相遇之前，都会走 a + b + c 的距离，此时也就是第一个公共节点的位置；
 - 思路二：
 1. a、b、c 的定义同前，但是这次用一个辅助函数先求得每个 list 的长度；
 2. 让较长的那个链表先走到 lengthA - lengthB 的位置，然后两个链表一起往后走，直到相等；
 复杂度分析：O(M+N)
 */
public class Solution {

    // Solution Two
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     if (headA == null || headB == null) return null;
    //     ListNode curA = headA;
    //     ListNode curB = headB;
    //     while (curA != curB) {
    //         curA = curA == null ? headB : curA.next;
    //         curB = curB == null ? headA : curB.next;
    //     }
    //     return curA;
    // }

    // Solution Two
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode curA = headA, curB = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                curB = curB.next;
            }
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
    private int getLength(ListNode headA) {
        int length = 0;
        ListNode tmp = headA;
        while (tmp != null) {
            length += 1;
            tmp = tmp.next;
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
