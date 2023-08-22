class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        c1 = c2 = 0
        
        #copy numbers of nums1 to a temp array
        temp = []
        for i in nums1:
            temp.append(i)

        #remove all elements from nums1
        for i in range(0, len(nums1)):
            nums1.pop()

        while c1 < m and c2 < n:
            if temp[c1] < nums2[c2]:
                nums1.append(temp[c1])
                c1+=1
            else:
                nums1.append(nums2[c2])
                c2+=1
        
        #Add remaining elements if any
        if c1 < m:
            for i in range(c1, m):
                nums1.append(temp[i])
        
        if c2 < n:
            for i in range(c2, n):
                nums1.append(nums2[i])
