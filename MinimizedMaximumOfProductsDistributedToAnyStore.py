class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:
        max_qty = 0
        for qty in quantities:
            max_qty = max(qty, max_qty)

        low, high = 1, max_qty

        res = 0
        while low <= high:
            k = low + (high - low) // 2

            stores = 0
            for qty in quantities:
                stores += math.ceil(qty / k)
            
            if stores > n:
                low = k + 1
            else:
                res = k
                high = k - 1
        
        return res
