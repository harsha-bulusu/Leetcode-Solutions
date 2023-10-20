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
    
    List<Integer> extractValues(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode cursor = head;
        while(cursor != null) {
            values.add(cursor.val);
            cursor = cursor.next;
        }
        return values;
    }

    public ListNode reverseList(ListNode head) {
        List<Integer> values = extractValues(head);
        ListNode cursor = head;
        for (int i = values.size() - 1; i >= 0; i--) {
            cursor.val = values.get(i);
            cursor = cursor.next;
        }
        return head;
    }
}
