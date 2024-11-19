import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import t1.service.UserService;

@Configuration
@ComponentScan(basePackages = "t1")
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        UserService userService = context.getBean(UserService.class);

        userService.createUser("Yann");
        userService.createUser("NeYann");

        System.out.println("Все пользователи: " + userService.getAllUsers());
        System.out.println("Пользователь с ID 1: " + userService.getUserById(1L));

        userService.updateUser(1L, "updated_user1");
        System.out.println("После обновления: " + userService.getUserById(1L));

        userService.deleteUser(2L);
        System.out.println("После удаления: " + userService.getAllUsers());

        context.close();
    }

}