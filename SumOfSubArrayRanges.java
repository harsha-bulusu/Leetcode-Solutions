class Pair {
    int ele;
    long cnt;

    public Pair(int ele, long cnt) {
        this.ele = ele;
        this.cnt = cnt;
    }
}
class Solution {
    public long subArrayRanges(int[] nums) {
        return (sumOfSubArrayMax(nums) - sumOfSubArrayMin(nums));
    }

    long sumOfSubArrayMax(int[] nums) {
        int n = nums.length;
        long[] left = new long[n];
        long[] right = new long[n];
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            long cnt = 1;
            while (!stack.isEmpty() && stack.peek().ele < nums[i]) {
                cnt += stack.pop().cnt;
            }
            stack.push(new Pair(nums[i], cnt));
            left[i] = cnt;
        }

        stack.clear();

        for (int j = n - 1; j >= 0; j--) {
            long cnt = 1;
            while (!stack.isEmpty() && stack.peek().ele <= nums[j]) {
                cnt += stack.pop().cnt;
            }
            stack.push(new Pair(nums[j], cnt));
            right[j] = cnt;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] * (long)(left[i] * right[i]);
        }
        return sum;
    }

    long sumOfSubArrayMin(int[] nums) {
        int n = nums.length;
        long left[] = new long[n];
        long right[] = new long[n];
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            long cnt = 1;
            while(!stack.isEmpty() && stack.peek().ele > nums[i]) {
                cnt += stack.pop().cnt;
            }
            stack.push(new Pair(nums[i], cnt));
            left[i] = cnt;
        }
        stack.clear();

        for (int j = n - 1; j >= 0; j--) {
            long cnt = 1;
            while (!stack.isEmpty() && stack.peek().ele >= nums[j]) {
                cnt += stack.pop().cnt;
            }
            stack.push(new Pair(nums[j], cnt));
            right[j] = cnt;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] * (long)(left[i] * right[i]);
        }

        return sum;

        
    }
}
