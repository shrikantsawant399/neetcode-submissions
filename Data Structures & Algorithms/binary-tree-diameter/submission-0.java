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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int height = calculateTreeHeight(root);
        return diameter;
    }

    public int calculateTreeHeight(TreeNode root){
        if(root == null) return 0;

        int leftHeight = calculateTreeHeight(root.left);
        int rightHeight = calculateTreeHeight(root.right);

        diameter = Math.max(leftHeight + rightHeight, diameter);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
