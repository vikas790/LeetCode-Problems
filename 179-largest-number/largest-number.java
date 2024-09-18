class Solution {
    public String largestNumber(int[] nums) {
        // Convert the numbers to strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort the array using custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Handle the edge case where the largest number is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the result by concatenating sorted strings
        StringBuilder result = new StringBuilder();
        for (String str : strNums) {
            result.append(str);
        }

        return result.toString();
    }
}