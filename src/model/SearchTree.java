package model;

/**
 *
 * @author kiera
 * @param <E>
 */
public interface SearchTree<E extends Comparable<E>>  {

    /**
     *
     * @param item
     * @return
     */
    boolean add(E item);

    /**
     *
     * @param target
     * @return
     */
    boolean contains(E target);

    /**
     *
     * @param target
     * @return
     */
    E find(E target);

    /**
     *
     * @param target
     * @return
     */
    E delete(E target);

    /**
     *
     * @param target
     * @return
     */
    boolean remove(E target);
}
