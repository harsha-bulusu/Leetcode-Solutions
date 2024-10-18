class Solution {

    void generateSubsets(int index, int[] arr, List<Integer> ele, int[] max) {
        if (index == arr.length) {
            // calculate maxsubset
            int res = 0;
            for (Integer i : ele) res |= i;
            if (res > max[0]) {
                max[0] = res;
                max[1] = 1;
            } else if (res == max[0]) {
                max[1]++;
            }
            return;
        }
        
        // take
        ele.add(arr[index]);
        generateSubsets(index + 1, arr, ele, max);
        // drop
        ele.remove(ele.size() - 1);
        generateSubsets(index + 1, arr, ele, max);
    }

    public int countMaxOrSubsets(int[] nums) {
        int[] max = {0, 0};
        generateSubsets(0, nums, new ArrayList<>(), max);
        return max[1];
    }
}
