class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0 or x == 1:
            return x
        n = 1
        prev_n = -1
        while prev_n != n:
            prev_n = n
            n = 0.5 * (n + (x / n))
        return int(n)
