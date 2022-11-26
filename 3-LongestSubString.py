$Longest Substring Without Repeating Characters
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        count = 0
        counts = []
        chars = []
        count_appened = False
        for char in s:
            if char not in chars:
                count+=1
                chars.append(char)
                count_appened = False
            else:
                counts.append(count)
                if chars[len(chars) - 1] == char:
                    count=1
                    chars.clear()
                else:
                    index = chars.index(char)
                    chars = chars[index+1:]
                    count = len(chars)+1
                chars.append(char)
        if not count_appened:
            counts.append(count)
        return max(counts)
                
