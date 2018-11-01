class MovingAverage {

    private int[] window;
    private int runningSum;
    private int curr;
    private int count;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        runningSum = 0;
        curr = 0;
        count = 0;
    }

    public double next(int val) {
        curr = (curr + window.length) % window.length;  // Wrap around if necessary
        runningSum -= window[curr];                     // Remove the old entry
        window[curr] = val;                             // Replace the old entry
        runningSum += val;                              // Update the running sum
        count = Math.min(count + 1, window.length);     // Update the count
        curr++;                                         // Advance to the next position
        return (double) runningSum / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
