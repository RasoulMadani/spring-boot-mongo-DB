package ir.maktabsharif.seeder;

import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    public DatabaseSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // حذف داده‌های موجود در دیتابیس (در صورت نیاز)
        userRepository.deleteAll();

        // ایجاد نمونه‌های داده
        User user1 = new User("John Doe", "john.doe@example.com");
        User user2 = new User("Jane Doe", "jane.doe@example.com");
        User user3 = new User("Alice Smith", "alice.smith@example.com");

        // ذخیره داده‌ها در MongoDB
        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        System.out.println("Sample data added to MongoDB");
    }
}
