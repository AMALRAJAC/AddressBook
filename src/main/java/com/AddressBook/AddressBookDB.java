package com.AddressBook;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDB {

    private static Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_database?characterEncoding=latin1";
        String userName = "root";
        String password = "password";
        Connection con;
        System.out.println("Connecting to database:" + jdbcURL);
        con = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successfull!!!!!" + con);
        return con;
    }
    public static void addContactsToDataBase(ArrayList<Contact> contactArrayList) throws SQLException {
        emptyDatabase();

        try (Connection connection = getConnection()){
            for (Contact contact:contactArrayList) {
                String sql = " insert into addressbook_info (fullname, address, city, state, zip,phone,start,type_id)"
                        + " values (?, ?, ?, ?, ?,?,?,(select type_id from addressbook_type where type='"+contact.getBook_name()+"'))";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, contact.getFullname());
                statement.setString(2, contact.getAddress());
                statement.setString(3, contact.getCity());
                statement.setString(4, contact.getState());
                statement.setDouble(5, contact.getZip());
                statement.setDouble(6, contact.getPhone());
                statement.setDate(7, Date.valueOf(contact.getStartDate()));
                statement.addBatch();
                statement.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void deleteDataFromDatabase(String name) throws SQLException {
        String sql="DELETE FROM addressbook_info WHERE fullname='"+name+"';";
        try(Connection connection=getConnection()){
            Statement statement=connection.createStatement();
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void modifyDatafromDatabase(String name,String newName){
        String sql="UPDATE addressbook_info SET fullname='"+newName+"' WHERE fullname='"+name+"';";
        try(Connection connection=getConnection()){
            Statement statement=connection.createStatement();
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void emptyDatabase() throws SQLException {
        String sql="DELETE FROM addressbook_info;";
        try(Connection connection=getConnection()){
            Statement statement=connection.createStatement();
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void showData() throws SQLException {
        List<Contact>contactList=new ArrayList<>();
        String sql="select * from addressbook_info;";
        try(Connection connection=getConnection()){
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            contactList=getContactDetails(resultSet);
            //statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("retrieve data");
        System.out.println(contactList);
    }

    private static List<Contact> getContactDetails(ResultSet resultSet) {
        List<Contact>contactList=new ArrayList<>();
        try{

            while(resultSet.next()){

                String fullname=resultSet.getString("fullname");
                String address=resultSet.getString("address");
                String city=resultSet.getString("city");
                String state=resultSet.getString("state");
                int zip=resultSet.getInt("zip");
                int phone=resultSet.getInt("phone");
                LocalDate startDate=resultSet.getDate("Start").toLocalDate();
                contactList.add(new Contact("person",fullname,address,city,state,zip,phone,startDate));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contactList;
    }
    public static void retrievedAccordingToDate(){
        List<Contact>contactList=new ArrayList<>();
        String sql="select * from addressbook_info where start='"+LocalDate.now()+"';";
        try(Connection connection=getConnection()){
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            contactList=getContactDetails(resultSet);
            //statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("retrieve data according to date");
        System.out.println(contactList);
    }
    public static void getCountbycity( String cityName) throws SQLException {
        String sql="select count(city) from addressbook_info where city='"+cityName+"';";
        try(Connection connection=getConnection()){
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
           resultSet.next();
           System.out.println("count of city");
            System.out.println(resultSet.getInt("count(city)"));
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
