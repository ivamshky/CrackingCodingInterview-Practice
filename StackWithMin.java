import java.util.Stack;

class NodeWithMin{
    public int value;
    public int min;
    public NodeWithMin(int v, int min){
        value = v; this.min = min;
    }
}

class StackWithMin extends Stack<NodeWithMin> {
    public void push(int v){
        int newMin = Math.min(v,min());
        super.push(new NodeWithMin(v,newMin));
    }

    public int min(){
        if(this.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return peek().min;
        }
    }

    public static void main(String[] args) {
        StackWithMin s = new StackWithMin();
        s.push(10);
        s.push(20);
        s.push(5);
        s.push(6);
        s.push(2);
        System.out.println("Current Min: "+s.min());
        System.out.println("Popping: "+s.peek().value);
        s.pop();
        System.out.println("New Min: "+s.min());
    }
}