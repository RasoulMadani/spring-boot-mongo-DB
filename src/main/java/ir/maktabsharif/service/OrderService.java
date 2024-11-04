package ir.maktabsharif.service;

import ir.maktabsharif.entity.Order;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.OrderRepository;
import ir.maktabsharif.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;


    public List<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order saveOrder(String userId, Order order) {
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(order::setUser);
        return orderRepository.save(order);
    }

    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }
}
