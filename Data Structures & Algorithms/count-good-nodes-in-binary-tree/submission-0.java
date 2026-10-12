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
    int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        traverseTree(root, root.val);
        return count;
    }

    public void traverseTree(TreeNode root, int maxValue){
        if(root.val >= maxValue) {
            count++;
            maxValue = root.val;
        }

        if(root.left != null) traverseTree(root.left, maxValue);
        if(root.right != null) traverseTree(root.right, maxValue);
    }
}
