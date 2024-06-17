class Solution {

    static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    


    void backtrack(int index, String str, List<String> res, String digits) {
        //Base condition
        if (str.length() == digits.length()) {
            res.add(str);
            return;
        }

        char digit = digits.charAt(index);
        for (char letter : map.get(digit).toCharArray()) {
            backtrack(index + 1, str + letter, res, digits);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() != 0)
            backtrack(0, "", res, digits);
        return res;
    }
}
