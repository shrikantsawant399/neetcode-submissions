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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val) return root;
        if((p.val > root.val && root.val > q.val) || p.val < root.val && root.val < q.val) return root;

        TreeNode node = null;
        if(root.val > p.val && root.val > q.val) {
            node = root.left;
        } else {
            node = root.right;
        }
        return lowestCommonAncestor(node, p, q);
    }
}
