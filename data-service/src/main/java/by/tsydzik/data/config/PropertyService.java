package by.tsydzik.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Provides API for working with application properties.
 *
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@Service
public class PropertyService {


    @Value("${mongo.database.name}")
    private String mongoDatabaseName;

    @Value("${mongo.database.url}")
    private String mongoDatabaseUrl;

    @Value("${mongo.database.adminName}")
    private String adminName;

    @Value("${mongo.database.adminPassword}")
    private String adminPassword;

    @Value("${mongo.database.adminGroup}")
    private String adminGroup;


    public String getMongoDatabaseName() {
        return mongoDatabaseName;
    }

    public void setMongoDatabaseName(String mongoDatabaseName) {
        this.mongoDatabaseName = mongoDatabaseName;
    }

    public String getMongoDatabaseUrl() {
        return mongoDatabaseUrl;
    }

    public void setMongoDatabaseUrl(String mongoDatabaseUrl) {
        this.mongoDatabaseUrl = mongoDatabaseUrl;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getAdminGroup() {
        return adminGroup;
    }
}
