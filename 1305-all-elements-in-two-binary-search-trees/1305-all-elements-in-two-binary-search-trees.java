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
class BST{
    TreeNode root;
    
    List<Integer> lst = new ArrayList<>();

    void inorder(TreeNode root){
        inorderRec(root);
    }

    void inorderRec(TreeNode root){
        if(root!=null){
            inorderRec(root.left);
            lst.add(root.val);
            inorderRec(root.right);
        }
    }
    
}

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        BST bst = new BST();
        
        bst.inorder(root1);
        bst.inorder(root2);

        List<Integer> lst = bst.lst;

        // System.out.println(lst1);
        // System.out.println(lst2);

        Collections.sort(lst);

        return lst;
    }
}