class Solution {
    int cnt = 0;
    int[] solve(TreeNode root)
    {
        if(root == null)
            return new int[]{0,0};
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        int sum = left[0] + right[0] + root.val;
        int nodes = left[1] + right[1] + 1;
        if(sum/nodes == root.val)
            cnt++;
        return new  int[]{sum, nodes};
    }
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return cnt;
    }
}
