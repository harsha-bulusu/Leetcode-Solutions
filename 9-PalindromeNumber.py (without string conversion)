class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        number = x
        multiplier = 1
        res = 0
        while number != 0:
            digit = number%10
            res*= multiplier
            res+= digit
            number//=10
            multiplier=10

        if res == x:
            print(res)
            return True
        return False
        
