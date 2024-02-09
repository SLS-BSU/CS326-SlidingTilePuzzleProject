package core_search;

import java.util.LinkedList;
import java.util.Queue;


public class FIFOQueue<S,A> implements PriorityQueue<S,A> {
    private final Queue<Node<S,A>> queue = new LinkedList<>();

    public void add(Node<S,A> e){
        queue.add(e);
        //System.out.println(e.getState()+" added");
    }

    public Node<S,A> pop(){
        return queue.remove();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
