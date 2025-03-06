import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.swing.*;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
      // saveCustomer();
     /*Customer customer=   findById("C1");
        System.out.println(customer!=null?customer:"customer not found");*/
       // updateCustomer();
      //  findAll();
        deleteCustomer("C1");


    }

    private static void deleteCustomer(String c1) {
        Customer customer = findById(c1);
        if(customer==null){
            JOptionPane.showMessageDialog(null,"customer not found!");
            return;
        }
        try (Session session=HibernateSessionFactoryBuilder.getSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        }


    }

    private static void findAll() {
        try (Session session=HibernateSessionFactoryBuilder.getSession()){
            Query<Customer> query = session.createQuery("FROM Customer",Customer.class);
            List<Customer> list = query.list();
            System.out.println(list);
        }


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
        try (Session session=HibernateSessionFactoryBuilder.getSession()){
            Transaction transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();

        }

    }

    private static Customer findById(String id) {
        try (Session session=HibernateSessionFactoryBuilder.getSession()){
            return   session.find(Customer.class, id);

        }



    }

    private static void saveCustomer() {
        try (Session session=HibernateSessionFactoryBuilder.getSession()){
            Transaction transaction = session.beginTransaction();
            Customer c1 = new Customer("C1","Kamal","Colombo",5000);
            session.save(c1);
            transaction.commit();
        }

    }
}
