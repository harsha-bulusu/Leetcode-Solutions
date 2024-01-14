class Solution {
    public int sumOfMultiples(int n) {
        boolean[] arr = new boolean[n + 1];
        for (int i = 3; i <= n; i += 3) arr[i] = true;
        for (int i = 5; i <= n; i += 5) arr[i] = true;
        for (int i = 7; i <= n; i += 7) arr[i] = true;

        int res = 0;
        for (int i = 3; i <= n; i++) {
            if (arr[i]) res += i;
        }
        return res;
    }
}
