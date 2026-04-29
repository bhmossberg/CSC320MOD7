public class ContactNode {
    private String contactName;
    private String contactPhoneNumber;
    private ContactNode nextNodePtr;


    public ContactNode(String name, String phoneNumber) {
        this.contactName = name;
        this.contactPhoneNumber = phoneNumber;
        this.nextNodePtr = null;
    }

    // Accessor methods
    public String getName() {
        return this.contactName;
    }

    public String getPhoneNumber() {
        return this.contactPhoneNumber;
    }

    public ContactNode getNext() {
        return this.nextNodePtr;
    }

    // Insert node after this node
    public void insertAfter(ContactNode newNode) {
        ContactNode tmpNext = this.nextNodePtr;   // Remember current next
        this.nextNodePtr = newNode;               // Point to new node
        newNode.nextNodePtr = tmpNext;            // New node points to old next
    }

    // Print contact information
    public void printContactNode() {
        System.out.println("Name: " + contactName);
        System.out.println("Phone number: " + contactPhoneNumber);
        System.out.println();
    }
}