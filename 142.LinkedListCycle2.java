/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        boolean doesCycleExist = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                doesCycleExist = true;
                break;
            }
        }
        slow = head;
        if (doesCycleExist) {
            while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
            }
            return slow;
        }

        return null;
        
    }
}
