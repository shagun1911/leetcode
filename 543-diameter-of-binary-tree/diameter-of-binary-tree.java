class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        checkHeight(root);
        return diameter;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        int right = checkHeight(node.right);
        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}
