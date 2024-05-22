class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> symbols = new HashMap<>();
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int value = symbols.get(ch);
            if (i != s.length() - 1 && value < symbols.get(s.charAt(i + 1))) {
                sum -= value;
            }  else {
                sum += value;
            }
        }

        return sum;
    }
}
