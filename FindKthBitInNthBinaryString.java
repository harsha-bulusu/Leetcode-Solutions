class Solution {
    private String invertAndReverse(String string) {
        char[] chars = string.toCharArray();
        int low = 0;
        int high = chars.length - 1;
        while (low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;

            low++;
            high--;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') chars[i] = '1';
            else chars[i] = '0';
        }

        return new String(chars);
    }

    /**
        * If we observe the pattern
        * 1. The first position is always zero, the last and mid positions is always 1
        * 2. We try solving the problem by correlating the positions with previous steps
     */
    char helper(int n, int k) {
        if (n == 1) return '0';

        int range = (int)Math.pow(2, n) - 1;
        int mid = (int)Math.pow(2, n) / 2;
        if (k == mid) return '1';
        else if (k < mid) return helper(n - 1, k);
        else {
            int invIndex = 1 + (range - k);
            return helper(n - 1, invIndex) == '0' ? '1' : '0';
        }
    }

    public char findKthBit(int n, int k) {
        // List<String> strings = new ArrayList<>();
        // strings.add("0");

        // for (int i = 1; i < n; i++) {
        //     String prev = strings.get(i - 1);
        //     String sn = prev;
        //     sn += "1";
        //     sn += invertAndReverse(prev);
        //     strings.add(sn);
        // }

        // return strings.get(n - 1).charAt(k - 1);
        return helper(n, k);
    }
}
