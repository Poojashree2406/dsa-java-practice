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
    int height(TreeNode root) {
        if (root == null) return 0;
        int a = height(root.left);
        int b = height(root.right);
        return a > b ? a + 1 : b + 1;
    }
    void abc(TreeNode root, int h, List<List<Integer>> x) {
        if (root == null) return;
        x.get(h).add(root.val);
        abc(root.left, h + 1, x);
        abc(root.right, h + 1, x);
    }
    public List<Integer> rightSideView(TreeNode root) {
        int h = height(root);
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> x = new ArrayList<>();
        for (int i = 0; i < h; i++) x.add(new ArrayList<>());
        abc(root, 0, x);
        for (int i = 0; i < h; i++) {
            ans.add(x.get(i).get(x.get(i).size() - 1));
        }
        return ans;
    }
}