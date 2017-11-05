// Node of a Tree and Functions
package tree;
public class TreeNode{
    public int data;
    public TreeNode left, right;
    public TreeNode parent;

    public TreeNode(int x){
        data = x;
    }

    public String toString(){
        return String.valueOf(data);
    }

    public static void printTree(TreeNode n){
        if(n==null) return;
        System.out.print(n.data+" ");
        printTree(n.left);
        printTree(n.right);
    }
}