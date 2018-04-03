package by.tsydzik.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point to the application.
 * This class starts embedded TomCat server under the hood
 * and deploys application to it
 *
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@SpringBootApplication
public class ZipCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipCodeApplication.class, args);
	}
}
