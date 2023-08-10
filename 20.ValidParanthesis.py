class Solution:
    def isValid(self, s: str) -> bool:
        chars = []
        i = 0
        while i != len(s):
            top_index = len(chars) - 1
            top = chars[top_index] if len(chars) > 0 else ' '
            ch = s[i]
            if ch == '(' or ch == '{' or ch == '[':
                chars.append(s[i])
            elif len(chars) == 0:
                return False
            elif ch == ')' and top == '(':
                chars.pop()
            elif ch == '}' and top == '{':
                chars.pop()
            elif ch == ']' and top == '[':
                chars.pop()
            else:
                chars.append(ch)
            i+=1
        print(chars)
        return True if len(chars) == 0 else False
