package by.tsydzik.application.components;

import by.tsydzik.application.scss.IdSelector;
import by.tsydzik.application.viewes.MainView;
import by.tsydzik.data.entities.User;
import by.tsydzik.data.services.UserService;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Optional;

import static by.tsydzik.application.scss.ClassSelector.LOGIN_FORM;

/**
 * Spring component which creates login form
 *
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@UIScope
@Component
public class LoginPanel extends VerticalLayout {

    private final static String LOGIN_FORM_CAPTION = "Sign up";

    @Inject
    private UserService userService;


    @PostConstruct
    private void init() {


        // placeholder for login form
        Panel loginPanel = constructLoginPanel();

        // add login panel to current view
        this.addComponent(loginPanel);

        // general css styling
        this.addStyleName(LOGIN_FORM);
        this.setHeight(100, Unit.PERCENTAGE);
        //  this.setMargin(false);
        this.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);

    }


    /**
     * Creates placeholder for login form to set
     *
     * @return login form panel
     */
    private Panel constructLoginPanel() {

        Panel loginPanel = new Panel();

        //set login form to panel placeholder
        loginPanel.setContent(constructLoginForm());

        // general css styling
        loginPanel.setCaption(LOGIN_FORM_CAPTION);
        loginPanel.setIcon(VaadinIcons.USER);
        loginPanel.setId(IdSelector.LOGIN_PANEL);
        loginPanel.setWidth(400, Unit.PIXELS);
        loginPanel.setHeight(350, Unit.PIXELS);

        return loginPanel;
    }


    /**
     * Creates and styles login form
     *
     * @return
     */
    private LoginForm constructLoginForm() {

        LoginForm loginForm = new LoginForm();
        loginForm.setSizeFull();

        //add listener for login button
        loginForm.addLoginListener(this::processAuthentication);

        return loginForm;
    }


    /**
     * Checks user credentials throw database.
     * If user credentials are valid then navigate to {@link MainView}
     * otherwise show to user error {@link Notification}
     *
     * @param logEvent
     */
    private void processAuthentication(LoginForm.LoginEvent logEvent) {

        String userName = logEvent.getLoginParameter("username");
        String password = logEvent.getLoginParameter("password");

        Optional<User> user = userService.findUserByNameAndPassword(userName, password);

        if (user.isPresent()) {

            VaadinSession.getCurrent().setAttribute("userId", user.get().getId());

            getUI().getNavigator().navigateTo(MainView.VIEW_NAME);

            StringBuilder greeting = new StringBuilder("Welcome back, ").append(userName).append("!");
            Notification.show(greeting.toString(), Notification.Type.HUMANIZED_MESSAGE);
        } else {

            String message = "Try to login with following credentials:\n\n user - 'admin',\n\n password - 'admin'.";
            Notification notification = new Notification(message);
            notification.setStyleName(ValoTheme.NOTIFICATION_SYSTEM);
            notification.show(getUI().getPage());
        }


    }
}
