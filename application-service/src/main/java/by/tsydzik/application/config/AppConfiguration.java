package by.tsydzik.application.config;

import by.tsydzik.data.config.DataServiceConfig;
import by.tsydzik.data.config.SimpleMongoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@Configuration
@ComponentScan(value = {"by.tsydzik.application"})
@Import(DataServiceConfig.class)
public class AppConfiguration {


}

