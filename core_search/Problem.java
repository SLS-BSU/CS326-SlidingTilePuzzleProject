package core_search;

import java.util.List;

/**
 * This interface represents a generic search problem formulation.
 * (See AIMA 4e, page 65, Ch 3.1.1 for a description.)
 * @param <S>
 * @param <A>
 */
public interface Problem <S, A>{
    S initialState();
    S goalState();

    //executes all the applicable actions at the state and
    //returns a list of [new state, action taken, cost]
    List<Tuple<S,A>> execution(S state);

    void printState(S state);
}
