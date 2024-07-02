import java.util.*;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // Create two pointers for both arrays
        int i = 0, j = 0;
        List<Integer> resultList = new ArrayList<>();

        // Iterate through both arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                resultList.add(nums1[i]);
                i++;
                j++;
            }
        }

        // Convert resultList to an array
        int[] result = new int[resultList.size()];
        for (int k = 0; k < resultList.size(); k++) {
            result[k] = resultList.get(k);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [2, 2]

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        result = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [4, 9]
    }
}
