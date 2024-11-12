class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        # answers: List[int] = []
        # for query in queries:
        #     res = 0
        #     for item in items:
        #         if item[0] <= query:
        #             res = max(res, item[1])
        #     answers.append(res)

        # return answers
        # TC: O(M * N) --> TLE

        items = sorted(items)
        queries_sorted = []
        for i in range(len(queries)):
            queries_sorted.append([queries[i], i])
        queries_sorted = sorted(queries_sorted)

        answers = [0] * len(queries)
        max_beauty = 0
        j = 0
        for query, index in queries_sorted:
            while j < len(items) and items[j][0] <= query:
                max_beauty = max(max_beauty, items[j][1])
                j += 1

            answers[index] = max_beauty
        
        return answers
        # TC: O(n log n) + O(m log m) + O(m + n)
