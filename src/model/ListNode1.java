package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author kiera
 * @param <T>
 */
public class ListNode1<T> {
    int trackId;
    String trackTitle;
    String artist;
    int trackLength;
    String composer;
    String album;
    String genre;
    Date releaseDate;
    ListNode1 next;

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
    public ListNode1(int trackId, String trackTitle, String artist, 
            int trackLength, String composer, Date releaseDate,
            String album, String genre) { 
        
        this.trackId = trackId;
        this.trackTitle = trackTitle;
        this.artist = artist;
        this.trackLength = trackLength;
        this.composer = composer;
        this.releaseDate = releaseDate;
        this.album = album;
        this.genre = genre;
    }
    
    /**
     *
     */
    public void display() {
 
        System.out.println("------------------");
        System.out.println("------------------");
        
        System.out.println("ID - "+trackId); 
        System.out.println("Title - "+trackTitle);  
        System.out.println("Artist - "+artist);  
        System.out.println("Length - "+trackLength); 
        System.out.println("Composer - "+composer); 
        System.out.println("Release Date - "+releaseDate); 
        System.out.println("Album - "+album); 
        System.out.println("Genre - "+genre); 
        
    }
    
    /**
     *
     * @param trackList
     */
    public static void findArtist(TrackList1 trackList) {
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("Search for artist 'Thundercat'");
        
        System.out.println("ID - "+trackList.findArtist("Thundercat").trackId);
        System.out.println("Title - "+trackList.findArtist("Thundercat").trackTitle);
        System.out.println("Artist - "+trackList.findArtist("Thundercat").artist);
        System.out.println("Length - "+trackList.findArtist("Thundercat").trackLength);
        System.out.println("Composer - "+trackList.findArtist("Thundercat").composer);
        System.out.println("Release Date - "+trackList.findArtist("Thundercat").releaseDate);
        System.out.println("Album - "+trackList.findArtist("Thundercat").album);
        System.out.println("Genre - "+trackList.findArtist("Thundercat").genre);        
        System.out.println("------------------");
        System.out.println("------------------");
    }

    /**
     *
     * @param trackList
     */
    public static void findTitle(TrackList1 trackList) {
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("Search for title 'Speakerbox'");
        

        System.out.println("ID - "+trackList.findTitle("Speakerbox").trackId);
        System.out.println("Title - "+trackList.findTitle("Speakerbox").trackTitle);
        System.out.println("Artist - "+trackList.findTitle("Speakerbox").artist);
        System.out.println("Length - "+trackList.findTitle("Speakerbox").trackLength);
        System.out.println("Composer - "+trackList.findTitle("Speakerbox").composer);
        System.out.println("Release Date - "+trackList.findTitle("Speakerbox").releaseDate);
        System.out.println("Album - "+trackList.findTitle("Speakerbox").album);
        System.out.println("Genre - "+trackList.findTitle("Speakerbox").genre);        
        System.out.println("------------------");
        System.out.println("------------------");    
    }
    
    /**
     *
     * @param trackList
     */
    public static void findGenre(TrackList1 trackList) {
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("Search for genre 'Hip-Hop'");
        
        System.out.println("ID - "+trackList.findGenre("Hip-Hop").trackId);
        System.out.println("Title - "+trackList.findGenre("Hip-Hop").trackTitle);
        System.out.println("Artist - "+trackList.findGenre("Hip-Hop").artist);
        System.out.println("Length - "+trackList.findGenre("Hip-Hop").trackLength);
        System.out.println("Composer - "+trackList.findGenre("Hip-Hop").composer);
        System.out.println("Release Date - "+trackList.findGenre("Hip-Hop").releaseDate);
        System.out.println("Album - "+trackList.findGenre("Hip-Hop").album);
        System.out.println("Genre - "+trackList.findGenre("Hip-Hop").genre);
        
        System.out.println("------------------");
        System.out.println("------------------");
    }

