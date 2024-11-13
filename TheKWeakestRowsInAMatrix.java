class Pair:

    def __init__(self, cnt, idx):
        self.cnt = cnt
        self.idx = idx

    def __lt__(self, other):
        if (self.cnt == other.cnt):
            return self.idx < other.idx
        return self.cnt < other.cnt

class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        # rows_strength = []

        # for i in range(len(mat)):
        #     cnt = 0
        #     for j in range(len(mat[i])):
        #         if mat[i][j] == 1:
        #             cnt += 1
        #     rows_strength.append([cnt, i])

        # rows_strength.sort()
        
        # res = []
        # for i in range(k):
        #     res.append(rows_strength[i][1])
        
        # return res
        # TC: O(m * n * m log m)

        # Binary search + heap

        def binary_search(row):
            l = 0
            r = len(row)

            while l < r:
                mid = l +  (r - l) // 2
                if row[mid] == 1:
                    l = mid + 1
                else:
                    r = mid
            
            return l

        min_heap = []

        for i in range(len(mat)):
            cnt  = binary_search(mat[i])
            heapq.heappush(min_heap, Pair(cnt, i))
        
        res = []
        for i in range(k):
            pop = heapq.heappop(min_heap)
            print(pop.cnt, pop.idx)
            res.append(pop.idx)
        
        return res
