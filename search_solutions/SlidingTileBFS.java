package search_solutions;

import core_search.BaseSearch;
import core_search.FIFOQueue;
import search_problems.SlidingTilePuzzle;

import java.util.List;

public class SlidingTileBFS extends BaseSearch<List<Integer>, String> {
    public SlidingTileBFS() { super(new SlidingTilePuzzle(), new FIFOQueue<>());}

    public static void main(String[] args) {
        SlidingTileBFS t = new SlidingTileBFS();
        t.search();
    }
}