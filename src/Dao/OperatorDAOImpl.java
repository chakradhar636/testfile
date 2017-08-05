package Dao;

import Entities.Operator;
import Entities.ServiceOrder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

/**
 * Created by vankayab on 8/3/2017.
 */
public class OperatorDAOImpl implements OperatorDAO{
    static SessionFactory factory;
    public OperatorDAOImpl()
    {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
    public static void main(String [] args)
    {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        OperatorDAOImpl od=new OperatorDAOImpl();
    /*Operator o1=new Operator(1,"bhargav","bhargav");
    od.addOperator(o1);
    Operator o2=new Operator(2,"chakri","chakri");
    od.addOperator(o2);
    Operator o3=new Operator(3,"ravali","ravali");
    od.addOperator(o3);
    Operator o4=new Operator(4,"bhola","bhola");
    od.addOperator(o4);
    Operator o5=new Operator(5,"murali","murali");
    od.addOperator(o5);*/
        boolean a=   od.validate("asf","bhargav");
        System.out.println(a);
    }
    @Override
    public boolean validate(String user,String pass) {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            String hql = "FROM Operator where Username=:u and Password=:p";
            Query qry = session.createQuery(hql);
            qry.setParameter("u",user);
            qry.setParameter("p",pass);

            List<Object[]> operatorlist = qry.list();
            Iterator lt = operatorlist.listIterator();
            tx.commit();
            if (lt.hasNext()) return true;
            else return false;

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return  false;
        } finally {
            session.close();
        }
    }



    @Override
    public boolean createServicesDone(ServicesDoneDAO servicesDoneDAO)
    {
        return false;
    }
    public static boolean addOperator(Operator operator)
    {
        Transaction tx=null;
        Session session= null;
        try {
            /*Properties c = new Properties();
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
*/

            session = factory.openSession();

            tx = session.beginTransaction();
            session.save(operator);
            tx.commit();
            return true;

        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();

            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }

    }
}

