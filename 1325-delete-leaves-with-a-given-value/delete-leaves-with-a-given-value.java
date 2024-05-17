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
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        helper(root, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;

    }

    public TreeNode helper(TreeNode root, int target) {
        if (root == null)
            return null;

        root.left = helper(root.left, target);
        root.right = helper(root.right, target);
        if (root.left == root.right && root.val == target) {
            return null;
        }
        return root;

    }
}
