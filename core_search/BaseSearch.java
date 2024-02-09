package core_search;

import java.util.*;

/**
 *  An implementation of the general search algorithm
 *  (AIMA 4e, page 73, Figure 3.7 with some modifications)
 *  To implement a specific search algorithm (such as BFS, DFS, etc.),
 *  extend this class and provide an implementation of the PriorityQueue
 *  */

public class BaseSearch<S,A> {
    private final Problem<S,A> p;
    private final PriorityQueue<S,A> frontier;
    private final Set<S> expanded = new HashSet<>();

    public BaseSearch(Problem<S, A> p, PriorityQueue<S, A> frontier) {
        this.p = p;
        this.frontier = frontier;
    }

    public boolean search(){
        frontier.add(new Node<>(p.initialState(), null, 0, null));

        while(!frontier.isEmpty()){
            Node<S,A> node = frontier.pop();
            if (!expanded.contains(node.getState())){
                System.out.println(node.getState()+" expanded");
                if(node.getState().equals(p.goalState())){
                    System.out.println("Goal state reached!");
                    int pathCost = node.getPathCost();
                    Stack<S> path = new Stack<>();
                    do {
                        path.add(node.getState());
                        node = node.getParent();
                    } while(node!=null);
//                    Collections.reverse(path);

                    System.out.println("Path (from initial state to goal state): ");
                    while(!path.isEmpty()){
                        p.printState(path.pop());
                        if(!path.isEmpty()) {
                            System.out.println("--------- ↓");
                        }
                    }
                    System.out.println("\nPath cost: "+ pathCost);
                    return true;
                }
                expanded.add(node.getState());

                for(Tuple<S,A> t : p.execution(node.getState())){
                    Node<S,A> child = new Node<>(t.getState(), t.getAction(),t.getCost()+node.getPathCost(), node);
                    frontier.add(child);
                    System.out.println("Adding to frontier: " + child.getState());
                }
            }
        }
        return false;
    }
}
