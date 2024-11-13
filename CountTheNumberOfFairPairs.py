class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        nums.sort()

        def lower_bound(l, r, target):
            ans = r + 1
            while l <= r:
                mid = (l + r) // 2
                
                if nums[mid] >= target:
                    ans = mid
                    r = mid - 1
                else:
                    l = mid + 1
            return ans

        def upper_bound(l, r, target):
            ans = r + 1
            while l <= r:
                mid = (l + r) // 2

                if nums[mid] > target:
                    ans = mid
                    r = mid - 1
                else:
                    l = mid + 1
            return ans

        n = len(nums)
        res = 0
        for i in range(n):
            low = lower - nums[i]
            high = upper - nums[i]

            #find the lower bound and upper bound
            lb = lower_bound(i + 1, n - 1, low)
            ub = upper_bound(i + 1, n - 1, high)

            res += (ub - lb)
        
        return res
