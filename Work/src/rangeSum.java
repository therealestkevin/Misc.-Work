
import java.util.ArrayList;

public class rangeSum {

    public static void main (String[]args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode((56));
        root.left.left = new TreeNode(1);
        rangeSumBST(root,3,3);

    }
    public static int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        ArrayList<Integer> answers = recurseTree(root);
        int sum =0;
        for(int i : answers){
            if(i>=L && i<=R){
                sum+=i;
            }
        }
        return sum;


    }
    public  static ArrayList<Integer> recurseTree(TreeNode cur){
        ArrayList<Integer> returner = new ArrayList<>();
        returner.add(cur.val);
        if(cur.left!=null){
            returner.addAll(recurseTree(cur.left));
        }
        if(cur.right!=null){
            returner.addAll(recurseTree(cur.right));
        }
        return  returner;
    }


    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
}
