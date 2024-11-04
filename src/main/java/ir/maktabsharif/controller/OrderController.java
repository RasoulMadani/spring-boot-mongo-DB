package ir.maktabsharif.controller;

import ir.maktabsharif.entity.Order;
import ir.maktabsharif.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable String userId) {
        return orderService.getOrdersByUserId(userId);
    }

//    {
//        "description": "New order for testing",
//            "price": 99.99
//    }
    @PostMapping("/user/{userId}")
    public Order createOrder(@PathVariable String userId, @RequestBody Order order) {
        return orderService.saveOrder(userId, order);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
    }
}