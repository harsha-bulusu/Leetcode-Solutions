class Solution {
    public boolean isHappy(int n) {
        while (n > 1) {
            if (n == 4) return false; // moves to an endless loop if n == 4
            // square every digit of n and sum it
            int temp = n;
            int sum = 0;
            while (temp > 0) {
                int digit = temp % 10;
                temp = temp / 10;
                sum += digit * digit;
            } 
            // end of finding sum of squares of all digits of a given number
            n = sum;
        }

        return true;
    }
}
