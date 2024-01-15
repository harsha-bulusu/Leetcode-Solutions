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

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    void printLinkedList(ListNode head) {
        ListNode cursor = head;
        while (cursor != null) {
            System.out.print(cursor.val + " ");
            cursor = cursor.next;
        }
        System.out.println();
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        // set positions
        ListNode leftNode = null;
        ListNode leftPrevNode = null;
        ListNode rightNode = null;
        ListNode cursor = head;
        int count = 1;
        while (cursor != null) {
            if (count == left) {
                leftNode = cursor;
            }
            if (count == right) {
                rightNode = cursor;
                break;
            }
            if (leftNode == null) leftPrevNode = cursor;
            cursor = cursor.next;
            count += 1;
        }


        ListNode rightNextNode = rightNode.next;
        rightNode.next = null;
        ListNode revHead = reverse(leftNode);
        if (leftPrevNode == null) head = revHead;
        else leftPrevNode.next = revHead;
        leftNode.next = rightNextNode;
        
        return head;
    }
}
