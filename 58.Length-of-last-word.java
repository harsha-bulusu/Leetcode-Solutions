class Solution {
    public int lengthOfLastWord(String s) {
        //trimming rear
        int endIndex = s.length();
        while(s.charAt(endIndex - 1) == ' '){
            endIndex -= 1;
        }

        int size =0;
        for(int i=0; i<endIndex; i++){
            if (s.charAt(i) == ' '){
                size = 0;
            } else {
                size+=1;
            }
        }
        return size;
    }
}
