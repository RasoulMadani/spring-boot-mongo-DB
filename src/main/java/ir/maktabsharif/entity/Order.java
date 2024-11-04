package ir.maktabsharif.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "orders")
@Getter
@Setter
public class Order {

    @Id
    private String id;
    private String description;
    private Double price;

    // Reference to User
    @DBRef
    private User user;

    // Getters and Setters
}