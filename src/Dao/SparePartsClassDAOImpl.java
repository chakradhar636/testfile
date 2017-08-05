package Dao;

import Entities.SparePartsClass;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;

/**
 * Created by vankayab on 8/4/2017.
 */
public class SparePartsClassDAOImpl implements SparePartsClassDAO{
    static SessionFactory sessionFactory;
    Transaction tx = null;
    Session session;

    public SparePartsClassDAOImpl() {
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
        boolean a=new SparePartsClassDAOImpl().addSpareparts(new SparePartsClass("tyre",1000));
        System.out.println(a);
    }
        @Override
    public boolean addSpareparts(SparePartsClass sparePartsClass) {
        try{
            session=sessionFactory.openSession();
        tx=session.beginTransaction();
        session.save(sparePartsClass);
        tx.commit();
        return true;
    }
    catch(HibernateException e)
    {
        if (tx != null) tx.rollback();
        e.printStackTrace();
        return  false;
    }
    finally {
            session.close();
        }

    }

    @Override
    public ArrayList<SparePartsClass> listSpareparts() {
        Session session = sessionFactory.openSession();

//        ArrayList<SparePartsClass> lo = new ArrayList<SparePartsClass>();

        ArrayList<SparePartsClass> operators = new ArrayList<SparePartsClass>();

        try {
            tx = session.beginTransaction();
            Query qry = session.createQuery(" FROM  Entities.SparePartsClass ");
            operators = (ArrayList<SparePartsClass>) qry.list();

//            for (Iterator iterator =
//                 operators.iterator(); iterator.hasNext(); ) {
//                SparePartsClass oc = (SparePartsClass) iterator.next();
//                lo.add(oc);
//            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return operators;

    }
}
