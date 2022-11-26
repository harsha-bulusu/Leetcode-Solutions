#TwoSum
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        e1_index = 0
        e2_index = 1
        max_index = len(nums)-1
        while e1_index < max_index:
            if nums[e1_index]+nums[e2_index] == target:
                return [e1_index, e2_index]
            elif (e2_index+1)<=max_index:
                e2_index+=1
                continue
            if e2_index == max_index:
                e1_index += 1
                e2_index = e1_index+1
