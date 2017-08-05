package Dao;


import Entities.Address;
import Entities.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by vankayab on 8/3/2017.
 */

public class CustomerDAOImpl implements CustomerDAO {

    static SessionFactory sessionFactory=null;
    public CustomerDAOImpl(){
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);

        }
    }
    public static void main(String [] args) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);

        }
        System.out.println("adsfasd");
    }
    public Address addAddress(Address address) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        //Integer addressID = null;
       // Address address = null;
        try{
            tx = session.beginTransaction();
            //address = new Address(hno,streetName,city,state,pinCode);
            session.save(address);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return address;
    }
    @Override
    public boolean addCustomer(String regNo, String name, Date bookingDate, long mobileNo, String email, Address address) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        Customer operator = null;
        try {
            tx = session.beginTransaction();
            operator = new Customer(regNo,name,bookingDate,mobileNo,email,address);
            session.save(operator);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }


    @Override
    public boolean SearchCustomer(String VehicleNo) {
        return false;
    }
}
