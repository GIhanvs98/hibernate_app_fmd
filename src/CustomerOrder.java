import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "customer_order")
public class CustomerOrder {
    @Id
    @Column
    private String id;

    private double cost;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "customer_order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    // Getters and Setters
}
