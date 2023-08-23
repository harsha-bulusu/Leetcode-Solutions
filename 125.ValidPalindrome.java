class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int c1 = 0;
        int c2 = s.length() - 1;

        while(c1 < c2) {
            char ch1 = s.charAt(c1);
            char ch2 = s.charAt(c2);

            if(!Character.isLetter(ch1) && !Character.isDigit(ch1)) {
                c1++;
                continue;
            } 

            if(!Character.isLetter(ch2) && !Character.isDigit(ch2)) {
                c2--;
                continue;
            }

            if(ch1 != ch2) {
                return false;
            }
            c1++;
            c2--;
        }

        return true;
    }
}
