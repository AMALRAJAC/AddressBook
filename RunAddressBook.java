import java.util.*;

public class RunAddressBook {

    public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);

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

				        System.out.println(Fullname);
				        System.out.println(Address);
				        System.out.println(City);
				        System.out.println(State);
				        System.out.println(Zip);
				        System.out.println(Phone);
    }
    
}