package PlaylistLinkedList;
public class SongEntry {
	private String uniqueID; //Initialized to "none" in default constructor
	private String songName; //Initialized to "none" in default constructor
	private String artistName; //Initialized to "none" in default constructor
	private int songLength; //Initialized to 0 in default constructor
	private SongEntry nextNode; //Initialized to null in default constructor

	//Default constructor
	public SongEntry() {
		this.uniqueID = "none";
		this.songName = "none";
		this.artistName = "none";
		this.songLength = 0;
		this.nextNode = null;
	}
	//Parameterized constructor
	public SongEntry(String uniqueID, String songName, String artistName, int songLength) {
		this.uniqueID = uniqueID;
		this.songName = songName;
		this.artistName = artistName;
		this.songLength = songLength;
		this.nextNode = null; //pointer should initialize as null
	}
	void insertAfter(SongEntry currNode) {
		SongEntry tmpNext = this.nextNode;   // Remember current next
        this.nextNode = currNode;               // Point to new node
        currNode.nextNode = tmpNext;            // New node points to old next
		
	}
	void setNext(SongEntry nextNode) {
		this.nextNode = nextNode;
	}
	String getID() {
		return this.uniqueID;
	}
	String getSongName() {
		return this.songName;
	}
	String getArtistName() {
		return this.artistName;
	}
	int getSongLength() {
		return this.songLength;
	}
	SongEntry getNext() {
		return this.nextNode;
	}
	void printPlaylistSongs() {
		System.out.println("Unique ID: " + this.uniqueID);
		System.out.println("Song Name: " + this.songName);
		System.out.println("Artist Name: " + this.artistName);
		System.out.println("Song Length (in seconds): " + this.songLength);
	}
}