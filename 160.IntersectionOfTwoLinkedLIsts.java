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
public class Solution {

    /**
        * Find the difference betweeen two lists
        * Adjust the pointers based on the difference such that two pointers will be having equal distance to 
        the intersection
        * now move the cursors until the end of list and compare two pointers
        * if equal return matching node else return null
     */

    int difference(ListNode headA, ListNode headB) {

        int aLen = 0;
        int bLen = 0;

        while (headA != null || headB != null) {
            if (headA != null) {
                aLen++;
                headA = headA.next;
            }

            if (headB != null) {
                bLen++;
                headB = headB.next;
            }
        }

        return aLen - bLen;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int diff = difference(headA, headB);
        if (diff < 0) {
            while (diff++ != 0) headB = headB.next;
        } else {
            while (diff-- != 0) headA = headA.next;
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
