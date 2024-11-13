class Solution:

    def integerReplacement(self, n: int) -> int:
        dp = {}
        def helper(n):
            if n == 1:
                return 0
            
            res = dp.get(n, None)
            if res is not None:
                return res
            
            if n % 2 == 0:
                dp[n] = 1 + self.integerReplacement(n // 2)
            else:
                dp[n] = 1 + min(self.integerReplacement(n + 1), self.integerReplacement(n - 1))
        
            return dp[n]
        return helper(n)
