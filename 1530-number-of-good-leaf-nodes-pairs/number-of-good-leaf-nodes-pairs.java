/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {
    int result = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return result;
    }

    private int[] dfs(TreeNode node, int distance) {
        // Base case: If the node is null, return an empty distance array
        if (node == null) return new int[distance + 1];

        // Base case: If the node is a leaf node, return an array with 1 at index 1 (distance to itself)
        if (node.left == null && node.right == null) {
            int[] leafDist = new int[distance + 1];
            leafDist[1] = 1;
            return leafDist;
        }

        // Recursively get the distances from the left and right subtrees
        int[] leftDistances = dfs(node.left, distance);
        int[] rightDistances = dfs(node.right, distance);

        // Count pairs
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance; j++) {
                if (i + j <= distance) {
                    result += leftDistances[i] * rightDistances[j];
                }
            }
        }

        // Calculate the distance array for the current node
        int[] currentDistances = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            currentDistances[i + 1] = leftDistances[i] + rightDistances[i];
        }

        return currentDistances;
    }
}
