package Dao;

import Entities.ServiceOrder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.*;

/**
 * Created by vankayab on 8/3/2017.
 */
public class ServiceOrderDAOImpl implements ServiceOrderDAO{
    static SessionFactory factory;
    Session session;
    Transaction tx;

    public ServiceOrderDAOImpl() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ServiceOrderDAOImpl s=new ServiceOrderDAOImpl();
        Map<String,Integer> map=s.getServiceOrder("1");
        Set set=map.entrySet();
        System.out.println(set);
    }
    @Override
    public boolean addServiceOrder(String regno, String opcode) {
        try {
            ServiceOrder sd = new ServiceOrder(regno, opcode);
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(sd);
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
    public Map<String, Integer> getServiceOrder(String regno) {
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            Query qry = session.createQuery("From ServiceOrder where regno=:r");
            qry.setParameter("r",regno);
            List lt=qry.list();
            ListIterator ltr=lt.listIterator();
            Map<String,Integer> map=new HashMap<>();
            if(ltr.hasNext()) {
                ServiceOrder serviceOrder =(ServiceOrder)  ltr.next();
                String opcode=serviceOrder.getOpcode();


                if(opcode.contains("1"))map.put("Suspension Brake",12867);
                if(opcode.contains("2"))map.put("Fuel Filter",2003);
                if(opcode.contains("3"))map.put("Air Filter",2003);
                if(opcode.contains("4"))map.put("Outside Mirror",3000);
                if(opcode.contains("5"))map.put("Airbag",4052);
                if(opcode.contains("6"))map.put("Oil and filter change",1200);
                if(opcode.contains("7"))map.put("Clutch operation checking",600);
                if(opcode.contains("8"))map.put("Wheel bearing checking",400);
                if(opcode.contains("9"))map.put("Basic Service",2500);
                if(opcode.contains("0"))map.put("Reset Service Light",300);


            }
            return map;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }
}
