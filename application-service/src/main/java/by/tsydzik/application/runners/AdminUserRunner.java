package by.tsydzik.application.runners;

import by.tsydzik.data.config.PropertyService;
import by.tsydzik.data.entities.User;
import by.tsydzik.data.services.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Application runner to create 'admin' user if not present in db.
 * <p>
 * Created by Eugene Tsydzik
 * on 4/3/18.
 */
@Component
public class AdminUserRunner implements ApplicationRunner {

    @Inject
    private UserService userService;
    @Inject
    private PropertyService propertyService;


    @Override
    public void run(ApplicationArguments args) {
        userService.findUserByName(propertyService.getAdminName()).orElseGet(this::createAdminUser);

    }

    private User createAdminUser() {
        User adminUser = new User();
        adminUser.setUserName(propertyService.getAdminName());
        adminUser.setPassword(propertyService.getAdminPassword());
        adminUser.setGroup(propertyService.getAdminGroup());
        return userService.createNewUser(adminUser);
    }
}
