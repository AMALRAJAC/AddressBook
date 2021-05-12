package com.AddressBook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

public class addressBookTest {
    @Test
    public void addContactsToTheAddressBook_ShouldReturnSize(){

        AddressBook.addContactsToAddressBook(new Contact("personal","amal","akko","kozhi","kera",123,9048));
        AddressBook.addContactsToAddressBook(new Contact("personal","amma","akko","kozhi","kera",123,9048));
        AddressBook.addContactsToAddressBook(new Contact("Friends","amarnadh","akko","kozhi","kera",123,9048));
        AddressBook.addContactsToAddressBook(new Contact("Friends","anandhu","akko","kozhi","kera",123,9048));
        AddressBook.addContactsToAddressBook(new Contact("personal","amal","akko","kozhi","kera",123,9048));
        AddressBook.addContactsToAddressBook(new Contact("personal","amma","akko","kozhi","kera",123,9048));
        AddressBook.addContactsToAddressBook(new Contact("Friends","amarnadh","akko","kozhi","kera",123,9048));
        AddressBook.addContactsToAddressBook(new Contact("Friends","anandhu","akko","kozhi","kera",123,9048));
        int size=AddressBook.sizeOfAddressBook();
       // System.out.println("////print contacts////");
        AddressBook.printContactsInArraylist();
        Assertions.assertEquals(8,size);
    }
    @Test
    public void addContactsToTheHashMap_ShouldReturnSize() throws IOException {
        AddressBook.addContactsToTheHashMap();
        int size=AddressBook.getSizeOfHashMap();
        Assertions.assertEquals(2,size);
    }
    @Test
    public void deleteContactsFromTheHashMap_ShouldReturnSize() throws IOException {
        AddressBook.deleteContactsFromHashMap("amal");
        int size=AddressBook.getsizeOfContactsInHashmap("personal");
        Assertions.assertEquals(1,size);
    }
    @Test
    public void modifyContactsInHashMap_ShouldReturnSize() throws IOException {
        AddressBook.modifyContactsFromHashmap("anandhu","amalraj");
        int size=AddressBook.getsizeOfContactsInHashmap("Friends");
        Assertions.assertEquals(2,size);
    }
    @Test
    public void sortCityContactsInHashmap_shouldReturnSize(){
        AddressBook.sortCityContactsinHashmap("kozhi","personal");
        int size=AddressBook.getCountByCity("kozhi");
        Assertions.assertEquals(1,size);
    }
    @Test
    public void sortStateContactsInHashmap_ShouldReturnSize(){
        AddressBook.sortStateContactsinHashmap("kera","personal");
        int size=AddressBook.getCountByState("kera");
        Assertions.assertEquals(1,size);
    }
    @Test
    public  void readAndWriteToFile_ShouldReturnSize(){
        AddressBookIO.writeData(AddressBook.contactArrayList);
        AddressBookIO.readData();
       // AddressBookIO.printData();
        long count=AddressBookIO.countEntries();
        System.out.println(count);
        Assertions.assertEquals(3,count);
    }
    @Test
    public  void readAndWriteToCSVFile_ShouldReturnSize(){
        AddressBookIO.WriteDataUsingCSVFile(AddressBook.contactArrayList);
        AddressBookIO.readDataUsingCSVFile();
        // AddressBookIO.printData();
        long count=AddressBookIO.countcsvEntries();
        System.out.println(count);
        Assertions.assertEquals(3,count);
    }
    @Test
    public  void readAndWriteTojsonFile_ShuldReturnSize() throws IOException {
        AddressBookIO.writeDataInToJsonFile(AddressBook.contactArrayList);
       AddressBookIO.readDataUsingJsonFile();
    }


}
