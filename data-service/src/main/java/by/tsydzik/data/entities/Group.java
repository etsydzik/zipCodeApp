package by.tsydzik.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@Document(collection = "userGroups")
public class Group {

    @Id
    String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
