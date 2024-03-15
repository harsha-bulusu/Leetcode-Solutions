class Solution {

    /**
      void permute(int index, StringBuilder s, Set<String> res) {
        // if (index == s.length()) {
        //     res.add(s.toString());
        // }   
        
        for (int j = index; j < s.length(); j++) {
            Character ch = s.charAt(j);
            if (Character.isDigit(ch)) continue;

            s.setCharAt(j, Character.toLowerCase(ch));
            permute(index + 1, s, res);
            s.setCharAt(j, Character.toUpperCase(ch));
            permute(index + 1, s, res);
        }

        res.add(s.toString());
    }

    public List<String> letterCasePermutation(String s) {
        Set<String> res = new HashSet<>();
        permute(0, new StringBuilder(s), res);
        return res.stream().collect(Collectors.toList());
    } */

    public void addToRes(List<String> res, int index, char ch) {
        ch = Character.toUpperCase(ch);
        
        int n = res.size();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(res.get(i));
            sb.setCharAt(index, ch);
            res.add(sb.toString());
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();

        res.add(s.toLowerCase());

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                continue;
            }
            addToRes(res, i, ch);
        }
        return res;
    }
}
