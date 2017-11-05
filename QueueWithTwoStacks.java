import java.util.Stack;

class MyQueue<T>{
    Stack<T> stackNew, stackOld;
    public MyQueue(){
        stackNew = new Stack<T>();
        stackOld = new Stack<T>();
    }

    public int size(){
        return stackOld.size()+stackNew.size();
    }

    public void add(T value){
        stackNew.push(value);
    }

    private void shiftStacks(){
        if(stackOld.isEmpty()){
            while(!stackNew.isEmpty()){
                stackOld.push(stackNew.pop());
            }
        }
    }

    public T peek(){
        shiftStacks();
        return stackOld.peek();
    }

    public T pop(){
        shiftStacks();
        return stackOld.pop();
    }
}

class QueueWithTwoStacks{
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();

        for(int i=1;i<=5;++i){
            myQueue.add(i);
        }

        while(myQueue.size()>0){
            System.out.println(myQueue.pop());
        }
    }
}