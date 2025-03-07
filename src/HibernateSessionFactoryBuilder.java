import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactoryBuilder {
    private final static SessionFactory SESSION_FACTORY
            =buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Vehicle.class)
                .addAnnotatedClass(CustomerOrder.class)
                .addAnnotatedClass(Product.class)
                .getMetadataBuilder()
                .build();

        return metadata.getSessionFactoryBuilder()
                .build();
    }
    public static Session getSession(){
        return SESSION_FACTORY.openSession();
    }
}

