package search_solutions;

import core_search.BaseSearch;
import core_search.LIFOQueue;
import search_problems.SlidingTilePuzzle;

import java.util.List;

public class SlidingTileDFS extends BaseSearch<List<Integer>, String> {
    public SlidingTileDFS() {
        super(new SlidingTilePuzzle(), new LIFOQueue<>());
    }

    public static void main(String[] args) {
        SlidingTileBFS t = new SlidingTileBFS();
        t.search();
    }
}
