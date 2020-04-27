package model;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;  

/**
 *
 * @author kiera
 */
public class TestSong {
    
    /**
     *
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        
        TrackList1<String> trackList = new TrackList1<>();       
        Song song = new Song();
        boolean inputError;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the track's ID: ");
        
        do {
        inputError = false;
        try {
        
        String id = userInput.nextLine();  
        song.setTrackId(Integer.parseInt(id));
        }
        catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Invalid ID value. Enter new value: ");
        }
        } while (inputError);
                          
        System.out.println("Please enter the track's title: ");
        String title = userInput.nextLine();        
        song.setTrackTitle(title);
        
        System.out.println("Please enter the track's lead artist: ");
        String artist = userInput.nextLine();        
        song.setArtist(artist);

        System.out.println("Please enter the track's length (in seconds): ");
        do {
        inputError = false;
        try {
        
        String trackLength = userInput.nextLine();        
        song.setTrackLength(Integer.parseInt(trackLength));
        }
        catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Invalid time value. Enter song length (in seconds): ");
        }
        } while (inputError);

        
        System.out.println("Please enter the track's composer: ");
        String composer = userInput.nextLine();        
        song.setComposer(composer);
        
        System.out.println("Please enter the track's release date in format 'dd/mm/yyyy': ");
        do {
        inputError = false;
        try {
        
        String releaseDate = userInput.nextLine();   
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(releaseDate);
        song.setReleaseDate(date);
        }
        catch (ParseException e) {
                inputError = true;
                System.out.println("Invalid date. Enter new value in format 'dd/mm/yyyy': ");
        }
        } while (inputError);
                
        System.out.println("Please enter the track's album title: ");
        String album = userInput.nextLine();        
        song.setAlbum(album);
        
        System.out.println("Please enter the track's genre: ");
        String genre = userInput.nextLine();        
        song.setGenre(genre);
 
        System.out.println("------------------");
        System.out.println("------------------");
        
        System.out.println("ID - "+song.getTrackId());      
        System.out.println("Title - "+song.getTrackTitle());  
        System.out.println("Artist - "+song.getArtist());  
        System.out.println("Length - "+song.getTrackLength()); 
        System.out.println("Composer - "+song.getComposer()); 
        System.out.println("Release Date - "+song.getReleaseDate()); 
        System.out.println("Album - "+song.getAlbum()); 
        System.out.println("Genre - "+song.getGenre()); 
        
        
        trackList.add(song.getTrackId(), song.getTrackTitle(), song.getArtist(), 
        song.getTrackLength(), song.getComposer(), song.getReleaseDate(), 
        song.getAlbum(), song.getGenre());
        
        trackList.add(2, "90210", "Travis Scott", 339,"Mike Dean", 
                new SimpleDateFormat("dd/MM/yyyy").parse("04/09/2015"), 
                "Rodeo", "Hip-Hop");        
        
        trackList.printList();
    }

}