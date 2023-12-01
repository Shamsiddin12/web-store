package uz.greenwhite.webstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import uz.greenwhite.webstore.enums.OrderStatus;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Size(max = 20)
    private String firstName;

    private String lastName;

    @Size(max = 18) // +998-99-999-99-99
    private String phoneNumber;

    private String address;

    private String comment;

    //Orders status saved with enum Values instead of Names
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "modefiedBy")
    private User modifiedBy;

    @CreationTimestamp
    private Date createdOn;

}
