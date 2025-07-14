import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "customer_table")
public class Customer {
    @Id
    @Column(name="customer_id")
    private String id;
    private String name;
    private String address;
    private double salary;

    @OneToOne(mappedBy = "customer")
    private Vehicle vehicle;
    @OneToMany(mappedBy="customer")
    private Set<CustomerOrder> orders=new HashSet<>();



}
