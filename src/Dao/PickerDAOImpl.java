package Dao;

import Entities.Picker;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by vankayab on 8/3/2017.
 */
public class PickerDAOImpl implements PickerDAO {
    SessionFactory sessionFactory;
    public Picker returnDriver(String name, long mobNumber) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        Picker picker = null;
        try{
            tx = session.beginTransaction();
            picker = new Picker(name,mobNumber);
            session.save(picker);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return picker;
    }

}
