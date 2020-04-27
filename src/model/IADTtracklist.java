
package model;

import java.util.Date;

/**
 *
 * @author kiera
 * @param <E>
 */
public interface IADTtracklist<E> {

    /**
     *
     */
    public void printList();

    /**
     *
     * @param s
     * @return
     */
    public ListNode1<E> findArtist(String s);
    
    /**
     *
     * @param s
     * @return
     */
    public ListNode1<E> findTitle(String s);
    
    /**
     *
     * @param s
     * @return
     */
    public ListNode1<E> findGenre(String s);
    
    /**
     *
     * @param trackId
     * @param trackTitle
     * @param artist
     * @param trackLength
     * @param composer
     * @param releaseDate
     * @param album
     * @param genre
     */
    public void add(int trackId, String trackTitle, String artist, 
            int trackLength, String composer, Date releaseDate,
            String album, String genre);
}
