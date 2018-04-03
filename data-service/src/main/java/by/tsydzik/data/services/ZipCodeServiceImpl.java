package by.tsydzik.data.services;

import by.tsydzik.data.entities.ZipCode;
import by.tsydzik.data.repository.ZipCodeRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

/**
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@Service
public class ZipCodeServiceImpl implements ZipCodeService {

    @Inject
    ZipCodeRepository zipCodeRepository;

    @Override
    public List<ZipCode> getAllZipCodes() {
        return zipCodeRepository.findAll();
    }


    @Override
    public Stream<ZipCode> getAllZipCodesAsStream(){
        return zipCodeRepository.findAllAsStream();
    }
}
