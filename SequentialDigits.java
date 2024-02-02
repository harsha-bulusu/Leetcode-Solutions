class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int lowDigit  = String.valueOf(low).length();
        int highDigit = String.valueOf(high).length();
        List<Integer> list = new ArrayList<>();

        // for (int i = lowDigit; i <= highDigit; i++) {
        //     for (int start = 1; start <= 9; start++) {
        //         if (start + i > 10) break;
        //         int num = start;
        //         int prev = start;

        //         for (int j = 0; j < i - 1; j++) {
        //             num *= 10;
        //             prev += 1;
        //             num += prev;
        //         }

        //         if (low <= num && num <= high) {
        //             list.add(num);
        //         }
        //     }
        // }

        //Sliding window - Approach 2
        // int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // for (int i = lowDigit; i <= highDigit; i++) { // i determines window size
        //     for (int j = 1; j <= 9; j++) { // starting value of a digit
        //         if (j + i > 10) break; // if sequence is having a value > 9 
        //         int val = 0;
        //         for (int k = j; k < j + i; k++) {
        //             val *= 10;
        //             val += nums[k - 1];
        //         }
        //         if (low <= val && val <= high)
        //             list.add(val);
        //     }
        // }

        // Approach - 3 Using Queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 9; i++) queue.add(i);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (low <= num && num <= high) list.add(num);
            // transformations for next possibility
            int lastDigit = num % 10;
            if (lastDigit < 9) { // if last digit is 9 that will be the end of sequence
                lastDigit += 1;
                num *= 10;
                num += lastDigit; // transformed number EG: 123 -> 1234
                if (num <= high) queue.add(num);
            }
        }

        return list;
    }
}
