class Solution {
    public int singleNumber(int[] nums) {
        // Brute force : Linear search and count occurrances 
        // Better : Hashing and checking for non-duplicate element

        //Optimal : Using XOR operation

        int val = 0;
        for (int num : nums) {
            val ^= num;
        }   
        return val;
    }
}
