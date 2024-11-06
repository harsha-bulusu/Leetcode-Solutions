class Solution {

    private int countBits(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) count++;
            num >>= 1;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
        // Map<Integer, List<Integer>> map = new TreeMap<>();
        // int n = arr.length;

        // for (int i = 0; i < n; i++) {
        //     int cnt = countBits(arr[i]);
        //     List<Integer> list = map.getOrDefault(cnt, new ArrayList());
        //     list.add(arr[i]);
        //     map.put(cnt, list);
        // }

        // int index = 0;
        // for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        //     Collections.sort(entry.getValue());
		//     for (Integer i : entry.getValue()) {
        //         arr[index] = i;
        //         index++;
        //     }
		// }

        int n = arr.length;
        int [][]count = new int[n][2]; // row for every number -> {num, cnt}
        for (int i = 0; i < n; i++) {
            count[i] = new int[]{arr[i], countBits(arr[i])};
        }

        // Custom comparator to compare bits and compare values if bits are equal
        Arrays.sort(count, (r1, r2) -> r1[1] == r2[1] ? r1[0] - r2[0] : r1[1] - r2[1]);
        
        for (int i = 0; i < n; i++) {
            arr[i] = count[i][0];
        }
        return arr;
    }
}
