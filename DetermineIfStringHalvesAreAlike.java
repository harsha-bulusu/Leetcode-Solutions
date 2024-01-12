class Solution {

    int countVowels(String s, Map<Character, Integer> vowels) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowels.containsKey(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        Map<Character, Integer> vowels = new HashMap<>();
        vowels.put('a', 1);
        vowels.put('e', 1);
        vowels.put('i', 1);
        vowels.put('o', 1);
        vowels.put('u', 1);
        int length = s.length() / 2;
        String s1 = s.substring(0, length);
        String s2 = s.substring(length);
        int s1Vowels = countVowels(s1, vowels);
        int s2Vowels = countVowels(s2, vowels);
        return s1Vowels == s2Vowels;
    }
}
