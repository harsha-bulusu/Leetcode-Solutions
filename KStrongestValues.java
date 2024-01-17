class Solution {

    public int[] getStrongest(int[] arr, int k) {
        int res[] = new int[k];
        Arrays.sort(arr);
        int n = arr.length;
        int cursor = 0, i = 0, j = n - 1;
        int m = arr[(n - 1) / 2];
        while (cursor < k) {
            System.out.println(i + " " + j);
            if (Math.abs(arr[i] - m) >  Math.abs(arr[j] - m)) {
                res[cursor] = arr[i];
                i++;
            }
            else if (Math.abs(arr[i] - m) < Math.abs(arr[j] - m)) {
                res[cursor] = arr[j];
                j--;
            }
            else { // absolute difference of I and J are same
                if (arr[i] > arr[j]) {
                    res[cursor] = arr[i];
                    i++;
                }
                else {
                    res[cursor] = arr[j];
                    j--;
                }
            }
            cursor++;
        }
        return res;
    }
}
