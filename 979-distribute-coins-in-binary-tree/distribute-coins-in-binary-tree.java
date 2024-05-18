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
    public int moves;

    public int countmoves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCoins = countmoves(root.left);
        int rightCoins = countmoves(root.right);

        moves += Math.abs(leftCoins) + Math.abs(rightCoins);

        return leftCoins + rightCoins + root.val - 1; 
    }

    public int distributeCoins(TreeNode root) {
        moves = 0;
        countmoves(root);
        return moves;
    }

}
