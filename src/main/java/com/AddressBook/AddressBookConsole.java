package com.AddressBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBookConsole {
    static ArrayList<Contact> contactArrayList = new ArrayList<>();
    static ArrayList<Contact> person = new ArrayList<>();
    static HashMap<String, ArrayList<Contact>> book = new HashMap<>();
    static HashMap<String, ArrayList<Contact>> CityMap = new HashMap<>();
    static HashMap<String, ArrayList<Contact>> StateMap = new HashMap<>();

    //adding contacts to addressbook
    public static void addContactsToAddressBook(Contact contact) {
        contactArrayList.add(contact);
    }
    //adding contacts to hashmap
    public static void addContactsToTheHashMap() {
        contactArrayList= (ArrayList<Contact>) contactArrayList.stream().distinct().collect(Collectors.toList());
        setArray(contactArrayList);
        for (int i = 0; i < contactArrayList.size(); i++) {
            String book_name = contactArrayList.get(i).getBook_name();
            if (book.keySet().contains(book_name)) {
                book.get(book_name).add(contactArrayList.get(i));
            } else {
                book.put(book_name, new ArrayList<>());
                book.get(book_name).add(contactArrayList.get(i));
            }
        }
        System.out.println(book);
    }

    //delete contacts from the hashmap
    public static void deleteContactsFromHashMap(String name) throws IOException {
        int index = getContactPosition(name);
        if (index >= 0) {
            contactArrayList.remove(index);
        }
        book.clear();
        addContactsToTheHashMap();
    }
    //modify contacts in hashmap
    public static void modifyContactsFromHashmap(String name, String new_name) throws IOException {
        int index = getContactPosition(name);
        if (index >= 0) {
            contactArrayList.get(index).setFullname(new_name);
        }
        book.clear();
        addContactsToTheHashMap();
    }

    //sort contacts in city
    public static void sortCityContactsinHashmap(String city_name,String Book_name){
        List person=book.get(Book_name).stream().filter(e->e.getCity().equals(city_name))
                                                .collect(Collectors.toList());
        CityMap.put(city_name, (ArrayList<Contact>) person);
        System.out.println(CityMap);
    }
    //sort contacts in state
    public static void sortStateContactsinHashmap(String state_name,String Book_name){
        List person=book.get(Book_name).stream().filter(e->e.getState().equals(state_name))
                                                .collect(Collectors.toList());
        StateMap.put(state_name, (ArrayList<Contact>) person);
        System.out.println(StateMap);
    }
    //taking count of contacts in city
    public static long getCountByCity(String name){
        return CityMap.get(name).stream().count();
    }
    //taking count of contacts in state
    public static long getCountByState(String name){
        return StateMap.get(name).stream().count();
    }
    //to get the position of arraylist
    private static int getContactPosition(String Name) {
        for (int i = 0; i < contactArrayList.size(); i++) {
            if (contactArrayList.get(i).getFullname().equals(Name)) {
                return i;
            }
        }
        return -1;
    }
    //return the number of addressbooks
    public static int getSizeOfHashMap() {
        return book.size();
    }
    public static void setArray(ArrayList<Contact> contactArrayList) {
        AddressBookOperations.addArray(contactArrayList);
    }
}