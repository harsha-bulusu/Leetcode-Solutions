class Solution {

    List<Integer> generateNthRow(int n) {
        int res = 1;
        List<Integer> nthRowElements = new ArrayList<>();
        nthRowElements.add(1);

        for (int i=1; i<n; i++) {
            res *= (n-i);
            res /= i;
            nthRowElements.add(res);
        }
        return nthRowElements;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i=1; i <= numRows; i++) {
            pascalTriangle.add(generateNthRow(i));
        }

        return pascalTriangle;
    }
}
