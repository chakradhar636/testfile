package Dao;

import Entities.Customer;

/**
 * Created by vankayab on 8/5/2017.
 */
public class PdfCreator {
    public  void create(String regno) {
        System.out.println("in create");
        try {
            Pdf p = new Pdf();
            CustomerDAOImpl cdo=new CustomerDAOImpl();
            Customer c=cdo.getCustomer(regno);
    System.out.println("after customer");
            p.createpdf(regno, c.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("adf");
        }
    }
}
