/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
        * Approach
            1. Find the middle element of the linked list
            2. Reverse the right half of the linked list
            3. Assign two pointers one at head and second one at mid.next
            4. move these pointers by one step until the end of LL and compare values of these pointers
            5. if not equal return false else retur true
     */


    ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head) {
        ListNode newNode = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newNode;
            newNode = head;
            head = next;
        }

        return newNode;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        mid.next = reverse(mid.next);
        ListNode c1 = head;
        ListNode c2 = mid.next;
        while (c2 != null) {
            if (c1.val != c2.val) return false;
            c1 = c1.next;
            c2 = c2.next;
        }
        return true;
    }
}
