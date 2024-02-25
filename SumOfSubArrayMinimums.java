class Pair {
    int ele;
    int cnt;

    public Pair(int ele, int cnt) {
        this.ele = ele;
        this.cnt = cnt;
    }
}

class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int n = arr.length;
        
        // for (int i = 0; i < n - 1; i++) {
        //     for (int j = i; j < n; j++) {
        //         int min = Integer.MAX_VALUE;
        //         for (int k = i; k <=j; k++) {
        //             min = Math.min(min, arr[k]);
        //         }
        //         sum += min;
        //         sum %= (int)1e9 + 7;
        //     }
        // }
        // sum += arr[n - 1];
        
        // for (int i = 0; i < n; i++) {
        //     int min = Integer.MAX_VALUE;
        //     for (int j = i; j < n; j++) {
        //         min = Math.min(min, arr[j]);

        //         sum += min;
        //         sum %= (int)1e9 + 7;
        //     }
        // }

        Stack<Pair> stack = new Stack<>();
        int left[] = new int[n];
        int right[] = new int[n];
        // left and right indicates how many times you can contribute to your left sub array and how many times you can contribute to your right sub array
        // you can be a contributor to all the max ele in the seq (left/right)

        // counting left contributions for every element
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            while (!stack.isEmpty() && stack.peek().ele > arr[i]) {
                cnt += stack.pop().cnt;
            }
            stack.push(new Pair(arr[i], cnt));
            left[i] = cnt;
        }
        stack.clear();

        // counting right contributions for every element
        for (int j = n - 1; j >= 0; j--) {
            int cnt = 1;
            while (!stack.isEmpty() && stack.peek().ele >= arr[j]) {
                cnt += stack.pop().cnt;
            }
            stack.push(new Pair(arr[j], cnt));
            right[j] = cnt;
        }

        // find sum : arr[i] * contributions (left[i] * right[i])
        int mod = (int)1e9 + 7;
        for (int i = 0; i < n; i++) {
            sum += arr[i] * (long)(left[i]* right[i]);
            sum %= mod;
        }
        return (int)sum;
    }
}
