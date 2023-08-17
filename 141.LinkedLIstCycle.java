public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode cursor = head;
        Set<ListNode> nodes = new HashSet<>();
        while (cursor != null) {
            if (!nodes.add(cursor)){
                return true;
            }
            cursor = cursor.next;
        }
        return false;
        
        
    }
}
