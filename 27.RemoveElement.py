class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        k = 0
        j = 1
        limit = len(nums)
        i = 0
        while i < limit:
            if nums[i] != val:
                k += 1
            else:
                if i == limit - 1:
                    i += 1
                    continue
                elif i + j < limit and nums[i] != nums[i + j]:
                    temp = nums[i]
                    nums[i] = nums[i + j]
                    nums[i + j] = temp
                    j = 1
                    k += 1
                elif i + j < limit:
                    j += 1
                    continue
            i += 1
        return k 
