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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inMap);
    }

    public TreeNode build(int[] preorder, int preLow, int preHigh, int inLow, int inHigh, Map<Integer, Integer> inMap){
        if(preLow > preHigh || inLow > inHigh){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLow]);
        int inInd = inMap.get(preorder[preLow]);
        int numsLeft = inInd - inLow;
        root.left = build(preorder, preLow + 1, preLow + numsLeft, inLow, inInd - 1, inMap);
        root.right = build(preorder, preLow + numsLeft + 1, preHigh, inInd + 1, inHigh, inMap);
        return root;
    }

}