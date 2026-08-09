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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean flag = false;
        if(subRoot == null) return true;
        if(root == null) return false;
        if(root.val == subRoot.val){
            flag = isSameTree(root, subRoot);
        }

        return flag || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        boolean leftTree = isSameTree(root.left, subRoot.left);
        boolean rightTree = isSameTree(root.right, subRoot.right);

        return root.val == subRoot.val && leftTree && rightTree;
    }
}
