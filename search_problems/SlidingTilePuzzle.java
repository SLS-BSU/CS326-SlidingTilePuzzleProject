package search_problems;

import core_search.Problem;
import core_search.Tuple;

import java.util.ArrayList;
import java.util.List;

public class SlidingTilePuzzle implements Problem<List<Integer>,String> {
    // empty cell is 0
    private final List<Integer> INITIAL_STATE = new ArrayList<>(List.of(7,2,4, 5,0,6, 8,3,1));
    private final List<Integer> GOAL_STATE = new ArrayList<>(List.of(0,1,2, 3,4,5, 6,7,8));

    //size of board
    private final int SIZE;

    public SlidingTilePuzzle() {
        SIZE = (int) Math.sqrt(INITIAL_STATE.size());
    }

    public List<Integer> swap(List<Integer> state, int index, int move){
        List<Integer> newState = new ArrayList<>(state);
        int newIndex = index + move;
        int temp = newState.get(index);
        newState.set(index, newState.get(newIndex));
        newState.set(newIndex, temp);

        return newState;
    }

    public List<Tuple<List<Integer>, String>> execution(List<Integer> currentState){
        int index = currentState.indexOf(0);
        int row = index / SIZE;
        int col = index % SIZE;
        List<Tuple<List<Integer>, String>> newStates = new ArrayList<>();

        if (row > 0){
            //can move up
            newStates.add(new Tuple<>(swap(currentState, index, -SIZE),"up",1));
        }
        if (row < SIZE-1){
            // can move down
            newStates.add(new Tuple<>(swap(currentState, index, SIZE),"down",1));
        }

        if(col > 0){
            //can move left
            newStates.add(new Tuple<>(swap(currentState, index, -1),"left",1));
        }
        if(col < SIZE-1){
            // can move right
            newStates.add(new Tuple<>(swap(currentState, index, 1),"right",1));
        }
        return newStates;
    }

    public List<Integer> initialState() {
        return INITIAL_STATE;
    }

    public List<Integer> goalState() {
        return GOAL_STATE;
    }

    public void printState(List<Integer> state){
        for (int i=0; i<state.size(); i++){
            if (state.get(i) != 0){
                System.out.printf("%3s", state.get(i) + " ");
            } else {
                System.out.print("   ");
            }
            if(i % SIZE == SIZE - 1){
                System.out.println();
            }
        }
    }
    public int misplacedTiles(List<Integer> state){
//        heuristic 1
        int count = 0;
        for (int i=0; i<state.size(); i++){
            if (state.get(i) == 0){
                continue;
            } else {
                if (state.get(i) != GOAL_STATE.get(i)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int sumOfDistances(List<Integer> state) {
        int sum = 0;
        int size = (int) Math.sqrt(state.size());

        for (int i = 0; i < state.size(); i++) {
            int value = state.get(i);
            if (value != 0) {
                int goalIndex = state.indexOf(value);
                int goalRow = goalIndex / size;
                int goalCol = goalIndex % size;
                int currentRow = i / size;
                int currentCol = i % size;

                sum += Math.abs(goalRow - currentRow) + Math.abs(goalCol - currentCol);
            }
        }
        return sum;
    }
}