class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int[] dp = new int[k];
        dp[0] = 1;

        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = ((sum % k) + k) % k;
            if (dp[remainder] > 0) {
                result += dp[remainder];
            }
            dp[remainder]++;
        }

        return result;

    }
}