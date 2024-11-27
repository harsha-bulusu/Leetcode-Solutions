class Solution {

    // class Triplet {
    //     int nr;
    //     int dr;
    //     double fraction;

    //     Triplet(int nr, int dr) {
    //         this.nr = nr;
    //         this.dr = dr;
    //         this.fraction = (double) nr / (double) dr;
    //     }

    // }

    class Triplet {
        int l;
        int r;
        double fraction;

        Triplet(int l, int r, double fraction) {
            this.l = l;
            this.r = r;
            this.fraction = fraction;
        }

    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;

        // O(N ^ 2 * log N)
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>((t1, t2) -> Double.compare(t1.fraction, t2.fraction));
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         int nr = arr[i];
        //         int dr = arr[j];
        //         minHeap.add(new Triplet(nr, dr));
        //     }
        // }

        // // O(k * log N)
        // for (int i = 1; i < k; i++) {
        //     minHeap.poll();
        // }  

        /**The Elements are in sorted order, Make advantage */
        // O(n * log K)
        for (int l = 0; l < n - 1; l++) {
            minHeap.add(new Triplet(l, n - 1, (double) arr[l] / (double) arr[n - 1]));
        }

        // O(k * log K)
        for (int i = 0; i < k - 1; i++) {
            Triplet triplet = minHeap.poll();
            int l = triplet.l;
            int r = triplet.r;
            minHeap.add(new Triplet(l, r - 1, (double) arr[l] / (double) arr[r - 1]));
        }

        // Total TC: O(n + k) * log K

        Triplet triplet = minHeap.poll();
        return new int[] {arr[triplet.l], arr[triplet.r]};
    }
}
