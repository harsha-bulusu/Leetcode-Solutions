class Solution {

    public boolean isValid(String s) {
        List<Character> chars = new ArrayList<>();
        int i = 0;
        while (i != s.length()) {
            char ch = s.charAt(i);
            int top_index = chars.size() - 1;
            char top = chars.size() > 0 ? chars.get(top_index) : ' ';
             if (ch == '(' || ch == '{' || ch == '[') {
                chars.add(ch);
             } else if(chars.size() == 0) {
                 return false;
             } else if (ch == ')' && top == '(') {
                 char removedChar = chars.remove(top_index);
             } else if(ch == '}' && top == '{') {
                 char removedChar = chars.remove(top_index);
             } else if (ch == ']' && top == '[') {
                 char removedChar = chars.remove(top_index);
             } else {
                 chars.add(ch);
             }
             i++;
        }

        return chars.isEmpty();
        
        
    }
}
