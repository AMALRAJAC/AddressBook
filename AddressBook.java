import java.io.*;
import java.util.*;

public class AddressBook {
    private ArrayList<Contact> friends; // An array of Contacts - each stores info for one friend
    // Create an empty AddressBook
    public AddressBook() {
        friends = new ArrayList<Contact>();
    }

    // Add a contact that's passed in as a parameter.
    public void addContact(Contact contact) {
        	friends.add(contact);
        	
    }

    // Print out info on all contacts using method Contact class.
    public void printContacts() {
        for (int i=0;i<friends.size();i++) {
            System.out.println(friends.get(i));
        }
    }

    // Returns the number of friends currently in AddressBook
    public int numContacts() {
        return friends.size();
    }
         
    
}