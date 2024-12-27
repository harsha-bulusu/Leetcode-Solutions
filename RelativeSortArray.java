class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int hash[] = new int[1001];

        for (int i : arr1) {
            hash[i]++;
        }

        int index = 0;
        for (int i : arr2) {
            while(hash[i]-- > 0) {
                arr1[index++] = i;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while(hash[i]-- > 0) {
                arr1[index++] = i;
            }
        }

        return arr1;
    }
}
