class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        indexes = []
        for i in range(len(haystack)):
            if haystack[i] == needle[0]:
                indexes.append(i)
        if len(indexes) == 0 or (len(haystack) < len(needle)):
            return -1

        h_cursor = indexes[0]
        n_cursor = 0
        i_cursor = 0
        while n_cursor < len(needle):           
            if h_cursor < len(haystack) and haystack[h_cursor] == needle[n_cursor]:
                h_cursor+=1
                n_cursor+=1
            else:
                i_cursor+=1
                if i_cursor >= len(indexes):
                    break
                h_cursor=indexes[i_cursor]
                n_cursor=0
        return (h_cursor - n_cursor) if n_cursor == len(needle) else -1
