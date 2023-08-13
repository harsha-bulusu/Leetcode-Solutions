# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head
        cursor1 = head
        cursor2 = head.next
        while cursor2 != None:
            if cursor1.val == cursor2.val:
                cursor1.next = cursor2.next
                cursor2 = cursor1.next
            else:
                cursor1 = cursor1.next
                cursor2 = cursor2.next
        
        return head
