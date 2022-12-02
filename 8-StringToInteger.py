class Solution:
    def myAtoi(self, s: str) -> int:
        #trim whitespaces
        string = s.strip()
        if len(string) == 0:
            return 0
        res = ''

        def convert(string, res):
            for char in string:
                if not char.isdigit():
                    break
                res+=char
            return res
     
        if string[0] == '+' or string[0].isdigit():
            if string[0] == '+':
                res = convert(string[1:], res)
            else:
                res = convert(string, res)
        if string[0] == '-':
            res = convert(string[1:], res)
            if res != '':
                res = '-'+res

        if(len(res) == 0):
            return 0
        res = int(res)
        upper_limit = int(math.pow(2,31))
        lower_limit = -upper_limit
        if res <  lower_limit:  
            return lower_limit
        if res > upper_limit - 1:
            return upper_limit-1
        return res
