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
        * 1. Find the length of the linked list and connect the tail to its head to make it circular list
        * 2. Obtain K value k = length % K (If in case k is greater than length this is helpful for 
             reducing iterations)
        * 3. Move to the position K from the end and mark it as head
        * 4. Remove the link from tail to make it non-ciruclar (tail node index = length - k)

     */

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 1;
        ListNode cursor = head;
        while(cursor.next != null) {
            cursor = cursor.next;
            len++;
        }
        cursor.next = head; //Making the list circular

        k = k % len;
        int tailIndex = len - k;
        cursor = head;
        for(int i=0; i<tailIndex - 1; i++){
            cursor = cursor.next;
        }

        head = cursor.next;
        cursor.next = null;
        return head;
    }
}
