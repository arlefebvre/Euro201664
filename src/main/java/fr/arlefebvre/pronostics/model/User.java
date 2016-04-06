package fr.arlefebvre.pronostics.model;

/**
 * Created by alefebvre on 06/04/2016.
 */

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
