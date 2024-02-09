package core_search;

import java.util.Stack;

public class LIFOQueue<S,A> implements PriorityQueue<S,A> {
    private final Stack<Node<S,A>> queue = new Stack<>();

    public void add(Node<S,A> e){
        queue.push(e);
        //System.out.println(e.getState()+" added");
    }

    public Node<S,A> pop(){
        return queue.pop();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
