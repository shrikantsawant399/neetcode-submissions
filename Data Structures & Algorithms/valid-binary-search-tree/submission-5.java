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
    TreeNode previous = null;
    public boolean isValidBST(TreeNode root) {
        return inOrderTraversal(root);
    }

    public boolean inOrderTraversal(TreeNode root){
        if (root == null) return true;
        boolean leftResult = inOrderTraversal(root.left);
        if (previous != null && previous.val >= root.val) return false;
        previous = root;
        boolean rightResult = inOrderTraversal(root.right);
        return leftResult && rightResult;
    }
}
