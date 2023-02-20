class Solution
{
    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root)
    {
       if(root == null)  return 0;

        if(map.containsKey(root))       return map.get(root);

       int oddSum = root.val;

       if(root.left != null)
       {
           oddSum += rob(root.left.left);
           oddSum += rob(root.left.right);
       }

       if(root.right != null)
       {
           oddSum += rob(root.right.right);
           oddSum += rob(root.right.left);
       }

        int evenSum = rob(root.left) + rob(root.right);

        int res = Math.max(oddSum, evenSum);
        map.put(root, res);

        return res;
    }
   }
