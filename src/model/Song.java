/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;


/**
 *
 * @author Kieran Langley
 */
public class Song {
    
    private int trackId;
    private String trackTitle;
    private String artist;
    private int trackLength;
    private String composer;
    private String album;
    private String genre;
    private Date releaseDate;
    
    /**
     *
     * @return
     */
    public int getTrackId(){
        return trackId;
    }
    
    /**
     *
     * @param trackId
     */
    public void setTrackId(int trackId){
        this.trackId = trackId;
    }
    
    /**
     *
     * @return
     */
    public String getTrackTitle(){
        return trackTitle;
    }
    
    /**
     *
     * @param trackTitle
     */
    public void setTrackTitle(String trackTitle){
        this.trackTitle = trackTitle;
    }  
    
    /**
     *
     * @return
     */
    public String getArtist(){
        return artist;
    }
    
    /**
     *
     * @param artist
     */
    public void setArtist(String artist){
        this.artist = artist;
    }
    
    /**
     *
     * @return
     */
    public int getTrackLength(){
        return trackLength;
    }
    
    /**
     *
     * @param trackLength
     */
    public void setTrackLength(int trackLength){
        this.trackLength = trackLength;
    }

    /**
     *
     * @return
     */
    public String getComposer(){
        return composer;
    }
    
    /**
     *
     * @param composer
     */
    public void setComposer(String composer){
        this.composer = composer;
    }
    
    /**
     *
     * @return
     */
    public String getAlbum(){
        return album;
    }
    
    /**
     *
     * @param album
     */
    public void setAlbum(String album){
        this.album = album;
    }

    /**
     *
     * @return
     */
    public String getGenre(){
        return genre;
    }
    
    /**
     *
     * @param genre
     */
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    /**
     *
     * @return
     */
    public Date getReleaseDate() {
        return releaseDate;
    }
    
    /**
     *
     * @param releaseDate
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    

    
}
