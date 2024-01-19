class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        // Hashing the alphabet
        for (int i = 0; i < s1.length(); i++) {
            int index1 = s1.charAt(i) - 'a';
            int index2 = s2.charAt(i) - 'a';
            arr1[index1]++;
            arr2[index2]++;
        }
        
        int diff = 0;
        // if both strings have different alphabets return false
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        // if it takes more than one swap return false i.e., character difference  more than 2
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
            if (diff > 2) return false;
        }
        return true;
    }
}
