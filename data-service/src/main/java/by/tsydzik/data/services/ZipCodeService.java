package by.tsydzik.data.services;

import by.tsydzik.data.entities.ZipCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

/**
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@Service
public interface ZipCodeService {

    List<ZipCode> getAllZipCodes();

    Stream<ZipCode> getAllZipCodesAsStream();
}
