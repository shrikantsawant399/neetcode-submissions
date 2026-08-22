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
    int kthElement = 0;
    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return kthElement;
    }

    public void traversal(TreeNode root, int k){
        if(root.left != null) traversal(root.left, k);
        count++;
        if(count == k) kthElement = root.val;
        if(root.right != null) traversal(root.right, k);
    }
}