class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> larger = new ArrayList<>();

        int[] res = new int[nums.length];
        int idx = 0;
        int pivotCount = 0;
        for (int num : nums) {
            if (num == pivot) pivotCount++;
            else if (num < pivot) res[idx++] = num;
            else larger.add(num);
        }

        while (pivotCount-- != 0) {
            res[idx++] = pivot;
        }

        for (int ele : larger) {
            res[idx++] = ele;
        }

        return res;
    }
}
