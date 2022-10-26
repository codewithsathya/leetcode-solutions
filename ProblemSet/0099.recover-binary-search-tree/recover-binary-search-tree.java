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
    boolean solved = false;
    public void recoverTree(TreeNode root) {
        if(solved) return;
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        TreeNode rightMin = get(root.right, false);
        TreeNode leftMax = get(root.left, true);
        if(rightMin != null){
            System.out.println(rightMin.val);
        }
        if(leftMax != null){
            System.out.println(leftMax.val);
        }
        boolean rightMismatch = false;
        if(rightMin != null && root.val > rightMin.val){
            rightMismatch = true;
        }
        boolean leftMismatch = false;
        if(leftMax != null && root.val < leftMax.val){
            leftMismatch = true;
        }

        if(rightMismatch && leftMismatch){
            int temp = rightMin.val;
            rightMin.val = leftMax.val;
            leftMax.val = temp;
            solved = true;
        }else if(rightMismatch){
            int temp = root.val;
            root.val = rightMin.val;
            rightMin.val = temp;
            solved = true;
        }else if(leftMismatch){
            int temp = root.val;
            root.val = leftMax.val;
            leftMax.val = temp;
            solved = true;
        }
        recoverTree(root.left);
        if(solved) return;
        recoverTree(root.right);

    }

    TreeNode get(TreeNode root, boolean needLargest){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode left = get(root.left, needLargest);
        TreeNode right = get(root.right, needLargest);
        TreeNode largest = root;
        if(left != null){
            if(needLargest){
                if(largest.val < left.val){
                    largest = left;
                }
            }else{
                if(largest.val > left.val){
                    largest = left;
                }
            }
        }
        if(right != null){
            if(needLargest){
                if(largest.val < right.val){
                    largest = right;
                }
            }else{
                if(largest.val > right.val){
                    largest = right;
                }
            }
        }
        return largest;
    }

}