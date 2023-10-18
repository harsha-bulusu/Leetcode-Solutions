/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {

        ListNode curr = node;
        ListNode prev = null;

        while (curr.next != null) {
            ListNode next = curr.next;
            int temp = curr.val;
            curr.val = next.val;
            next.val = temp;

            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        
    }
}
