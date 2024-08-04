// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarraySums = new ArrayList<>();
        
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start + 1; end <= nums.length; end++) {
                sum += nums[end - 1];
                subarraySums.add(sum);
            }
        }
        
        Collections.sort(subarraySums);
        long result = 0;
        
        for (int i = left - 1; i < right; i++) {
            result += subarraySums.get(i);
        }
        
        return (int)(result % (1_000_000_007));
    }
}

