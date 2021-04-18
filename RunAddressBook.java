import java.util.*;

public class RunAddressBook {

    public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);

		// Instantiate AddressBook object
		AddressBook blackbook = new AddressBook();

 		// Menu driven loop.
		menu();
		int choice = stdin.nextInt();
		while (choice!=6) {

	    	// Only adds contact if there is room in AddressBook blackbook.
	    	if (choice == 1) {
				if (blackbook.numContacts() < 10) {

					 System.out.print("\nEnter Fullname: ");
				        String Fullname1=stdin.nextLine();
				        String Fullname=stdin.nextLine();
				        
				        System.out.print("Enter Address: ");
				        String Address=(stdin.nextLine());

				        System.out.print("Enter City: ");
				        String City=(stdin.nextLine());

				        System.out.print("Enter State: ");
				        String State=(stdin.nextLine());

				        System.out.print("Enter Zip: ");
				        int Zip=(stdin.nextInt());

				        System.out.print("Enter Phone Number: ");
				        int Phone=(stdin.nextInt());


		    		// Uses information to create Contact object, which is
		    		// a parameter to the addContact method.
		    		blackbook.addContact(new Contact( Fullname,Address, City, State,Zip,Phone));
				}
				else
		    		System.out.println("Sorry, can not add anyone, your blackbook is full.");
	    	}

	    	// Implements rest of the choices by calling appropriate AddressBook methods on blackbook.
	    	else if (choice == 2) {
				System.out.println("What is the name of the contact you want to delete?");
				String name = stdin.next();
				blackbook.deleteContact(name);
	    	}
	    	else if (choice == 3) {
	    		System.out.println("What is the name of the contact you want to modify?");
				System.out.println("Enter your friend\'s name:");
				String name = stdin.next();
				System.out.println("1.modify name\n2.modify address\n3.modify city\n4.modify state\n5.modify zip\n6.phone number");
	    		int value = stdin.nextInt();
	    		blackbook.modifyContact(name,value);
	    	}
	    	else if (choice == 4) {
	    		System.out.println("You have " + blackbook.numContacts() + " contacts.");
	    	}
	    	else if (choice == 5) {
	    		blackbook.printContacts();
	    			    	}
	    	else if(choice !=6) {
				System.out.println("Sorry, that was an invalid menu choice, try again.");
			 }
			menu();
	    	choice = stdin.nextInt();
		}
    }

    public static void menu() {
		System.out.println("1.Add a new contact to your address book.");
		System.out.println("2.Delete a contact from your address book.");
		System.out.println("3.modify contact in your addressbook.");
		System.out.println("4.Print out the number of contacts you have.");
		System.out.println("5.Print out information of all of your contacts.");
		System.out.println("6.Quit.");
		System.out.println("Enter your menu choice:");
    }
}