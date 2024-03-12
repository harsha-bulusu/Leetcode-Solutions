// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {

//     int len(ListNode head) {
//         ListNode cursor = head;
//         int len = 0;
//         while(cursor != null) {
//             len++;
//             cursor = cursor.next;
//         }
//         return len;
//     }

//     public ListNode middleNode(ListNode head) {
//         int len = len(head);
//         int mid = len / 2;
//         ListNode cursor = head;
//         for (int i=0; i<mid; i++) {
//             cursor = cursor.next;
//         }
//         return cursor;
//     }
// }

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next != null) { // if list is even size
            return slow.next;
        }
        return slow; // if list is odd
    }
}
