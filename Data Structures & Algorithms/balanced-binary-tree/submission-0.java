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
    boolean isBalancedFlag = true;
    public boolean isBalanced(TreeNode root) {
        int height = calculateHeight(root);
        return isBalancedFlag;
    }

    public int calculateHeight(TreeNode root){
        if(root == null) return 0;

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            isBalancedFlag = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
