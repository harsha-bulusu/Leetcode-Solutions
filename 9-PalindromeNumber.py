class Solution:
    def isPalindrome(self, x: int) -> bool:
        number = str(x)
        if len(number) == 1:
            return True
        if number[0] == '-':
            return False
        if number == number[-1::-1]:
            return True
