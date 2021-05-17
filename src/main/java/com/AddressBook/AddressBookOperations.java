package com.AddressBook;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class AddressBookOperations {
     static  ArrayList<Contact>person=new ArrayList<>();
    public static void addArray(ArrayList<Contact> contactArrayList) {
        person=contactArrayList;
    }

    public enum IOServices{
        CONSOLE_IO,FILE_IO,DB_IO,REST_IO
    }
    //add contacts
    public static void addContacts(IOServices ioServices) throws IOException {
        if(ioServices.equals(IOServices.CONSOLE_IO)) {
            AddressBookConsole.addContactsToAddressBook(new Contact("personal", "amal", "akko",
                    "kozhi", "kera", 123, 9048, LocalDate.now()));
            AddressBookConsole.addContactsToAddressBook(new Contact("personal", "amma", "akko",
                    "kozhi", "kera", 123, 9048, LocalDate.now()));
            AddressBookConsole.addContactsToAddressBook(new Contact("Friends", "amarnadh", "akko",
                    "kozhi", "kera", 123, 9048, LocalDate.now()));
            AddressBookConsole.addContactsToAddressBook(new Contact("Friends", "anandhu", "akko",
                    "kozhi", "kera", 123, 9048, LocalDate.now()));
            AddressBookConsole.addContactsToAddressBook(new Contact("personal", "amal", "akko",
                    "kozhi", "kera", 123, 9048, LocalDate.now()));
            AddressBookConsole.addContactsToAddressBook(new Contact("personal", "amma", "akko",
                    "kozhi", "kera", 123, 9048, LocalDate.now()));
            AddressBookConsole.addContactsToTheHashMap();
        }
    }
    public static void modifyContacts(IOServices ioServices) throws IOException {
        if(ioServices.equals(IOServices.CONSOLE_IO)){
            AddressBookConsole.modifyContactsFromHashmap("amal","amalraj a c");
        }

    }
    public static void deleteContacts(IOServices ioServices) throws IOException {
        if(ioServices.equals(IOServices.CONSOLE_IO)){
            AddressBookConsole.deleteContactsFromHashMap("amalraj a c");
        }
    }
    public static void sortContactsInCity(IOServices ioServices) {
        if(ioServices.equals(IOServices.CONSOLE_IO)){
            AddressBookConsole.sortCityContactsinHashmap("kozhi","Friends");
        }
    }
    public static void sortContactsinState(IOServices ioServices) {
        if(ioServices.equals(IOServices.CONSOLE_IO)){
            AddressBookConsole.sortStateContactsinHashmap("kera","Friends");
        }
    }
    public static void writeIntoTextFile(IOServices ioServices) {
        if (ioServices.equals(IOServices.FILE_IO)){
            addressBookFile.writeData(AddressBookConsole.contactArrayList);
        }
    }
    public static void readFromTextFile(IOServices ioServices) {
        if (ioServices.equals(IOServices.FILE_IO)){
            addressBookFile.readData();
        }
    }
    public static void writeContactsIncsvFile(IOServices ioServices) throws IOException {
        if(ioServices.equals(IOServices.FILE_IO)){
            addressBookFile.WriteDataUsingCSVFile(AddressBookConsole.contactArrayList);
        }
    }
    public static void readContactsFromcsvFile(IOServices ioServices) {
        if(ioServices.equals(IOServices.FILE_IO)){
            addressBookFile.readDataUsingCSVFile();
        }
    }
    public static void writeContactstoJsonFile(IOServices ioServices) throws IOException {
        if(ioServices.equals(IOServices.FILE_IO)){
            addressBookFile.writeDataInToJsonFile(AddressBookConsole.contactArrayList);
        }
    }
    public static void readContactsfromJsonFile(IOServices ioServices) throws IOException {
        if(ioServices.equals(IOServices.FILE_IO)){
            addressBookFile.readDataUsingJsonFile();
        }
    }
    public static void addDataToDatabase(IOServices ioServices) throws SQLException {
        if(ioServices.equals(IOServices.DB_IO)){
            AddressBookDB.addContactsToDataBase(AddressBookConsole.contactArrayList);
        }
    }
    public static void retrievedataFromDatabase(IOServices ioServices) throws SQLException {
        if(ioServices.equals(IOServices.DB_IO)){
            AddressBookDB.showData();
        }
    }
    public static void addressbookoperations(IOServices ioServices) throws SQLException {
        if(ioServices.equals(IOServices.DB_IO)){
            AddressBookDB.modifyDatafromDatabase("amma","Baby");
            AddressBookDB.deleteDataFromDatabase("Baby");
        }
    }
    public static void ContactCount(IOServices ioServices) throws SQLException {
        if(ioServices.equals(IOServices.DB_IO)){
            AddressBookDB.getCountbycity("kozhi");
        }
    }
    public static void retrieveDataAccordingToDate(IOServices ioServices) {
        if(ioServices.equals(IOServices.DB_IO)){
            AddressBookDB.retrievedAccordingToDate();
        }
    }


}
