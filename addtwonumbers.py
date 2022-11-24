# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        num1=''
        num2=''
        while(l1 != None):
            num1+=str(l1.val)
            l1=l1.next
        while(l2 != None):
            num2+=str(l2.val)
            l2=l2.next
        num1 = num1[-1::-1]
        num2 = num2[-1::-1]
        res = str(int(num1)+int(num2))[-1::-1]
        nodes = []
        for i in range(len(res)):
            if len(nodes) == 0:
                nodes.append(ListNode(int(res[i])))
            else:
                node = ListNode(int(res[i]))
                nodes[int(i)-1].next=node
                nodes.append(node)
        return nodes[0]
        
