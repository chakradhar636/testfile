package Dao;

import Entities.Address;
import Entities.Customer;

import java.util.Date;

/**
 * Created by vankayab on 8/3/2017.
 */
public interface CustomerDAO {
    public boolean addCustomer(String regNo, String name, Date bookingDate, long mobileNo, String email, Address address);
    public boolean SearchCustomer(String VehicleNo);
}

