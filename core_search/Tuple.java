package core_search;

public class Tuple<S,A>{
    final S state;
    final A action;
    final int cost;

    public Tuple(S state, A action, int cost){
        this.state = state;
        this.action = action;
        this.cost = cost;
    }

    public S getState() {
        return state;
    }

    public A getAction() {
        return action;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "{" +
                state +
                ", " + action +
                ", " + cost +
                '}';
    }
}
