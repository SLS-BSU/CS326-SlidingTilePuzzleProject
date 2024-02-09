package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.SlidingTilePuzzle;

import java.util.Comparator;
import java.util.List;

public class SlidingTileGBFSDistance extends BaseSearch<List<Integer>, String> {

    public SlidingTileGBFSDistance() {
        super(new SlidingTilePuzzle(), new SortedQueue<>(new CompareDistance()));
    }

    public static void main(String[] args) {
        SlidingTileGBFSDistance t = new SlidingTileGBFSDistance();
        t.search();
    }

    public static class CompareDistance implements Comparator<Node<List<Integer>, String>> {
        @Override
        public int compare(Node<List<Integer>, String> o1, Node<List<Integer>, String> o2) {
            SlidingTilePuzzle problem = new SlidingTilePuzzle();

            int h1 = problem.sumOfDistances(o1.getState());
            int h2 = problem.sumOfDistances(o2.getState());

            System.out.println("Heuristic for node 1: " + h1);
            System.out.println("Heuristic for node 2: " + h2);

            return Integer.compare(h1, h2);
        }
    }
}
