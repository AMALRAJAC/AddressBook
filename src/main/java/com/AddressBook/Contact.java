package com.AddressBook;
import java.util.Objects;

public class Contact {
    private String Book_name;
    private String fullname;
    private String address;
    private String city;
    private String state;
    private int zip;
    private int phone;

    // Creates Contact object based on parameters.
    public Contact(String Book_name,String fullname, String address, String city, String state, int zip, int phone) {
        this.Book_name=Book_name;
        this.fullname = fullname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
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
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Contact contact = (Contact) obj;
        return (fullname == contact.fullname
                || (fullname != null && fullname.equals(contact.getFullname())))
                && (address == contact.address
                || (address != null && address .equals(contact.getAddress())))
                && (city == contact.city
                || (city != null && city .equals(contact.getCity())))
                && (state == contact.state
                || (state != null && state .equals(contact.getState())))
                && (zip == contact.zip)
                && (phone==contact.phone)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname,address,city,state,zip,phone);
    }
    @Override
    public String toString() {
        return "[name=" + this.fullname + ", Address=" + this.address + ", City="
                + this.city + ", state=" + this.state + ", zip=" + this.zip
                + ", phone=" + this.phone + "]";
    }
}
