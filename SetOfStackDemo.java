import java.util.ArrayList;

class Node{
    public int value;
    public Node above, below;
    
    public Node(int val){
        value = val;
    }
}

class Stack{
    private int capacity;
    public Node top;
    public Node bottom;
    public int size = 0;

    public Stack(int cap){
        capacity = cap;
    }

    public boolean isFull(){
        return size==capacity;
    }

    public void join(Node above, Node below){
        if(below!=null) below.above = above;
        if(above!=null) above.below = below;
    }

    public boolean push(int v) {
        if(size>=capacity) return false;

        size++;
        Node n = new Node(v);
        if(size==1) bottom = n;
        join(n,top);
        top = n;
        return true;
    }

    public int pop() {
        Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int  removeBottom() {
        Node b = bottom;
        bottom = bottom.above;
        if(bottom!=null) bottom.below = null;

        size--;
        return b.value;
    }
}

class SetOfStacks{
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public int capacity;

    public SetOfStacks(int cap){
        capacity = cap;
    }

    public Stack getLastStack(){
        if(stacks.size()==0) return null;
        return stacks.get(stacks.size()-1);
    }

    public void push(int v){
        Stack last = getLastStack();
        if(last!=null && !last.isFull())
            last.push(v);
        else{
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop(){
        Stack last = getLastStack();
        int v = last.pop();
        if(last.size==0)
            stacks.remove(stacks.size()-1);
        return v;
    }

    public boolean isEmpty(){
        Stack last = getLastStack();
        return last==null || last.isEmpty();
    }
}

class SetOfStackDemo{
    public static void main(String[] args) {
        int cap_per_stack = 5;
        SetOfStacks set = new SetOfStacks(cap_per_stack);
        for(int i=0;i<34;i++){
            set.push(i);
        }
        for(int i=0;i<34;++i){
            System.out.println("Popped: "+set.pop());
        }
    }
}