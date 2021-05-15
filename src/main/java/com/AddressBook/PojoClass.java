package com.AddressBook.pojo;

import java.time.LocalDate;

public class PojoClass {
    private String Book_name;
    private String fullname;
    private String address;
    private String city;
    private String state;
    private int zip;
    private int phone;
    private LocalDate startDate;
    public LocalDate getStartDate(){
        return getStartDate();
    }
    public void setStartDate(LocalDate startDate){
        this.startDate=startDate;
    }
    public String getBook_name(){
        return Book_name;
    }
    public void setBook_name(String Book_Name){
        this.Book_name=Book_Name;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
}
