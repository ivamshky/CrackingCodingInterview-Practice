import java.util.ArrayList;
import java.util.LinkedList;
import tree.TreeNode;
// class TreeNode{
//     public int value;
//     public TreeNode left,right;
    
//     public TreeNode(int x){
//         value = x;
//     }

//     @Override
//     public String toString(){
//         return String.valueOf(value);
//     }

//     public static void printTree(TreeNode N){
//         if(N==null) return;
//         System.out.println(N.value);
//         printTree(N.left,0,true);
//         printTree(N.right,0,false);
//     }

//     public static void printTree(TreeNode N, int level, boolean isLeft){
//         if(N==null) return;

//         for(int i=0;i<level;++i) System.out.print(" ");
//         if(isLeft)
//             System.out.println("/- "+N.value);
//         else
//             System.out.println("\\- "+N.value);
        
//         printTree(N.left, level+1, true);
//         printTree(N.right,level+1,false);
//     }
// }

public class LevelLinkedList{
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
        if(root!=null) curr.add(root);

        while(!curr.isEmpty()){
            res.add(curr);
            LinkedList<TreeNode> parents = curr;
            curr = new LinkedList<TreeNode>();
            for(TreeNode parent: parents){
                if(parent.left!=null) curr.add(parent.left);
                if(parent.right!=null) curr.add(parent.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(3), 
                 n3 = new TreeNode(5), r = new TreeNode(4);
        n1.left = new TreeNode(2); n1.right = n2; n2.right = new TreeNode(6);
        r.left = n1; r.right = n3; n3.right = new TreeNode(7);
        TreeNode.printTree(r);
        System.out.println();

        System.out.println("createLevelLinkedList:");
        ArrayList<LinkedList<TreeNode>> levels = createLevelLinkedList(r);
        for (LinkedList<TreeNode> level : levels) {
            for (TreeNode node : level) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}