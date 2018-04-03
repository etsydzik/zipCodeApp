package by.tsydzik.application.security;

import by.tsydzik.application.viewes.LoginView;
import by.tsydzik.data.services.UserService;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.access.ViewAccessControl;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;
import org.bson.types.ObjectId;

import javax.inject.Inject;

/**
 * This class is used to restrict users from navigation to
 * views which require privileges
 *
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@SpringComponent
public class ViewAccessControlImpl implements ViewAccessControl{


    @Inject
    UserService userService;

    @Override
    public boolean isAccessGranted(UI ui, String viewName) {
        ObjectId userId = (ObjectId) VaadinSession.getCurrent().getAttribute("userId");

        // allow access to LoginView for all users
        if(LoginView.class.getSimpleName().equalsIgnoreCase(viewName)){

            return true;
        }
        // restrict access to other views for unauthorized user (GUEST group)
        else {

            String userGroup = userService.getUserGroup(userId);
            if(!userGroup.equalsIgnoreCase("Guest")){
                return true;
            }
        }
        return false;
    }
}
