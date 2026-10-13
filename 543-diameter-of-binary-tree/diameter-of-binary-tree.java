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
    int maxDi = 0;
    public int diameter(TreeNode root){   // Time : O(N) and space : O(N)
        if(root == null) return 0;

        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right);

        maxDi = Math.max(maxDi, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }


    public int diameterOfBinaryTree(TreeNode root) {
        
       diameter(root);
       return maxDi;
    }
}








