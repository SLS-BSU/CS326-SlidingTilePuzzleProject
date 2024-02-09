package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.SlidingTilePuzzle;

import java.util.Comparator;
import java.util.List;

/**
 * Solving the Sliding Tile Puzzle using greedy best-first search
 */
public class SlidingTileGBFSMisplaced extends BaseSearch<List<Integer>, String> {

    public SlidingTileGBFSMisplaced() {
        super(new SlidingTilePuzzle(), new SortedQueue<>(new CompareMisplacedTiles(new SlidingTilePuzzle())));
    }

    public static void main(String[] args) {
        SlidingTileGBFSMisplaced solver = new SlidingTileGBFSMisplaced();
        solver.search();
    }

    public static class CompareMisplacedTiles implements Comparator<Node<List<Integer>, String>> {

        private final SlidingTilePuzzle problem;

        public CompareMisplacedTiles(SlidingTilePuzzle problem) {
            this.problem = problem;
        }

        @Override
        public int compare(Node<List<Integer>, String> o1, Node<List<Integer>, String> o2) {
            if (misplacedTilesHeuristic(o1.getState()) < misplacedTilesHeuristic(o2.getState())) {
                return -1;
            } else if (misplacedTilesHeuristic(o1.getState()) == misplacedTilesHeuristic(o2.getState())) {
                return 0;
            } else {
                return 1;
            }
        }

        private int misplacedTilesHeuristic(List<Integer> state) {
            int count = 0;
            for (int i = 0; i < state.size(); i++) {
                if (state.get(i) != 0 && state.get(i) != i + 1) {
                    // Count the number of misplaced tiles
                    count++;
                }
            }
            return count;
        }
    }
}