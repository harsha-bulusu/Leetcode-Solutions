import java.util.Map.*;

class Solution {
    public int majorityElement(int[] nums) {
        /**
            Moores voting Algorithm
            
            step-1: Load element if count is 0
            step-2: Visit next element and increment count if current element equals loaded element else decrement count
            step-3: Repeat step-1 and step-2 until the entire array is traversed
            step-4: The loaded element will be majority element
         */

        int count = 0, ele = 0;
        for (int i=0; i<nums.length; i++) {
            if (count == 0) {
                ele = nums[i];
            }

            if (ele == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return ele;
    }
}
