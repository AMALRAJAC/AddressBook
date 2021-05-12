package com.AddressBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {
    static ArrayList<Contact> contactArrayList = new ArrayList<>();
    static HashMap<String, ArrayList<Contact>> book = new HashMap<>();
    static HashMap<String, ArrayList<Contact>> CityMap = new HashMap<>();
    static HashMap<String, ArrayList<Contact>> StateMap = new HashMap<>();

    //adding contacts to addressbook
    public static void addContactsToAddressBook(Contact contact) {
        contactArrayList.add(contact);
    }

    //print all dats in arraylist
    public static void printContactsInArraylist() {
        for (Contact contact : contactArrayList) {
            System.out.println(contact);
        }
    }

    //return size of addressbook
    public static int sizeOfAddressBook() {
        return contactArrayList.size();
    }

    //to get the position of arraylist
    public static int getContactPosition(String Name) {
        for (int i = 0; i < contactArrayList.size(); i++) {
            if (contactArrayList.get(i).getFullname().equals(Name)) {
                return i;
            }
        }
        return -1;
    }

    //delete contacts from addressbook
    public static void deleteContactsFromTheAddressbook(String Name) {
        int index = getContactPosition(Name);
        if (index >= 0) {
            contactArrayList.remove(index);
        }

    }

    //modify contacts in addressbook
    public static void modifyContactsInAddressBook(String Name, String newName) {
        int index = getContactPosition(Name);
        if (index >= 0) {
            contactArrayList.get(index).setFullname(newName);
        }
    }

    //adding contacts to hashmap
    public static void addContactsToTheHashMap() throws IOException {
       contactArrayList= (ArrayList<Contact>) contactArrayList.stream().distinct().collect(Collectors.toList());
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

    //return the size of hashmap
    public static int getSizeOfHashMap() {
        return book.size();
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

    //get size of a single addressbook
    public static int getsizeOfContactsInHashmap(String book_name) {
        return book.get(book_name).size();
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
        List person=book.get(Book_name).stream().filter(e->e.getCity().equals(city_name)).collect(Collectors.toList());
        CityMap.put(city_name, (ArrayList<Contact>) person);
        System.out.println(CityMap);
    }
    public static int getCountByCity(String name){
        return CityMap.get(name).size();
    }
    public static int getCountByState(String name){
        return StateMap.get(name).size();
    }
    //sort contacts in state
    public static void sortStateContactsinHashmap(String state_name,String Book_name){
        List person=book.get(Book_name).stream().filter(e->e.getState().equals(state_name)).collect(Collectors.toList());
        StateMap.put(state_name, (ArrayList<Contact>) person);
        System.out.println(StateMap);
    }
}