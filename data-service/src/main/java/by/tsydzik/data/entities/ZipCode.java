package by.tsydzik.data.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@Document(collection = "zips")
public class ZipCode {

    @Id
    Long zipCode;

    String state;

    String city;

    @Field("pop")
    Long population;

    @Field("loc")
    List<Double> location;

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "zipCode=" + zipCode +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", population=" + population +
                ", location=" + location +
                '}';
    }
}
