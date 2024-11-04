package ir.maktabsharif.service;

import ir.maktabsharif.entity.Address;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
    public User updateAddress(String userId, Address address) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setAddress(address);  // تنظیم آدرس
            return userRepository.save(user); // ذخیره کاربر با آدرس جدید
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }
    public Address getAddressByUserId(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get().getAddress();
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }
}