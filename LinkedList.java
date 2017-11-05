import java.util.*;
import java.io.*;

class LinkedList{
    Node head;

    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    // Adds a Node in front of the LinkedList
    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    //Adds a Node at the end of LinkedList
    public void append(int new_data){
        Node new_node = new Node(new_data);
        if(head == null){
            head = new_node;
            return;
        }
        Node last = head;
        while(last.next!=null)
            last = last.next;
        
        last.next = new_node;
    }

    public void printList(){
        Node tnode = head;
        while(tnode!=null){
            System.out.println(tnode.data+" ");
            tnode = tnode.next;
        }
    }

    public void deleteNode(int key){
        Node tmp = head, prev=null;
        
        if(tmp!=null && tmp.data==key){
            head = tmp.next;
            return;
        }

        while(tmp!=null && tmp.data!=key){
            prev = tmp;
            tmp = tmp.next;
        }

        if(tmp!=null)
            prev.next = tmp.next;
        else
            return;
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

    public static void removeDups(Node head){
        Hashtable table = new Hashtable();
        Node prev = null, n=head;
        while(n!=null){
            if(table.containsKey(n.data)) prev.next = n.next;
            else{
                table.put(n.data, true);
                prev = n;
            }
            n = n.next;
        }
    }

    public Node addLists(Node head1, Node head2){
        if(head1==null && head2==null){
            return null;
        }
        Node res = null, prev=null, tmp=null;
        int carry = 0, sum=0;


        while(head1!=null || head2!=null){
            sum = carry + (head1!=null?head1.data:0)+(head2!=null?head2.data:0);
            carry = (sum>=10)?1:0;
            sum %= 10;
            tmp = new Node(sum);
            if(res==null){
                res = tmp;
            }
            else{
                prev.next = tmp;
            }
            prev = tmp;

            if(head1!=null)
                head1 = head1.next;
            if(head2!=null) head2 = head2.next;
        }
        if(carry>0)
            prev.next = new Node(carry);
        // LinkedList result = new LinkedList();
        // result.head = res;
        return res;
    }

    public Node reverse(Node curr, Node prev){
        if(curr!=null){
            reverse(curr.next, curr);
            curr.next = prev;
        }
        else{
            head = prev;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        //Creating list 3->4->5->6
        for(int i=3;i<=6;++i)
            list1.append(i);
        System.out.println("Linked List1 is: "+list1);

        LinkedList list2 = new LinkedList();
        for(int i=3;i<=7;++i)
            list2.append(i);
        System.out.println("Linked List2 is: "+list2);
        
        LinkedList res = new LinkedList();
        res.head = list1.addLists(list1.head, list2.head);
        System.out.println(res);
        // res.printList();

        /*
        System.out.println("Deleting 2 from the list:");
        list.deleteNode(2);
        System.out.println(list);
        */
        /*
        //Adding Dups
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(4);
        System.out.println("Current List: "+list);
        removeDups(list.head);
        System.out.println("After Removing Dups: "+list);
        */
        LinkedList rev = new LinkedList();
        rev.head = res.reverse(res.head, null);
        System.out.println("Reversed List: "+rev);
    }
}