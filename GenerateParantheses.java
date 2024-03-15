class Solution {

    void permute(int op, int cp, StringBuilder parantheses, List<String> res, int n) {
        if (op == n && cp == n) {
            res.add(parantheses.toString());
        }

        if (op < n) {
            parantheses.append('(');
            permute(op + 1, cp, parantheses, res, n);
            parantheses.deleteCharAt(parantheses.length() - 1);

        }
        
        if (cp < op) {
            parantheses.append(')');
            permute(op, cp + 1, parantheses, res, n);
            parantheses.deleteCharAt(parantheses.length() - 1);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        permute(0, 0, new StringBuilder(), res, n);
        return res;
    }
}
