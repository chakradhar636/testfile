//package Entities;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Iterator;
//
///**
// * Created by bholar on 8/3/2017.
// */
//public class CheckDateClass {
//    public  static void main(String[] args) throws ParseException {
//        HibernateClass HC = new HibernateClass();
//
///*
//        Date date = new Date();
//boolean check =         HC.addDate(date);
//System.out.println("CHECK  :  "+check);
//*/
//        Date date = new Date();
////Address add = HC.addAddress("fdfgs","fdfgs","fxg","hgdfg",56);
////boolean check = HC.addCustomer("asdfgdf","gasdfgd",date,443452,"hgasdfg",add);
//
//        /*
//        Address add = HC.addAddress("419-A","Gandhi Nagar","Jammu","J&K",180004);
//        boolean check = HC.addCustomer("JAKA0LINKRO","FIAT",date,941925859,"bhola.rishav@gmail.com",add);
//        */
//
//        ArrayList<SparePartsClass> spc = HC.listSpareparts();
//        System.out.println("Array list object  :  "+spc);
//        for (Iterator iterator =
//             spc.iterator(); iterator.hasNext(); ) {
//            SparePartsClass oc = (SparePartsClass) iterator.next();
//            System.out.println("SPARE PARTS LIST OBJECT  =  "+oc);
//            System.out.println("ID  =  "+oc.getId());
//            System.out.println("SparePARTNAme  =  "+oc.getSparepartName());
//            System.out.println("Spare Part Cost  =  "+oc.getCost());
//        }
//
//        HC.returnDriver("Mohan",8803245326l);
//
//    }
//}
