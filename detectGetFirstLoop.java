class detectGetFirstLoop{
    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public Node findBegining(Node node){
        if(node == null || node.next == null) return null;

        Node slow = node, fast = node;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                break;
        }

        if(fast.next==null){
            return null;
        }

        slow = node;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    @Override
    public String toString(){
        Node tnode = head;
        String linkedList="";
        while(tnode.next!=null){
            linkedList += tnode.data+"->"; 
            tnode = tnode.next;
        }
        linkedList += tnode.data;
        return linkedList;
    }

    public static void main(String[] args) {
        detectGetFirstLoop list = new detectGetFirstLoop();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);
 
        // Creating a loop for testing 
        head.next.next.next.next.next = head.next.next;
        System.out.println("Cycle Head at"+list.findBegining(head).data);
    }
}