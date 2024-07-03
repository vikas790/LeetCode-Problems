class Solution {
    public int minDifference(int[] nums) {
       int n = nums.length;
       if(n <= 4) return 0;

       Arrays.sort(nums);

       int minDiff = Integer.MAX_VALUE;
       for(int i = 0; i <= 3; i++) {
        minDiff = Math.min(minDiff, nums[n-4 + i] - nums[i]);
       }
       return minDiff;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {5,3,2,4};
        System.out.println(solution.minDifference(nums1));

        int[] nums2 = {1,5,0,10,14};
        System.out.println(solution.minDifference(nums1));

        int[] nums3 = {6,6,0,1,1,4,6};
        System.out.println(solution.minDifference(nums1));

        int[] nums4 = {1,5,6,14,15};
        System.out.println(solution.minDifference(nums1));
    }
}