package ir.maktabsharif.controller;

import ir.maktabsharif.entity.Address;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

//    {
//            "street": "123 Main St",
//            "city": "New York",
//            "state": "NY",
//            "postalCode": "10001"
//    }
    @PutMapping("/{userId}/address")
    public User updateAddress(@PathVariable String userId, @RequestBody Address address) {
        return userService.updateAddress(userId, address);
    }
    @GetMapping("/{userId}/address")
    public ResponseEntity<Address> getUserAddress(@PathVariable String userId) {
       Address address = userService.getAddressByUserId(userId);
        if (address != null) {
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}