class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        #trimming string
        index = len(s) - 1
        while s[index] == " ":
            s = s[:len(s) - 1]
            index = len(s) - 1

        size = 0
        for i in range(0, len(s)):
            if s[i] == " ":
                size = 0
            else:
                size += 1
        return size
