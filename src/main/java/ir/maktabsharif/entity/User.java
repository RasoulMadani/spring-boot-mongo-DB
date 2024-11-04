package ir.maktabsharif.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String name;
    private String email;
    private List<String> orderIds;
    private Address address;
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public User(String name, String email,Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

}