package leetcode;

/**
 * @author dcg
 *         Created by user on 2018/3/13.
 */
public class le654 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getMax(0,nums.length - 1,nums);
    }

    private TreeNode getMax(int start, int end, int[] nums) {
        if (start>end){
            return null;
        }
        int max=nums[start];
        int current=start;
        for (int i=start+1;i<=end;i++){
            if (max<nums[i]){
                max=nums[i];
                current=i;
            }
        }
        TreeNode root=new TreeNode();
        root.val=max;
        root.left=getMax(start,current-1,nums);
        root.right=getMax(current+1,end,nums);
        return root;
    }
}
