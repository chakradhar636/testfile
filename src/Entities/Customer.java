package Entities;

import java.util.Date;

/**
 * Created by vankayab on 8/2/2017.
 */
public class Customer {
    String regNo;
    String name;
    Date BookingDate;
    long MobileNo;
    String Email;
    Address address;


    public Customer() {
    }

    public Customer(String regNo, String name, Date bookingDate, long mobileNo, String email, Address address) {
        this.regNo = regNo;
        this.name = name;
        BookingDate = bookingDate;
        MobileNo = mobileNo;
        Email = email;
        this.address = address;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        BookingDate = bookingDate;
    }

    public long getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(long mobileNo) {
        MobileNo = mobileNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
