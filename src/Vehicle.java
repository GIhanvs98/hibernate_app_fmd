import javax.persistence.*;

@Entity(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "vehicle_id")
    private String vId;  // Primary key for Vehicle

    @Column(name = "vehicle_name", nullable = false)
    private String vehicleName;  // Name of the vehicle

    @OneToOne
    @JoinColumn(name = "customer_id", unique = true)  // Foreign key to Customer
    private Customer customer;

    // Getters and Setters
}
