
import javax.naming.Name;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    String Name_check = null;
    private ArrayList<Contact> friends; // An array of Contacts - each stores info for one friend
    private HashMap<String,ArrayList<Contact>>book=new HashMap<String,ArrayList<Contact>>();
    private HashMap<String,ArrayList<Contact>>city=new HashMap<String,ArrayList<Contact>>();
    private HashMap<String,ArrayList<Contact>>state=new HashMap<String,ArrayList<Contact>>();
    // Create an empty AddressBook
    public AddressBook() {
        friends = new ArrayList<Contact>();
    }

    // Add a contact that's passed in as a parameter.
    public void addContact(Contact contact) {
        Scanner sc = new Scanner(System.in);
        //enter the name of book
        System.out.println("enter the book name");
        String Name = sc.nextLine();
        //add contact to addressBook
        if (!book.keySet().contains(Name)) {
            friends.clear();
            book.put(Name, new ArrayList<Contact>());
            friends.add(contact);
            book.get(Name).addAll(friends);

        } else {
            friends.clear();
            friends.add(contact);
            book.get(Name).addAll(friends);
           List person = book.get(Name).stream().distinct().collect(Collectors.toList());
           book.get(Name).clear();
           book.get(Name).addAll(person);
        }

    }
    //contacts in city
    public void contactInCity(String name,String cityName ){
        city.clear();
        List person1 = book.get(name).stream().filter(e -> e.getCity().equals(cityName)).collect(Collectors.toList());
        System.out.println(person1);
        city.put(cityName, new ArrayList<Contact>());
        city.get(cityName).addAll(person1);
        System.out.println(city);
        System.out.println("total number of contacts in "+cityName+" is= "+city.get(cityName).size());
    }
    //contacts in state
    public void contactInState(String Name,String StateName ){
        List person1 = book.get(Name).stream().filter(e -> e.getCity().equals(StateName)).collect(Collectors.toList());
        System.out.println(person1);
        state.put(StateName, new ArrayList<Contact>());
        state.get(StateName).addAll(person1);
        System.out.println(state);
        System.out.println("total number of contacts in "+StateName+" is= "+state.get(StateName).size());
    }
    public void sortName(String Name){

        List < Contact > NameSortedList = book.get(Name).stream()
                .sorted((o1, o2) ->(int)(o1.getFullname().compareTo(o2.getFullname()))).collect(Collectors.toList()); //ascending order
        System.out.println(NameSortedList);

    }
    public void sortCity(String Name){

        List < Contact > NameSortedList = book.get(Name).stream()
                .sorted((o1, o2) ->(int)(o1.getCity().compareTo(o2.getCity()))).collect(Collectors.toList()); //ascending order
        System.out.println(NameSortedList);

    }
    public void sortState(String Name){

        List < Contact > NameSortedList = book.get(Name).stream()
                .sorted((o1, o2) ->(int)(o1.getState().compareTo(o2.getState()))).collect(Collectors.toList()); //ascending order
        System.out.println(NameSortedList);

    }
    public void sortZip(String Name){

        List < Contact > NameSortedList = book.get(Name).stream()
                .sorted((o1, o2) -> (int)(o1.getZip() - o2.getZip())).collect(Collectors.toList()); //ascending order
        System.out.println(NameSortedList);

    }

    // Print out info on all contacts using method Contact class.
    public void printContacts( ) {

        System.out.println(book);
    }

    // Returns the number of friends currently in AddressBook
    public int numContacts( String Name) {
        return book.get(Name).size();
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
        Scanner sc=new Scanner(System.in);
        friends.clear();
        int place = haveContact(s);
        System.out.println("enter the book name");
        String name=sc.nextLine();
        friends.addAll(book.get(name));
        if (book.keySet().contains(name)) {
            System.out.println("deleted");
            friends.remove(place);
        }
        book.replace(name, friends);
    }
    //modify contacts
    public void modifyContact(String s,int value) {
        Scanner sc=new Scanner(System.in);
        friends.clear();
        int place = haveContact(s);
        System.out.println("enter the book name");
        String name=sc.nextLine();
        friends.addAll(book.get(name));
        if (book.keySet().contains(name)) {
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
        book.replace(name, friends);
    }
}