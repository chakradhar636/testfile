package Dao;

import Entities.DateTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vankayab on 8/3/2017.
 */
public class DateDAOImpl implements DateDAO {
    static SessionFactory factory;
    Session session;
    Transaction tx;

    public DateDAOImpl() {
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
        Date d=new Date("11/22/1996");
     boolean a=new DateDAOImpl().checkDate(d);
        System.out.println(a);
    }

    @Override
    public boolean checkDate(Date d) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


        Date ldt = null;
        try {
            ldt = formatter.parse(formatter.format(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Session session = factory.openSession();
        Transaction tx = null;
        DateTable operator = null;
        boolean avail = false;
        try {
            tx = session.beginTransaction();
            System.out.println("date check" + ldt + " d:" + d);
            org.hibernate.query.Query query = session.createQuery("FROM DateTable WHERE dt=:sdate");
            query.setParameter("sdate", ldt);
            List<DateTable> operators = query.list();
            System.out.println(operators.size());
            if (operators.size() >= 1) {
                Iterator iterator = operators.iterator();
                DateTable db = (DateTable) iterator.next();
                if (db.getSlotcnt() == 0) {//slots are full
                    System.out.print("HELLO1");
                    avail = false;
                } else { //deduct slot by one
                    int cnttemp = (db.getSlotcnt() - 1);
                    int lid = db.getId();
                    System.out.println("COUNT  :" + cnttemp);
                    System.out.println("ID  :" + db.getId());
                    System.out.print("HELLO");

                    //
                    String hql = "Update DateTable  set slotcnt=:newvalue where id=:opwr_id";
//                                        String hql = "Update DateTable  set slotcnt=:"+cnttemp+" where id="+lid;
                    org.hibernate.query.Query query1 = session.createQuery(hql);
                    query1.setParameter("newvalue", cnttemp);
                    query1.setParameter("opwr_id", lid);
                    int result = query1.executeUpdate();
//                                        System.out.println("ROWS AFFECTED  :  " + result);
                    avail = true;

                }
            } else { //no booking record in table, hence insert new record with slots as 9
                System.out.print("HELLO4");
                operator = new DateTable(ldt, 9);
                session.save(operator);
                avail = true;
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return avail;

    }
}
