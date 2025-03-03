import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.swing.*;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
      //  saveCustomer();
     /*Customer customer=   findById("C1");
        System.out.println(customer!=null?customer:"customer not found");*/
      //  updateCustomer();
      //  findAll();
        deleteCustomer("C1");


    }

    private static void deleteCustomer(String c1) {
        Customer customer = findById(c1);
        if(customer==null){
            JOptionPane.showMessageDialog(null,"customer not found!");
            return;
        }

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }

    private static void findAll() {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("FROM Customer",Customer.class);
        List<Customer> list = query.list();
        System.out.println(list);
        session.close();
        sessionFactory.close();
    }
    private static void updateCustomer() {
        Customer customer = findById("C1");
        if(customer==null){
            JOptionPane.showMessageDialog(null,"customer not found!");
            return;
        }
        customer.setName("Ranil");
        customer.setAddress("Colombo");
        customer.setSalary(80000);

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private static Customer findById(String id) {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
      return   session.find(Customer.class, id);

    }

    private static void saveCustomer() {
        Customer c1 = new Customer("C1","Kamal","Colombo",5000);
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(c1);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
