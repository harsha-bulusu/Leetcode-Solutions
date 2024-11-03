class Solution {
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        char startChar = goal.charAt(0);
        int n = s.length();

        // indices to start searching
        List<Integer> startPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (startChar == s.charAt(i)) {
                startPoints.add(i);
            }   
        }

        for (Integer startPoint : startPoints) {
            boolean match = true;
            for (int i = 0; i < n; i++) {
                if (s.charAt((i + startPoint) % n) != goal.charAt(i)) {
                    match = false;
                    break;
                }
            }

            if (match == true) return true;
        }

        return false;
    }
}
