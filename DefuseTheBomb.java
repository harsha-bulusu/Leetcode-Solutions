class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) return new int[n]; 

        int[] res = new int[n];
        // k > 0
        if (k > 0) {
            int sum = 0;
            int l = 1, r = k;
            for (int i = l; i <= r; i++) {
                sum += code[i];
            }
            res[0] = sum;
            for (int i = 1; i < n; i++) {
                sum -= code[l];
                l = (l + 1) % n;
                r = (r + 1) % n;
                sum += code[r];
                res[i] = sum;
            }
        }

        // k < 0
        if (k < 0) {
            int sum = 0;
            int l = n - 1, r = n + k;
            for (int i = l; i >= r; i--) {
                sum += code[i];
            }
            res[0] = sum;
            for (int i = 1; i < n; i++) {
                sum -= code[r];
                l = (l + 1) % n;
                r = (r + 1) % n;
                sum += code[l];
                res[i] = sum;
            }
        }

        return res;
    }
}
