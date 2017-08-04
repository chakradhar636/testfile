package Entities;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by bholar on 8/2/2017.
 */
public class HibernateClass {

    //    private static SessionFactory factory;
    private static SessionFactory sessionFactory = null;

    public HibernateClass() throws ParseException {
       System.out.println("asasda");
        try {
            System.out.println("try");
            Properties c = new Properties();
            //Configuration configuration = new Configuration();
            c.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            c.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            c.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/project_services?zeroDateTimeBehavior=convertToNull");
            c.setProperty("hibernate.connection.username", "root");
            c.setProperty("hibernate.connection.password", "CDKcdk11");
            c.setProperty("hibernate.connection.autoReconnect", "true");

            c.setProperty("connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
            c.setProperty("c3p0.min_size", "5");
            c.setProperty("c3p0.max_size", "20");
            c.setProperty("c3p0.timeout", "1800");
            c.setProperty("c3p0.max_statements", "100");
            c.setProperty("hibernate.c3p0.testConnectionOnCheckout", "true");

            sessionFactory = new Configuration().setProperties(c)
                    .addResource("empadd.hbm.xml")
                    .configure().buildSessionFactory();


        } catch (Throwable ex) {
            System.out.println("catch");
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    public boolean addDate(Date date)  {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date ldt=null;
  System.out.print(date);
      try {
           ldt = formatter.parse(formatter.format(date));
      }catch (Exception e){
          System.out.print("exception");

      }
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        DateTable operator = null;
     boolean avail = false;
        try {
            tx = session.beginTransaction();
            System.out.println("date check"+ldt+" d:"+date);
            Query query = session.createQuery("FROM DateTable WHERE dt=:sdate");
            query.setParameter("sdate",ldt);
            List<DateTable> operators = query.list();
            System.out.println(operators.size());
if(operators.size()>=1) {
    Iterator iterator = operators.iterator();
    DateTable db = (DateTable) iterator.next();
        if (db.getSlotcnt() == 0) {//slots are full
            System.out.print("HELLO1");
                                        avail = false;
        }
        else { //deduct slot by one
            int cnttemp = (db.getSlotcnt() - 1);
            int lid = db.getId();
            System.out.println("COUNT  :" + cnttemp);
            System.out.println("ID  :" + db.getId());
            System.out.print("HELLO");

            //
                                        String hql = "Update DateTable  set slotcnt=:newvalue where id=:opwr_id";
//                                        String hql = "Update DateTable  set slotcnt=:"+cnttemp+" where id="+lid;
                                        Query query1 = session.createQuery(hql);
                                        query1.setParameter("newvalue", cnttemp);
                                        query1.setParameter("opwr_id", lid);
                                        int result = query1.executeUpdate();
//                                        System.out.println("ROWS AFFECTED  :  " + result);
                                        avail = true;

            }
    }
    else { //no booking record in table, hence insert new record with slots as 9
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
        System.out.print(avail);
return avail;
    }

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

    public Address addAddress(String hno, String streetName, String city, String state, int pinCode) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        //Integer addressID = null;
        Address address = null;
        try{
            tx = session.beginTransaction();
            address = new Address(hno,streetName,city,state,pinCode);
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

    public ArrayList<SparePartsClass> listSpareparts() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
//        ArrayList<SparePartsClass> lo = new ArrayList<SparePartsClass>();

        ArrayList<SparePartsClass> operators = new ArrayList<SparePartsClass>();

        try {
            tx = session.beginTransaction();
            Query qry = session.createQuery(" FROM  SparePartsClass ");
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

    public DriverClass returnDriver(String name, long mobNumber) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        //Integer addressID = null;
        DriverClass driver = null;
        try{
            tx = session.beginTransaction();
            driver = new DriverClass(name,mobNumber);
            session.save(driver);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return driver;
    }

}
