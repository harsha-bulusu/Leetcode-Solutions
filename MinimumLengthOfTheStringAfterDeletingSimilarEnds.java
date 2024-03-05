class Solution {
    public int minimumLength(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 < p2) {
            if (s.charAt(p1) == s.charAt(p2)) {
                char target = s.charAt(p1);

                while (p1 < p2 && s.charAt(p1) == target) {
                    p1++;
                }

                while (p1 <= p2 && s.charAt(p2) == target) {
                    p2--;
                } 
            } else {
                break;
            }       
        }
        

        if (p1 > p2) return 0;
        return p2 - p1 + 1;
    }
}
