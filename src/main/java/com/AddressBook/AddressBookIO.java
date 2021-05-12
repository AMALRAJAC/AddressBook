package com.AddressBook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookIO {
    private static String FILE_NAME="C:\\Users\\CRACKERJACK\\IdeaProjects\\AddressBook\\src\\main\\java\\com\\AddressBook\\addressbookfile.txt";
        public static void writeData(ArrayList<Contact> employeePayrollList){
            StringBuffer empBuffer=new StringBuffer();
            employeePayrollList.forEach(employee->{
                String employeeDataString=employee.toString().concat("\n");
                empBuffer.append(employeeDataString);
            });
            try{
                Files.write(Paths.get(FILE_NAME),empBuffer.toString().getBytes());
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        public static void printData(){
            try{
                Files.lines((new File(FILE_NAME).toPath())).forEach(System.out::println);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static long countEntries(){
            long entries=0;
            try{
                entries=Files.lines(new File(FILE_NAME).toPath()).count();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return entries;
        }

        public static List<Contact> readData()  {
            List<Contact>employeePayrollList= new ArrayList<>();
            try{
                Files.lines(new File(FILE_NAME).toPath()).map(line->line.trim()).forEach(line->System.out.println(line));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return employeePayrollList;
        }
    }

