class Solution:
    def convertBinaryToDecimal(self, num):
        num = num[::-1]
        pow = 0
        val = 0
        for i in range(0, len(num)):
            val += int(num[i])*(2**pow)
            pow += 1
        return val
    def convertDecimalToBinary(self, num):
        res = ""
        while True:
            quo = num // 2
            rem = num % 2
            num = num // 2
            res += str(rem)
            if num < 2:
                res += str(quo)
                break
        return str(int(res[::-1]))

    def addBinary(self, a: str, b: str) -> str:
        a_decimal = self.convertBinaryToDecimal(a)
        b_decimal = self.convertBinaryToDecimal(b)
        sum = a_decimal + b_decimal
        return self.convertDecimalToBinary(sum)
