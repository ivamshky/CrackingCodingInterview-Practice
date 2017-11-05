class stack{
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX];
    
    stack(){
        top = -1;
    }

    boolean isEmpty(){
        return top<0;
    }

    boolean push(int x){
        if(top>=MAX){
            System.out.println("Stack Overflow");
            return false;
        }
        else{
            a[++top] = x;
            return true;
        }

    }

    int pop(){
        if(top<0){
            System.out.println("Stack Underflow");
            return 0;
        }
        else{
            int x = a[top--];
            return x;
        }

    }
    

    public static void main(String[] args) {
        stack s = new stack();
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}