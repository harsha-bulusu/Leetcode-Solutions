class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res=''
        word_cursor=0
        char_cursor=0
        comp_prefix=None
        newLap=False
        end_word_index=len(strs)-1

        def hasNext():
            if char_cursor < len(strs[word_cursor]):
                return True
            return False

        if hasNext():
            comp_prefix=strs[word_cursor][char_cursor]    
        
        while True:
            if word_cursor > end_word_index:
                word_cursor=0
                char_cursor+=1
                res+=comp_prefix
                newLap=True
            if newLap and hasNext():
                comp_prefix=strs[word_cursor][char_cursor]
                newLap=False
            if hasNext() and comp_prefix==strs[word_cursor][char_cursor]:
                word_cursor+=1
            else:
                break
        return res
