package com.AddressBook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class addressBookTest {
    @Test
    public void addContactsToTheAddressBook_ShouldReturnSize() throws IOException, SQLException {

        AddressBook.addContactsToAddressBook(new Contact("personal","amal","akko","kozhi","kera",123,9048, LocalDate.now()));
        AddressBook.addContactsToAddressBook(new Contact("personal","amma","akko","kozhi","kera",123,9048,LocalDate.now()));
        AddressBook.addContactsToAddressBook(new Contact("Friends","amarnadh","akko","kozhi","kera",123,9048,LocalDate.now()));
        AddressBook.addContactsToAddressBook(new Contact("Friends","anandhu","akko","kozhi","kera",123,9048,LocalDate.now()));
        AddressBook.addContactsToAddressBook(new Contact("personal","amal","akko","kozhi","kera",123,9048,LocalDate.now()));
        AddressBook.addContactsToAddressBook(new Contact("personal","amma","akko","kozhi","kera",123,9048,LocalDate.now()));
        AddressBook.addContactsToAddressBook(new Contact("Friends","amarnadh","akko","kozhi","kera",123,9048,LocalDate.now()));
        AddressBook.addContactsToAddressBook(new Contact("Friends","anandhu","akko","kozhi","kera",123,9048,LocalDate.now()));
        int size=AddressBook.sizeOfAddressBook();
        AddressBook.printContactsInArraylist();
        Assertions.assertEquals(8,size);
        AddressBook.addContactsToTheHashMap();
        AddressBookIO.writeData(AddressBook.contactArrayList);
        AddressBookIO.readData();
        AddressBookIO.WriteDataUsingCSVFile(AddressBook.contactArrayList);
        AddressBookIO.readDataUsingCSVFile();
        AddressBookIO.writeDataInToJsonFile(AddressBook.contactArrayList);
        AddressBookIO.readDataUsingJsonFile();
        AddressBookDB.addContactsToDataBase(AddressBook.contactArrayList);
        int size1=AddressBook.getSizeOfHashMap();
        Assertions.assertEquals(2,size1);
    }
    @Test
    public void deleteContactsFromTheHashMap_ShouldReturnSize() throws IOException, SQLException {
        AddressBook.deleteContactsFromHashMap("amal");
        AddressBookIO.writeData(AddressBook.contactArrayList);
        AddressBookIO.readData();
        AddressBookIO.WriteDataUsingCSVFile(AddressBook.contactArrayList);
        AddressBookIO.readDataUsingCSVFile();
        AddressBookIO.writeDataInToJsonFile(AddressBook.contactArrayList);
        AddressBookIO.readDataUsingJsonFile();
        AddressBookDB.deleteDataFromDatabase("amal");
        int size=AddressBook.getsizeOfContactsInHashmap("personal");
        Assertions.assertEquals(1,size);
    }
    @Test
    public void modifyContactsInHashMap_ShouldReturnSize() throws IOException {
        AddressBook.modifyContactsFromHashmap("anandhu","amalraj");
        AddressBookIO.writeData(AddressBook.contactArrayList);
        AddressBookIO.readData();
        AddressBookIO.WriteDataUsingCSVFile(AddressBook.contactArrayList);
        AddressBookIO.readDataUsingCSVFile();
        AddressBookIO.writeDataInToJsonFile(AddressBook.contactArrayList);
        AddressBookIO.readDataUsingJsonFile();
        AddressBookDB.modifyDatafromDatabase("anandhu","amalraj");
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

}
