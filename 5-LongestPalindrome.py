class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s)==1:
            return s
        selected_index = 0
        comparision_index = 1
        length = len(s)
        palindromes = {}
        while selected_index<length-1:
            if comparision_index < length:
                if s[selected_index] == s[comparision_index]:
                    expected_palindrome = s[selected_index:comparision_index+1]
                    if expected_palindrome == expected_palindrome[-1::-1]:
                        palindromes[len(expected_palindrome)]=expected_palindrome
                comparision_index+=1
            else:
                selected_index+=1
                comparision_index=selected_index+1
        lengths = list(palindromes.keys())
        if len(lengths) == 0:
            return s[0]
        return palindromes[max(lengths)]
