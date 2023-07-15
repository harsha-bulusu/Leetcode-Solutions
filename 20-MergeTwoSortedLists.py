# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 == None:
            return list2
        if list2 == None:
            return list1

        #merge lists
        tail = list1
        while tail.next != None:
            tail = tail.next
        tail.next = list2

        c1 = list1
        c2 = list1.next
        
        while c1.next != None:
            if c2 == None:
                c1 = c1.next
                c2 = c1.next
                continue
            
            if c1.val == c2.val:
                if c1.next != None:
                    temp = c1.next.val
                    c1.next.val = c2.val
                    c2.val = temp
                else:
                    c1.next = c2
            
            if c1.val > c2.val:
                temp = c1.val
                c1.val = c2.val
                c2.val = temp

            c2 = c2.next

        return list1 
              
       
                
