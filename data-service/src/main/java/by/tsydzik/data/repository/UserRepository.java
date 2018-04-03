package by.tsydzik.data.repository;

import by.tsydzik.data.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */

public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Query("{}")
    Stream<User> findAllUsers();

    User findByUserName(String userName);

    Optional<User> findUserByUserNameAndPassword(String userName, String password);

    Optional<User> findUserById(ObjectId userId);

}
