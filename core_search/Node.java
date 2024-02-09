package core_search;

/** A generic implementation of the search tree node
 * (See AIMA 4e, page 73, Ch 3.3.2 for a description)
 *
 */
public class Node<S, A> {
    private final S STATE;
    private final A ACTION;
    private final int PATHCOST;
    private final Node<S,A> PARENT;

    public Node(S state, A action, int pathcost, Node<S,A> parent) {
        this.STATE = state;
        this.ACTION = action;
        this.PATHCOST = pathcost;
        this.PARENT = parent;
    }

    public S getState() {
        return STATE;
    }

    public A getAction() {
        return ACTION;
    }

    public int getPathCost() {
        return PATHCOST;
    }

    public Node<S,A> getParent() {
        return PARENT;
    }

    @Override
    public String toString() {
        return "{" +
                STATE +
                ", " + ACTION +
                ", " + PATHCOST +
                ", " + PARENT +
                '}';
    }
}
