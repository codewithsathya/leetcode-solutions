/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        String str = "";
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr != null){
                str += curr.val + ":";
            }else{
                str += "n:";
                continue;
            }
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(":");
        Integer[] nums = new Integer[strs.length];
        for(int i = 0; i < nums.length; i++){
            if(strs[i].equals("n")){
                nums[i] = null;
            }else{
                nums[i] = Integer.valueOf(strs[i]);
            }
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(nums[0] == null) return null;
        queue.add(new TreeNode(nums[0]));
        TreeNode root = queue.peek();
        for(int i = 1; i < nums.length; i = i + 2){
            int leftIndex = i;
            int rightIndex = i + 1;
            TreeNode parent = queue.peek();
            TreeNode left = nums[i] == null ? null : new TreeNode(nums[i]);
            parent.left = left;
            if(left != null){
                queue.add(left);
            }
            if(i + 1 < nums.length){
                TreeNode right = nums[i + 1] == null ? null : new TreeNode(nums[i + 1]);
                parent.right = right;
                if(right != null){
                    queue.add(right);
                }
            }
            queue.poll();
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));