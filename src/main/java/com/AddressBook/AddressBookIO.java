package com.AddressBook;


import com.AddressBook.pojo.PojoClass;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.opencsv.CSVReader;
import org.json.JSONArray;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookIO {
    private static final String FILE_NAME = "C:\\Users\\CRACKERJACK\\IdeaProjects\\AddressBook\\src\\main\\java\\com\\AddressBook\\addressbookfile.txt";
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\CRACKERJACK\\IdeaProjects\\AddressBook\\src\\main\\java\\com\\AddressBook\\AddressBookFileCSV.csv";
    private static final String JSON_FILE_PATH = "C:\\Users\\CRACKERJACK\\IdeaProjects\\AddressBook\\src\\main\\java\\com\\AddressBook\\AddressBook.json";

    public static void writeData(ArrayList<Contact> employeePayrollList) {
        StringBuffer empBuffer = new StringBuffer();
        employeePayrollList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(FILE_NAME), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public static List<Contact> readData() {
        List<Contact> employeePayrollList = new ArrayList<>();
        try {
            Files.lines(new File(FILE_NAME).toPath()).map(line -> line.trim()).forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }

    public static void readDataUsingCSVFile() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("Name: " + nextRecord[0]);
                System.out.println("address: " + nextRecord[1]);
                System.out.println("city: " + nextRecord[2]);
                System.out.println("state: " + nextRecord[3]);
                System.out.println("zip: " + nextRecord[4]);
                System.out.println("phone: " + nextRecord[5]);
                System.out.println("date: "+nextRecord[6]);
                System.out.println("***********************");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteDataUsingCSVFile(ArrayList<Contact> contactArrayList) throws IOException {
        FileWriter fileWriter = new FileWriter(SAMPLE_CSV_FILE_PATH);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        for (Contact contact : contactArrayList) {
            writer.write(contact.getFullname() + "," + contact.getAddress() + "," +
                    contact.getCity() + "," + contact.getState() + "," + contact.getZip() + "," + contact.getPhone()+","+contact.startDate);
            writer.newLine();
        }
        writer.close();
    }

    public static long countcsvEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(SAMPLE_CSV_FILE_PATH).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public static void writeDataInToJsonFile(ArrayList<Contact> contactArrayList) throws IOException {
        JSONArray obj = new JSONArray();
        for (Contact contact : contactArrayList) {
            PojoClass pojoClass = new PojoClass();
            pojoClass.setFullname(contact.getFullname());
            pojoClass.setAddress(contact.getAddress());
            pojoClass.setCity(contact.getCity());
            pojoClass.setState(contact.getState());
            pojoClass.setZip(contact.getZip());
            pojoClass.setPhone(contact.getPhone());
            pojoClass.setStartDate(contact.getStartDate());
            Gson gson = new Gson();
            String json = gson.toJson(pojoClass);
            obj.put(json);
            try {
                FileWriter fileWriter = new FileWriter(JSON_FILE_PATH);
                BufferedWriter writer = new BufferedWriter(fileWriter);
                writer.write(String.valueOf(obj));
                writer.newLine();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readDataUsingJsonFile() throws IOException {
        Path path = Paths.get(JSON_FILE_PATH);

        try (Reader reader = Files.newBufferedReader(path,
                StandardCharsets.UTF_8)) {

            JsonElement tree = JsonParser.parseReader(reader);

            JsonArray array = tree.getAsJsonArray();
            for (JsonElement element: array) {
                    element.toString();
                    System.out.println(element);
            }
        }
    }
}
