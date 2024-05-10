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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        dfs(root, val, depth, 1);
        return root;
    }

    private void dfs(TreeNode node, int val, int depth, int currentDepth) {
        if (node == null)
            return;

        if (currentDepth == depth - 1) {
            TreeNode leftChild = new TreeNode(val);
            leftChild.left = node.left;
            node.left = leftChild;

            TreeNode rightChild = new TreeNode(val);
            rightChild.right = node.right;
            node.right = rightChild;
            return;
        }

        dfs(node.left, val, depth, currentDepth + 1);
        dfs(node.right, val, depth, currentDepth + 1);
    }

    // Example usage:
    public static void main(String[] args) {
        // Constructing the binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        int val = 1;
        int depth = 2;

        Solution solution = new Solution();
        TreeNode newRoot = solution.addOneRow(root, val, depth);

        // Output the new tree
        printTree(newRoot);
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
