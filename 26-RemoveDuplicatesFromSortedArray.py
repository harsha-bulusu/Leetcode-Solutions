class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
       count=1
       for cursor in range(1, len(nums)):
           if nums[cursor] != nums[cursor - 1]:
               nums[count] = nums[cursor]
               count += 1
       return count
