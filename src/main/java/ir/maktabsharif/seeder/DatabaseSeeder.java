package ir.maktabsharif.seeder;
import ir.maktabsharif.entity.Order;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.OrderRepository;
import ir.maktabsharif.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) {
        // حذف داده‌های موجود (در صورت نیاز)
        userRepository.deleteAll();
        orderRepository.deleteAll();

        // ایجاد داده‌های اولیه برای User
        User user1 = new User();
        user1.setName("John Doe");
        user1.setEmail("john.doe@example.com");

        User user2 = new User();
        user2.setName("Jane Doe");
        user2.setEmail("jane.doe@example.com");

        // ذخیره کاربران در پایگاه داده
        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);

        // ایجاد داده‌های اولیه برای Order و ارتباط آن‌ها با Userها
        Order order1 = new Order();
        order1.setDescription("Order 1 for John");
        order1.setPrice(100.0);
        order1.setUser(user1);

        Order order2 = new Order();
        order2.setDescription("Order 2 for John");
        order2.setPrice(150.0);
        order2.setUser(user1);

        Order order3 = new Order();
        order3.setDescription("Order 1 for Jane");
        order3.setPrice(200.0);
        order3.setUser(user2);

        // ذخیره سفارشات در پایگاه داده
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        System.out.println("Sample data added to MongoDB");
    }
}