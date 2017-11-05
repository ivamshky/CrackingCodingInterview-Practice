import java.util.*;
import tree.TreeNode;

public class CreateMinimalTree{
    public static TreeNode createBST(int[] a){
        if(a==null) return null;
        return createBST(a,0,a.length-1);
    }

    private static TreeNode createBST(int[] a, int start, int end){
        if(start>end)
            return null;
        int mid = (start+end)/2;
        TreeNode n = new TreeNode(a[mid]);
        n.left = createBST(a, start, mid-1);
        n.right = createBST(a, mid+1, end);
        return n;
    }

    public static void main(String[] args) {
        TreeNode.printTree(createBST(new int[] {}));
        System.out.println();
        TreeNode.printTree(createBST(new int[] {0,1,2}));
        System.out.println();
        TreeNode.printTree(createBST(new int[] {0,1,2,3,4,5,6}));
        System.out.println();
        TreeNode.printTree(createBST(new int[] {-2,-1,0,1,2,3,4}));
    }
}