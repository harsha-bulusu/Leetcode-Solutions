class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        for i in range(len(nums)):
            if nums[i] < target:
                if nums[i] == target:
                    return i
            else:
                return i
        return len(nums)
