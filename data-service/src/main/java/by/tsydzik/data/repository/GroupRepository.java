package by.tsydzik.data.repository;

import by.tsydzik.data.entities.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@Repository
public interface GroupRepository extends MongoRepository<Group,String> {
}
