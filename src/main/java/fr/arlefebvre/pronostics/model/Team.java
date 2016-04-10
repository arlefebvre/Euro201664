package fr.arlefebvre.pronostics.model;

import org.springframework.data.annotation.Id;

/**
 * Created by alefebvre on 06/04/2016.
 * <p>
 * Represents a football team (club or nation)
 */
public class Team {
    @Id
    private String id;

    private String countryCode;

    private String name;

    private String imgUrl;

    private boolean isNationalTeam;

    public boolean isNationalTeam() {
        return isNationalTeam;
    }

    public void setNationalTeam(boolean nationalTeam) {
        isNationalTeam = nationalTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
