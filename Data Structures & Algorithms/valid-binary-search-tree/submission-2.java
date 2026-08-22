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
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validateBST(TreeNode root, int lowerBound, int upperBound){
        boolean isSubTreeBST = true;
        if(root.left != null) {
            isSubTreeBST = isSubTreeBST && (root.left.val < root.val) && (root.left.val > lowerBound && root.left.val < upperBound) && validateBST(root.left, lowerBound, root.val);
        }
        if(root.right != null) {
            isSubTreeBST = isSubTreeBST && (root.right.val > root.val) && (root.right.val > lowerBound && root.right.val < upperBound) && validateBST(root.right, root.val, upperBound);
        }
        return isSubTreeBST;
    }
}
