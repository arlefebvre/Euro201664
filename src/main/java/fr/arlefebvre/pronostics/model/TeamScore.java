package fr.arlefebvre.pronostics.model;

import org.springframework.data.annotation.Id;

/**
 * Created by alefebvre on 06/04/2016.
 */
public class TeamScore {
    private int goals;

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
