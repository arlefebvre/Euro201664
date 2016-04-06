package fr.arlefebvre.pronostics;

/**
 * Created by alefebvre on 06/04/2016.
 */
import org.springframework.data.annotation.Id;

public class User {

    @Id private String id;

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
