package model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author kiera
 * @param <E>
 */
public class TrackBST<E extends Comparable<E>>
        extends BinaryTree<E>
        implements SearchTree<E> {

    /**
     *
     */
    protected boolean addReturn;

    /**
     *
     */
    protected E deleteReturn;

    /**
     *
     * @param target
     * @return
     */
    @Override
    public E find(E target) {
        return find(root, target);
    }

    private E find(ListNode1<E> localRoot, E target) {
        if (localRoot == null) {
            return null;
        }

        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0) {
            return localRoot.data;
        } else if (compResult < 0) {
            return find(localRoot.left, target);
        } else {
            return find(localRoot.right, target);
        }
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }


    private ListNode1<E> add(ListNode1<E> localRoot, E item) {
        if (localRoot == null) {

            addReturn = true;
            return new ListNode1<>(item);
        } else if (item.compareTo(localRoot.data) == 0) {

            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {

            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {

            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    /**
     *
     * @param target
     * @return
     */
    @Override
    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }

    private ListNode1<E> delete(ListNode1<E> localRoot, E item) {
        if (localRoot == null) {
            deleteReturn = null;
            return localRoot;
        }

        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                return localRoot.right;
            } else if (localRoot.right == null) {
                return localRoot.left;
            } else {
                if (localRoot.left.right == null) {
                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    /**
     *
     * @param target
     * @return
     */
    @Override
    public boolean remove(E target) {
        return delete(target) != null;
    }

    /**
     *
     * @param target
     * @return
     */
    @Override
    public boolean contains(E target) {
        return find(target) != null;
    }

    private E findLargestChild(ListNode1<E> parent) {
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } 
        else {
            return findLargestChild(parent.right);
        }
    }

    /**
     *
     * @param target
     * @return
     */
    public E deletePrime(E target) {
        root = deletePrime(root, target);
        return deleteReturn;
    }

    private ListNode1<E> deletePrime(ListNode1<E> localRoot, E item) {
        if (localRoot == null) {
            deleteReturn = null;
            return localRoot;
        }


        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {

            localRoot.left = deletePrime(localRoot.left, item);
            return localRoot;
        } 
        else if (compResult > 0) {

            localRoot.right = deletePrime(localRoot.right, item);
            return localRoot;
        } 
        else {

            deleteReturn = localRoot.data;
            if (localRoot.left == null) {

                return localRoot.right;
            } 
            else if (localRoot.right == null) {

                return localRoot.left;
            }
            else {

                if (localRoot.right.left == null) {
                    localRoot.data = localRoot.right.data;
                    localRoot.right = localRoot.right.right;
                    return localRoot;
                } 
                else {
                    localRoot.data = findSmallestChild(localRoot.right);
                    return localRoot;
                }
            }
        }
    }

    private E findSmallestChild(ListNode1<E> parent) {
        if (parent.left.left == null) {
            E returnValue = parent.left.data;
            parent.left = parent.left.right;
            return returnValue;
        } else {
            return findSmallestChild(parent.left);
        }
    }

    /**
     *
     * @return
     */
    public List<E> toList() {
        List<E> result = new ArrayList<>();
        toList(result, root);
        return result;
    }

    private void toList(List<E> result, ListNode1<E> node) {
        if (node == null) {
            return;
        }
        toList(result, node.left);
        result.add(node.data);
        toList(result, node.right);
    }
}