    /**
     *
     * @param trackList
     * @throws ParseException
     */
    public static void add(TrackList1 trackList) throws ParseException {
               
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
        
        trackList.add(song.getTrackId(), song.getTrackTitle(), song.getArtist(), 
        song.getTrackLength(), song.getComposer(), song.getReleaseDate(), 
        song.getAlbum(), song.getGenre());
        
        System.out.println("ID - "+song.getTrackId());      
        System.out.println("Title - "+song.getTrackTitle());  
        System.out.println("Artist - "+song.getArtist());  
        System.out.println("Length - "+song.getTrackLength()); 
        System.out.println("Composer - "+song.getComposer()); 
        System.out.println("Release Date - "+song.getReleaseDate()); 
        System.out.println("Album - "+song.getAlbum()); 
        System.out.println("Genre - "+song.getGenre());
        
        
    }
    
    /**
     *
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String choice;
        TrackList1<String> trackList = new TrackList1<>();
        trackList.add(2, "Come Home", "Anderson .Paak", 267,"J. Mo", 
                new SimpleDateFormat("dd/MM/yyyy").parse("12/04/2019"), 
                "Ventura", "R&B");         
        
        trackList.add(3, "90210", "Travis Scott", 339,"Mike Dean", 
                new SimpleDateFormat("dd/MM/yyyy").parse("04/09/2015"), 
                "Rodeo", "Hip-Hop"); 
        
        trackList.add(4, "Speakerbox", "Wiley", 192,"Wiley", 
                new SimpleDateFormat("dd/MM/yyyy").parse("13/01/2017"), 
                "Godfather", "Grime");
        
        trackList.add(5, "Antidote", "Travis Scott", 263,"Mike Dean", 
                new SimpleDateFormat("dd/MM/yyyy").parse("29/07/2015"), 
                "Rodeo", "Hip-Hop");         
        
        trackList.add(6, "Pick Up The Phone", "Travis Scott", 252,"Vinylz", 
                new SimpleDateFormat("dd/MM/yyyy").parse("03/06/2016"), 
                "Birds In The Trap Sing McKnight", "Hip-Hop"); 
        
        trackList.add(7, "C.R.E.A.M", "The Wu-Tang Clan", 252,"RZA", 
                new SimpleDateFormat("dd/MM/yyyy").parse("09/11/1993"), 
                "Enter The Wu-Tang", "Hip-Hop");
        
        trackList.add(8, "Heartless", "The Weeknd", 198,"Metro Boomin", 
                new SimpleDateFormat("dd/MM/yyyy").parse("27/11/2019"), 
                "After Hours", "R&B");         
        
        trackList.add(9, "Peach", "Kevin Abstract", 177,"Romil Hemnani", 
                new SimpleDateFormat("dd/MM/yyyy").parse("25/04/2019"), 
                "ARIZONA BABY", "Pop"); 
        
        trackList.add(10, "November Has Come", "Gorillaz", 161,"Danger Mouse", 
                new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2005"), 
                "Demon Days", "Alternative");
        
        trackList.add(11, "Fair Chance", "Thundercat", 238,"Flying Lotus", 
                new SimpleDateFormat("dd/MM/yyyy").parse("17/03/2020"), 
                "It Is What It Is", "R&B");         
        
        trackList.add(12, "Long Time (Intro)", "Playboi Carti", 202,"Art Dealer", 
                new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2018"), 
                "Die Lit", "Hip-Hop"); 
        
        Boolean allDone = false;

        // here we go
        while (!allDone) {
            if (!allDone) {
                System.out.print("Choose one of the options: 1: find by artist 'Thundercat', 2: find song 'Speakerbox',\n"
                        + "3: find genre 'Hip-Hop', 4: add track to list, 5: display list"
                        + " 6: quit ->");
                choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        findArtist(trackList);
                        break;
                    case "2":
                        findTitle(trackList);
                        break;
                    case "3":
                        findGenre(trackList);
                        break;
                    case "4":
                        add(trackList);
                        break;
                    case "5":
                        System.out.println("Current stack status ->");
                        trackList.printList();
                        break;
                    case "6":
                        System.out.println("Application closed.");
                        allDone = true;
                        break;
                    default: // invalid option
                        break;
                }
            }
        }
    }
}   

