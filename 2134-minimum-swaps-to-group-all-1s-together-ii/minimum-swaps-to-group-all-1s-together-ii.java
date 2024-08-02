class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int o = 0;

        // Count the number of 1s in the array
        for (int num : nums) {
            o += num;
        }

        // If there are no 1s, no swaps are needed
        if (o == 0) {
            return 0;
        }

        // Calculate the sum of the first 'o' elements
        int currentSum = 0;
        for (int i = 0; i < o; i++) {
            currentSum += nums[i];
        }

        int minSwaps = o - currentSum;

        // Sliding window to find the minimum swaps
        for (int i = 1; i < n; i++) {
            currentSum = currentSum - nums[i - 1] + nums[(i + o - 1) % n];
            minSwaps = Math.min(minSwaps, o - currentSum);
        }

        return minSwaps;
    }
}
