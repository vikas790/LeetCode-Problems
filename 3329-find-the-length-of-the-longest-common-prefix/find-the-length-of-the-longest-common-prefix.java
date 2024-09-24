class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixSet = new HashSet<>();
        
        // Store all prefixes of numbers in arr1
        for (int num : arr1) {
            while (num > 0) {
                prefixSet.add(num);
                num /= 10;
            }
        }
        
        int longestPrefix = 0;
        
        // Check prefixes in arr2
        for (int num : arr2) {
            while (num > 0) {
                if (prefixSet.contains(num)) {
                    longestPrefix = Math.max(longestPrefix, String.valueOf(num).length());
                    break;
                }
                num /= 10;
            }
        }
        
        return longestPrefix;
    }
}
