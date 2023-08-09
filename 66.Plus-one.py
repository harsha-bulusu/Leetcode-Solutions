class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        val = ''
        for digit in digits:
            val += str(digit)
        val = list(str(int(val) + 1))
        return [int(digit) for digit in val]
