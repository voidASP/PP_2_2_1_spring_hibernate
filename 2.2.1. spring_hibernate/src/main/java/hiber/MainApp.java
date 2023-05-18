package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
         UserService userService = context.getBean(UserService.class);

      User anton = new User("Anton", "Popov", "popov@mail.ru");
      Car audi = new Car("Audi", 8);

      userService.add(anton.setCar(audi).setUser(anton));

         List<User> users = userService.listUsers();
         for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
         }
      System.out.println("User with audi 8 - " + userService.getUserByCar("Audi", 8));
   }
}
