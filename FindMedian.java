class MedianFinder {

    PriorityQueue<Integer> smallNumbers;
    PriorityQueue<Integer> largeNumbers;

    public MedianFinder() {
        smallNumbers = new PriorityQueue<>((n1, n2) -> n2 - n1);
        largeNumbers = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallNumbers.add(num);

        // check for value difference
        if (smallNumbers.size() > 0 && largeNumbers.size() > 0) {
            if (smallNumbers.peek() > largeNumbers.peek()) {
                largeNumbers.add(smallNumbers.poll());
            }
        }

        if (smallNumbers.size() > (largeNumbers.size() + 1)) {
            largeNumbers.add(smallNumbers.poll());
        } else if (largeNumbers.size() > (smallNumbers.size() + 1)){
            smallNumbers.add(largeNumbers.poll());
        }
        
    }
    
    public double findMedian() {
        if ((smallNumbers.size() + largeNumbers.size()) % 2 == 0) {
            return (double)(smallNumbers.peek() + largeNumbers.peek()) / 2;
        }
        //odd
        if (smallNumbers.size() > largeNumbers.size()) return smallNumbers.peek();
        return largeNumbers.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
