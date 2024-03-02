class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int e1= Integer.MIN_VALUE, e2 = Integer.MIN_VALUE, cnt1 = 0, cnt2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && nums[i] != e2) {
                e1 = nums[i];
                cnt1++;
            } else if (cnt2 == 0 && nums[i] != e1) {
                e2 = nums[i];
                cnt2++;
            } else if (nums[i] == e1) cnt1++;
            else if (nums[i] == e2) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        int majority = (int)(n / 3) + 1;

        // manual check
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == e1) cnt1++;
            if (num == e2) cnt2++;
        }

        if (cnt1 >= majority) res.add(e1);
        if (cnt2 >= majority) res.add(e2);

        return res;
    }
}
