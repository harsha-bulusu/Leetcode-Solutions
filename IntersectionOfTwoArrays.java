import java.util.Map.Entry;

class Solution {

    private void findFreqAndIntersect(int[] arr, int[] intersection) {
        int[] freq = new int[1001];
        for (int num : arr) {
            freq[num]++;
        }
        for (int i = 0; i < 1001; i++) {
            intersection[i] = Math.min(freq[i], intersection[i]);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] intersection = new int[1001];
        Arrays.fill(intersection, Integer.MAX_VALUE);
        findFreqAndIntersect(nums1, intersection);
        findFreqAndIntersect(nums2, intersection);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            while(intersection[i]-- != 0) {
                list.add(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
