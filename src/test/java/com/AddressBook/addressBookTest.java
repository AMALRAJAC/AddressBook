package com.AddressBook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class addressBookTest {
    @Test
    public void addressBookConsoleOperation() throws IOException {
        AddressBookOperations.addContacts(AddressBookOperations.IOServices.CONSOLE_IO);
        AddressBookOperations.modifyContacts(AddressBookOperations.IOServices.CONSOLE_IO);
        AddressBookOperations.deleteContacts(AddressBookOperations.IOServices.CONSOLE_IO);
        int size1=AddressBookConsole.getSizeOfHashMap();
        Assertions.assertEquals(2,size1);
        AddressBookOperations.sortContactsInCity(AddressBookOperations.IOServices.CONSOLE_IO);
        long size2=AddressBookConsole.getCountByCity("kozhi");
        Assertions.assertEquals(2,size2);
        AddressBookOperations.sortContactsinState(AddressBookOperations.IOServices.CONSOLE_IO);
        long size3=AddressBookConsole.getCountByState("kera");
        Assertions.assertEquals(2,size3);
    }
   @Test
    public void addressBookFileOperations() throws IOException {
        AddressBookOperations.addContacts(AddressBookOperations.IOServices.CONSOLE_IO);
        AddressBookOperations.writeIntoTextFile(AddressBookOperations.IOServices.FILE_IO);
        AddressBookOperations.readFromTextFile(AddressBookOperations.IOServices.FILE_IO);
        long count=addressBookFile.countEntries();
        Assertions.assertEquals(4,count);
        AddressBookOperations.writeContactsIncsvFile(AddressBookOperations.IOServices.FILE_IO);
        AddressBookOperations.readContactsFromcsvFile(AddressBookOperations.IOServices.FILE_IO);
        AddressBookOperations.writeContactstoJsonFile(AddressBookOperations.IOServices.FILE_IO);
        AddressBookOperations.readContactsfromJsonFile(AddressBookOperations.IOServices.FILE_IO);
   }
   @Test
    public void databaseOperation() throws IOException, SQLException {
       AddressBookOperations.addContacts(AddressBookOperations.IOServices.CONSOLE_IO);
       AddressBookOperations.addDataToDatabase(AddressBookOperations.IOServices.DB_IO);
       AddressBookOperations.addressbookoperations(AddressBookOperations.IOServices.DB_IO);
       AddressBookOperations.retrievedataFromDatabase(AddressBookOperations.IOServices.DB_IO);
       AddressBookOperations.ContactCount(AddressBookOperations.IOServices.DB_IO);
       AddressBookOperations.retrieveDataAccordingToDate(AddressBookOperations.IOServices.DB_IO);
   }

}
