class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums1.extend(nums2)
        merged_array = sorted(nums1)
        #length
        length = len(merged_array)
        if length % 2 == 0:
            median = (length//2)-1
            return (merged_array[median]+merged_array[median+1])/2
        median = int(length/2)
        return merged_array[median]

        
