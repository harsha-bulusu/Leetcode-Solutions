class Solution:
    def isPalindrome(self, s: str) -> bool:
        c1 = 0
        c2 = len(s) - 1

        while c1 < c2:
            ch1 = s[c1].lower()
            ch2 = s[c2].lower()
            if not ch1.isdigit() and not ch1.isalpha():
                c1+=1
                continue
            if not ch2.isdigit() and not ch2.isalpha():
                c2-=1
                continue

            if ch1 != ch2:
                return False

            c1+=1
            c2-=1
          
        return True
