class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int n = res.length();
            if (res.length() >= 2 && res.charAt(n - 1) == ch && res.charAt(n - 2) == ch) continue;
            res.append(ch);
        }   

        return res.toString();
    }
}
