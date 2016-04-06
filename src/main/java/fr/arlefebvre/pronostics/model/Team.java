package fr.arlefebvre.pronostics.model;

import org.springframework.data.annotation.Id;

/**
 * Created by alefebvre on 06/04/2016.
 *
 * Represents a football team (club or nation)
 */
public class Team {
    @Id
    private String id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
