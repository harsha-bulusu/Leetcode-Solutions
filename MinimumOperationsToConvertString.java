class Solution {
    public int minimumMoves(String s) {
        System.out.println(s);
        int c1 = 0, c2 = 0;
        int n = s.length();
        int operations = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < n; i = endIndex) {
            startIndex = i;
            while (startIndex < n && s.charAt(startIndex) == 'O') startIndex++;
            endIndex = startIndex + 3;
            int count  = 0;
            System.out.println(startIndex + " " + endIndex);
            for (int j = startIndex; j < endIndex; j++) {
                if (j >= n) break;
                if (s.charAt(j) == 'X') count++;
            }
            if (count > 0) operations++;
        }
        return operations;
    }
}
