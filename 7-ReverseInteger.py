class Solution:
    def reverse(self, x: int) -> int:
        val = str(x)
        rev_val = int(val[-1::-1]) if val[0] != '-' else int('-'+val[-1::-1][0:len(val)-1])
        upperLimit = int(math.pow(2,31))-1
        lowerLimit = int('-'+str(upperLimit))
        if len(val) == 1:
            return x
        if rev_val <lowerLimit or rev_val > upperLimit:
            return 0 
        return rev_val
