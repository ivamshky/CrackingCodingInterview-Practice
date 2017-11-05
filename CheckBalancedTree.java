
class Node{
    int data;
    Node left, right;
    Node(int d){
        data = d;
        right = left = null;
    }
}

class Height{
    int height = 0;
}

class checkBalancedTree{
    Node root;

    boolean isBalanced(Node root, Height height){
        if(root==null){
            height.height = 0;
            return true;
        }

        Height lHeight = new Height(), rHeight = new Height();
        boolean l = isBalanced(root.left, lHeight);
        boolean r = isBalanced(root.right, rHeight);
        int lh = lHeight.height ,rh = rHeight.height;

        height.height = ((lh>rh)?lh:rh)+1;

        if(Math.abs(lh-rh)>=2){
            return false;
        }
        else{
            return l&&r;
        }

    }

    public static void main(String[] args) {
        Height height = new Height();
        checkBalancedTree T = new checkBalancedTree();
        T.root = new Node(1);
        T.root.left = new Node(2);
        T.root.right = new Node(3);
        T.root.left.left = new Node(4);
        T.root.left.right = new Node(5);
        T.root.right.right = new Node(6);
        T.root.left.left.left = new Node(7);

        System.out.println("Balanced? "+T.isBalanced(T.root, height));
    }
}