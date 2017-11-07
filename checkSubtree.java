import java.util.*;
import tree.TreeNode;

class Tree{
    public TreeNode root;
    public static TreeNode createTree(int[] a){
        if(a==null)
            return null;
        return createTree(a,0,a.length-1);
    }

    private static TreeNode createTree(int[] a, int l, int r){
        if(l>r)
            return null;
        int mid = (l+r)/2;
        TreeNode T = new TreeNode(a[mid]);
        T.left = createTree(a, l, mid-1);
        T.right = createTree(a, mid+1, r);
        return T;   
    }

    public boolean containsTree(TreeNode T1, TreeNode T2){
        if(T2==null)
            return true;
        return subTree(T1,T2);
    }

    private boolean subTree(TreeNode T1, TreeNode T2){
        if(T1==null)
            return false;
        if(T1.data == T2.data)
            if(matchTree(T1,T2))
                return true;
        return subTree(T1.left, T2) || subTree(T1.right, T2);
    }

    private boolean matchTree(TreeNode T1, TreeNode T2){
        if(T2==null && T1==null)
            return true;
        if(T1==null || T2==null)
            return false;
        if(T1.data!=T2.data)
            return false;
        return matchTree(T1.left, T2.left) && matchTree(T1.right, T2.right);
    }
}

class checkSubtree{
    public static void main(String[] args) {
        Tree T1 = new Tree();
        T1.root = Tree.createTree(new int[]{0,1,2,3,4,5,6});
        Tree T2 = new Tree();
        T2.root = Tree.createTree(new int[]{4,5,6});
        boolean isSubtree = T1.containsTree(T1.root, T2.root);

        if(isSubtree)
            System.out.println("T2 is a Subtree of T1");
        else
            System.out.println("T2 is not a Subtree of T1");
    }
}