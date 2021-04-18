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

    // Returns a non-neg integer if a Contact with name s exists corresponding
    // to which place in the array friends the Contact is stored. Returns -1
    // otherwise.
    private int haveContact(String s) {
        for (int i=0;i<friends.size();i++)
            if (friends.get(i).getFullname().equals(s))
                return i;
        return 0;
    }

    // Deletes a contact with name s, if one is in the AddressBook.
    public void deleteContact(String s) {
        int place = haveContact(s);
        if (place>=0) {
            friends.remove(place);
        }
    }
    public void modifyContact(String s,int value) {
    	Scanner sc=new Scanner(System.in);
        int place = haveContact(s);
        if (place>=0) {
        	final int modify_name=1;
        	final int modify_address=2;
        	final int modify_city=3;
        	final int modify_state=4;
        	final int modify_zip=5;
        	final int modify_phone=6;
            switch(value) {
            
            case modify_name:
            	System.out.println("enter name");
            	friends.get(place).setFullname(sc.nextLine());
            	break;
            case modify_address:
            	System.out.println("enter address");
            	friends.get(place).setAddress(sc.nextLine());
            	break;
            case modify_city:
            	System.out.println("enter city");
            	friends.get(place).setCity(sc.nextLine());
            	break;
            case modify_state:
            	System.out.println("enter State");
            	friends.get(place).setState(sc.nextLine());
            	break;
            case modify_zip:
            	System.out.println("enter Zip");
            	friends.get(place).setZip(sc.nextInt());
            	break;
            case modify_phone:
            	System.out.println("enter phone number");
            	friends.get(place).setPhone(sc.nextInt());
            	break;
            default:
            	System.out.println("enter the correct input");
            	break;
            
            }
         }
    }
}