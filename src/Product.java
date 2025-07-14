import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    private String id;

    private double cost;

    @ManyToMany(mappedBy = "products")  // Reference the 'products' field in CustomerOrder
    private Set<CustomerOrder> customerOrders = new HashSet<>();

    // Getters and Setters
}
