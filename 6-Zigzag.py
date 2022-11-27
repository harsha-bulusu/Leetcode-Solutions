class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        output_rows = []
        for row in range(numRows):
            output_rows.append([])
        cursor=0
        cursor_forward=True
        for char in s:
            if cursor_forward and cursor<numRows-1:
                output_rows[cursor].append(char)
                cursor+=1
            elif cursor_forward and cursor == numRows-1:
                output_rows[cursor].append(char)
                cursor-=1
                cursor_forward=False
            elif not cursor_forward and cursor > 0:
                output_rows[cursor].append(char)
                cursor-=1
            elif not cursor_forward and cursor == 0:
                output_rows[cursor].append(char)
                cursor+=1
                cursor_forward=True

        res_string=''
        for row in output_rows:
            for char in row:
                res_string+=char
        return res_string

