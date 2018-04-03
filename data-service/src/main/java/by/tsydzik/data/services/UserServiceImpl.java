package by.tsydzik.data.services;

import by.tsydzik.data.entities.Group;
import by.tsydzik.data.entities.User;
import by.tsydzik.data.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@Service
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;


    @Override
    public User createNewUser(User user) {
        return userRepository.findByUserName(user.getUserName()) == null ? userRepository.save(user) : null;
    }

    @Override
    public Optional<User> findUserById(ObjectId userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public Stream<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public Optional<User> findUserByName(String userName) {

        return Optional.ofNullable(userRepository.findByUserName(userName));
    }

    @Override
    public Optional<User> findUserByNameAndPassword(String userName, String password) {
        return userRepository.findUserByUserNameAndPassword(userName, password);
    }


    @Override
    public String getUserGroup(ObjectId userId) {

        Optional<User> user = userRepository.findUserById(userId);

        if(user.isPresent()){
            return  user.get().getGroup();
        }
        else {
            return "Guest";
        }

    }
}
