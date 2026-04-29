import java.util.Scanner;

public class ContactList {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        ContactNode head = null;
        ContactNode tail = null;
        ContactNode currNode;
        final int MAX_CONTACTS = 3;
        
        for (int i = 1; i <= MAX_CONTACTS; i++) {
            System.out.println("Person " + i);
            
            System.out.println("Enter name:");
            String name = scnr.nextLine();
            
            System.out.println("Enter phone number:");
            String phone = scnr.nextLine(); 	
            
            System.out.println("You entered: " + name + ", " + phone);
            System.out.println();
            
            currNode = new ContactNode(name, phone);
            
            if (head == null) {
                head = currNode;
                tail = currNode;
            } else {
                tail.insertAfter(currNode);
                tail = currNode;
            }
        }

        System.out.println("CONTACT LIST");
        currNode = head;
        while (currNode != null) {
            currNode.printContactNode();
            currNode = currNode.getNext();
        }

        
        scnr.close();
    }
}