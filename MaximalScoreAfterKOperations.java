class Solution {

    private static void reverse(int[] arr) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
            l++;
            h--;
        }
    }

    public long maxKelements(int[] nums, int k) {
        // long score = 0;
        // while (k != 0) {
        //     int max = 0;
        //     int idx = -1;
        //     for (int i = 0; i < nums.length; i++) {
        //         if (nums[i] > max) {
        //             max = nums[i];
        //             idx = i;
        //         }
        //     }
        //     score += nums[idx];
        //     nums[idx] = (int)Math.ceil((double)nums[idx] / 3);
        //     k--;
        // }
        // return score;

        // TC: k * n

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        maxHeap.addAll(list);

        long score = 0;
        for (int i = 0; i < k; i++) {
            int ele = maxHeap.poll();
            score += ele;
            ele = (int)Math.ceil(ele / 3.0);
            maxHeap.add(ele);
        }

        return score;
        //TC: O(n) + O(k * log N)
    }
}
