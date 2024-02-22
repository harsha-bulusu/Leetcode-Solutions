class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m];
        Map<Integer, Integer> refMap = new HashMap<>(); // <num, nge> 

        // Declare a stack and maintain decreasing order in it - Monotonic stack
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(nums2[i]);
                refMap.put(nums2[i], -1);
            } else {
                while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    refMap.put(nums2[i], -1);
                } else {    
                    refMap.put(nums2[i], stack.peek());
                }
                stack.push(nums2[i]);
            }
        }


        for (int i = 0; i < m; i++) {
            res[i] = refMap.get(nums1[i]);
        }

        return res;
        
    }
}
