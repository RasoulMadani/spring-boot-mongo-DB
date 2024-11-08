package ir.maktabsharif.repository;


import ir.maktabsharif.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByName(String name);
}
