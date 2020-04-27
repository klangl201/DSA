package model;

import java.util.Date;

/**
 *
 * @author kiera
 * @param <E>
 */
public class TrackList1<E> implements IADTtracklist<E> {

    private ListNode1<E> head = null;
    private int size = 0; 
    private int nextFreePosition = 0;
    private final int maxitems;
    private final int defaultmaxitems = 32;
    private int top = -1;
    private E[] list = (E[]) new Object[defaultmaxitems];
    
    /**
     *
     */
    public TrackList1() {
        this.maxitems = defaultmaxitems;
        this.createList();
        head = null;
    }  

    /**
     *
     * @return
     */
    public int size() {
        return this.size;
    }
    
    /**
     *
     * @return
     */
    public int length() {
        return size;    
    }

    /**
     *
     */
    public void createList() {
        size = 0;
        nextFreePosition = 0;
        this.list = (E[])new Object[defaultmaxitems];    
    }
    
    /**
     *
     * @param e
     * @return
     */
    public boolean insert(E e) {
	Boolean ok = true;
        if (isFull()) {
            System.out.println(String.format("Array is full, only %d elements allowed in list.", maxitems));
            ok = false;
        } 
        else {
            this.addItem(e);
            this.size ++;
            this.top ++;
        }
        return ok;    
    }    
    
    /**
     *
     * @param artist
     * @return
     */
    @Override
    public ListNode1<E> findArtist(String artist) {
        
        ListNode1<E> node = head;
        if(!isEmpty()){
            while(node != null) {
              node = node.next;   
              if(node.artist.equals(artist)) {   
              return node;
              }
              

            }   
        }
        return null;
    }
    
    /**
     *
     * @param title
     * @return
     */
    @Override
    public ListNode1<E> findTitle(String title) {
        
        ListNode1<E> node = head;
        if(!isEmpty()){
            while(node != null) {
              node = node.next;
              if(node.trackTitle.equals(title)) {
                  return node;
              }
            }   
        }
        return null;
    }    
    
    /**
     *
     * @param genre
     * @return
     */
    @Override
    public ListNode1<E> findGenre(String genre) {
        
        ListNode1<E> node = head;
        if(!isEmpty()){
              while(node != null) {   
              if(node.genre.equals(genre)) {
                  return node;
              } node = node.next; 
            } 
              
        }
        return null;
    }
     
    private boolean isFull() {
        return (size == list.length);
    }

    private boolean isEmpty() {
        return (size == 0);
    }

    private void addItem(E e) {
        for (int index = size; index > 0; index--)
            list[index] = list[index -1];
        list[nextFreePosition] = e;    
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        int tmp = 0;

	while (tmp <= this.top) {
            sb.append(this.list[tmp]).append(" ");
            tmp ++;
	}

        return sb.toString();
    } 
    
    /**
     *
     */
    @Override
    public void printList() {
        System.out.println(String.format("No. of list items: %d", size));        
        
        ListNode1<E> node = head;
        
        while(node != null) {
            System.out.println(String.format("No. of list items: %d", size));
            node.display();
            node = node.next;
            System.out.println();
        }
    }
    
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
    @Override
    public void add(int trackId, String trackTitle, String artist, 
            int trackLength, String composer, Date releaseDate,
            String album, String genre) {
        
        ListNode1 node = new ListNode1 (trackId, trackTitle, artist, trackLength,
        composer, releaseDate, album, genre);
        
        node.next = head;
        head = node;
        size++;
        
    }

   
}
