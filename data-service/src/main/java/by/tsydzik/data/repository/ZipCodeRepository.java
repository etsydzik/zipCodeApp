package by.tsydzik.data.repository;

import by.tsydzik.data.entities.ZipCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

/**
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@Repository
public interface ZipCodeRepository extends MongoRepository<ZipCode, Long> {

    @Query("{}")
    Stream<ZipCode> findAllAsStream();
}
