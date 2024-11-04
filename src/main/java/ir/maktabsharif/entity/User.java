package ir.maktabsharif.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String name;
    private String email;
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

}