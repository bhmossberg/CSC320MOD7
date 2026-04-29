package LibraryBookSorting;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Library {
   
   public static void fillLibraries(LinkedListLibrary linkedListLibrary, ArrayListLibrary arrayListLibrary) throws IOException {
      FileInputStream fileByteStream = null; // File input stream
      Scanner inFS = null;                   // Scanner object
      int linkedListOperations = 0;
      int arrayListOperations = 0;
      
      BookNode currNode;
      Book tempBook;
      
      String bookTitle;
      String bookAuthor;
      long bookISBN;
      
      // Try to open file
      fileByteStream = new FileInputStream("Books.txt");
      inFS = new Scanner(fileByteStream);

      while (inFS.hasNextLine()) {
         bookTitle = inFS.nextLine();
         bookISBN = inFS.nextLong();
         inFS.nextLine();
         bookAuthor = inFS.nextLine();
         
         // Insert into linked list
         currNode = new BookNode(bookTitle, bookAuthor, bookISBN);
         linkedListOperations = linkedListLibrary.insertSorted(currNode, linkedListOperations);
         linkedListLibrary.lastNode = currNode;
         
         // Insert into ArrayList
         tempBook = new Book(bookTitle, bookAuthor, bookISBN);
         arrayListOperations = arrayListLibrary.insertSorted(tempBook, arrayListOperations);
      }
      
      fileByteStream.close(); // close() may throw IOException if fails
   }
   
   /**
    * Main inserts a new book into each list using the respective 
    * LinkedListLibrary and ArrayListLibrary insertSorted() methods 
    * and outputting the number of operations the computer must 
    * perform to insert the new book. Each insertSorted() returns 
    * the number of operations the computer performs.
    * @param args
    * @throws IOException
    */
   public static void main (String[] args) throws IOException {
	      Scanner scnr = new Scanner(System.in);
	      
	      // Create libraries
	      LinkedListLibrary linkedListLibrary = new LinkedListLibrary();
	      ArrayListLibrary arrayListLibrary = new ArrayListLibrary();
	      
	      // Fill libraries with 100 books from Books.txt
	      fillLibraries(linkedListLibrary, arrayListLibrary);
	      
	      // === Read new book from user ===
	      String bookTitle = scnr.nextLine().trim();
	      long bookISBN = scnr.nextLong();
	      scnr.nextLine();                    // consume newline after nextLong()
	      String bookAuthor = scnr.nextLine().trim();
	       
	      // Insert into Linked List
	      BookNode currNode = new BookNode(bookTitle, bookAuthor, bookISBN);
	      int linkedListOperations = linkedListLibrary.insertSorted(currNode, 0);
	      linkedListLibrary.lastNode = currNode;
	      
	      // Insert into ArrayList
	      Book tempBook = new Book(bookTitle, bookAuthor, bookISBN);
	      int arrayListOperations = arrayListLibrary.insertSorted(tempBook, 0);
	      
	      // Output results
	      System.out.println("Number of linked list operations: " + linkedListOperations);
	      System.out.println("Number of ArrayList operations: " + arrayListOperations);
	      
	      scnr.close();
	   }
}
