class Solution {
    public long minimumSteps(String s) {
        // char arr[] = s.toCharArray();
        // long swaps = 0;
        // for (int i = 0; i < arr.length; i++) {
        //     char ch = arr[i];
        //     int currIndex = i;
        //     if (ch == '0') {
        //         while (currIndex != 0 && arr[currIndex - 1] == '1') {
        //             // swap 0 and 1
        //             char temp = arr[currIndex - 1];
        //             arr[currIndex - 1] = arr[currIndex];
        //             arr[currIndex] = temp;
        //             swaps++;
        //             currIndex--;
        //         }
        //     }
        // }

        // return swaps;

        /* Optimal Solution: Using two pointers, finding case where l == 1 and r == 0 */

        long swaps = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '0') {
                swaps += r - l;
                l += 1;
            }
        }   

        return swaps;
    }
}
