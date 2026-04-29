package PlaylistLinkedList;
import java.util.Scanner;

public class Playlist {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SongEntry head = null; //init head
	    SongEntry tail = null; //init tail
	    SongEntry currSong;
		System.out.println("Enter playlist's title:");
		System.out.println();
		String playlistTitle = sc.nextLine().strip();
		while (true) {
            char choice = printMenu(playlistTitle, sc);     // ← Pass the Scanner here
            switch (choice) {
            	case 'a' :
            		SongEntry[] addResult = addSong(sc, head, tail);
                    head = addResult[0];
                    tail = addResult[1];
                    break;
            	case 'd' : 
            		//System.out.println("Remove song");
            		SongEntry[] removeResult = removeSong(sc, head, tail);
            	    head = removeResult[0];
            	    tail = removeResult[1];
            	    break;
            	case 'c' : 
            		//System.out.println("Change position of song");
            		SongEntry[] changeResult = changePosition(sc, head, tail);
            	    head = changeResult[0];
            	    tail = changeResult[1];
            		break;
            	case 's':
                    outputSongsByArtist(sc, head);
                    break;
                case 't':
                    outputTotalTime(head);
                    break;
            	case 'o' : 
            		//System.out.println("Output full playlist");
            		outputFullPlaylist(head, playlistTitle);
	            	break;
            	case 'q' : 
            		break;
            }
            if (choice == 'q') {
                break;
            }
        }
	}
	public static char printMenu(String title, Scanner sc) {
		System.out.printf("%s PLAYLIST MENU%n", title);
		System.out.println("a - Add song");
		System.out.println("d - Remove song");
		System.out.println("c - Change position of song");
		System.out.println("s - Output songs by specific artist");
		System.out.println("t - Output total time of playlist (in seconds)");
		System.out.println("o - Output full playlist");
		System.out.println("q - Quit");
		System.out.println();
		System.out.println("Choose an option:");
		String input = sc.nextLine().trim(); 
		return Character.toLowerCase(input.charAt(0));
	}
	public static SongEntry[] addSong(Scanner sc, SongEntry head, SongEntry tail) {
        System.out.println("\nADD SONG");

        System.out.println("Enter song's unique ID:");
        String uniqueID = sc.nextLine().trim();

        System.out.println("Enter song's name:");
        String songName = sc.nextLine().trim();

        System.out.println("Enter artist's name:");
        String artistName = sc.nextLine().trim();

        System.out.println("Enter song's length (in seconds):");
        int songLength = sc.nextInt();
        sc.nextLine(); // consume the leftover newline

        // Create new song
        SongEntry newSong = new SongEntry(uniqueID, songName, artistName, songLength);

        // Insert into linked list
        if (head == null) {
            head = newSong;
            tail = newSong;
        } else {
            tail.insertAfter(newSong);
            tail = newSong;
        }

        System.out.println();

        // Return updated head and tail
        return new SongEntry[]{head, tail};
    }

    public static void outputFullPlaylist(SongEntry head, String title) {
        System.out.printf("%s - OUTPUT FULL PLAYLIST%n", title.toUpperCase());

        if (head == null) {
            System.out.println("Playlist is empty");
            System.out.println();
            return;
        }

        SongEntry curr = head;
        int position = 1;

        while (curr != null) {
            System.out.printf("%d.%n", position);
            curr.printPlaylistSongs();
            System.out.println();
            curr = curr.getNext();
            position++;
        }
    }
    public static SongEntry[] removeSong(Scanner sc, SongEntry head, SongEntry tail) {
        System.out.println("\nREMOVE SONG");
        System.out.println("Enter song's unique ID:");
        String targetID = sc.nextLine().trim();

        if (head == null) {
            System.out.println("Playlist is empty.");
            return new SongEntry[]{head, tail};
        }

        SongEntry curr = head;
        SongEntry prev = null;
        boolean found = false;

        while (curr != null) {
            if (curr.getID().equals(targetID)) {
                found = true;
                
                String songName = curr.getSongName();

                // Case 1: Removing the head
                if (prev == null) {
                    head = curr.getNext();
                } 
                // Case 2: Removing a middle or tail node
                else {
                    prev.setNext(curr.getNext());
                }

                // Update tail if we removed the last node
                if (curr == tail) {
                    tail = prev;
                }

                System.out.println("\"" + songName + "\" removed.");
                break;
            }

            prev = curr;
            curr = curr.getNext();
        }

        if (!found) {
            System.out.println("Song with ID \"" + targetID + "\" not found.");
        }

        System.out.println();
        return new SongEntry[]{head, tail};
    }
    public static SongEntry[] changePosition(Scanner sc, SongEntry head, SongEntry tail) {
        System.out.println("\nCHANGE POSITION OF SONG");

        // Count total songs
        int totalSongs = 0;
        SongEntry temp = head;
        while (temp != null) {
            totalSongs++;
            temp = temp.getNext();
        }

        if (totalSongs == 0) {
            System.out.println("Playlist is empty.");
            return new SongEntry[]{head, tail};
        }

        System.out.println("Enter song's current position:");
        int currPos = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter new position for song:");
        int newPos = sc.nextInt();
        sc.nextLine(); // consume newline

        // Clamp newPos to valid range
        if (newPos < 1) newPos = 1;
        if (newPos > totalSongs) newPos = totalSongs;

        if (currPos == newPos) {
            System.out.println("Song is already at that position.");
            return new SongEntry[]{head, tail};
        }

        // Find the song to move and its previous node
        SongEntry curr = head;
        SongEntry prev = null;
        int count = 1;

        while (curr != null && count < currPos) {
            prev = curr;
            curr = curr.getNext();
            count++;
        }

        if (curr == null) {
            System.out.println("Invalid current position.");
            return new SongEntry[]{head, tail};
        }

        String songName = curr.getSongName();

        // Remove the node from current position
        if (prev == null) {           // Removing head
            head = curr.getNext();
        } else {
            prev.setNext(curr.getNext());
        }

        // Update tail if we removed the last node
        if (curr == tail) {
            tail = prev;
        }

        // Now insert the node at new position
        if (newPos == 1) {            // Move to head
            curr.setNext(head);
            head = curr;
        } else {
            // Find the node before the new position
            SongEntry insertPrev = head;
            for (int i = 1; i < newPos - 1; i++) {
                insertPrev = insertPrev.getNext();
            }
            curr.setNext(insertPrev.getNext());
            insertPrev.setNext(curr);

            // Update tail if inserted at the end
            if (curr.getNext() == null) {
                tail = curr;
            }
        }

        System.out.println("\"" + songName + "\" moved to position " + newPos);
        System.out.println();

        return new SongEntry[]{head, tail};
    }

    public static void outputSongsByArtist(Scanner sc, SongEntry head) {
        System.out.println("\nOUTPUT SONGS BY SPECIFIC ARTIST");
        System.out.println("Enter artist's name:");
        String artist = sc.nextLine().trim();

        if (head == null) {
            System.out.println("Playlist is empty.");
            System.out.println();
            return;
        }

        SongEntry curr = head;
        int position = 1;
        boolean found = false;

        while (curr != null) {
            if (curr.getArtistName().equalsIgnoreCase(artist)) {
                System.out.printf("%d.%n", position);
                curr.printPlaylistSongs();
                System.out.println();
                found = true;
            }
            curr = curr.getNext();
            position++;
        }

        if (!found) {
            System.out.println("No songs found for artist: \"" + artist + "\"");
            System.out.println();
        }
    }
    public static void outputTotalTime(SongEntry head) {
        System.out.println("\nOUTPUT TOTAL TIME OF PLAYLIST (IN SECONDS)");

        if (head == null) {
            System.out.println("Total time: 0 seconds");
            System.out.println();
            return;
        }

        int totalSeconds = 0;
        SongEntry curr = head;

        while (curr != null) {
            totalSeconds += curr.getSongLength();
            curr = curr.getNext();
        }

        System.out.println("Total time: " + totalSeconds + " seconds");
        System.out.println();
    }
}
