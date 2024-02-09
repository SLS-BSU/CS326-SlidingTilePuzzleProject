package core_search;

/** this interface represents a generic PriorityQueue
 *
 * @param <S>
 * @param <A>
 */
public interface PriorityQueue<S,A> {
    Node<S,A> pop();

    void add(Node<S,A> e);

    boolean isEmpty();

}
