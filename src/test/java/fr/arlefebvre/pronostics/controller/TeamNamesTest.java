/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Arthur Lefebvre
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package fr.arlefebvre.pronostics.controller;

import fr.arlefebvre.pronostics.Application;
import fr.arlefebvre.pronostics.TeamNameHelper;
import fr.arlefebvre.pronostics.model.Match;
import fr.arlefebvre.pronostics.model.Team;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Arthur on 17/04/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TeamNamesTest {
    @Autowired
    EuroMatchListController euroController;

    @Autowired
    UEFATeamsController teamsController;

    @Test
    public void getMatchesTest() {
        List<Match> matches = euroController.matches();
        List<Team> teams = teamsController.teams();
        for (Match match:matches) {
            if(match.getGroup().toUpperCase().startsWith("GROUP")){
                String teamName = match.getHomeTeamId();
                boolean teamFound = false;
                for (Team team : teams) {
                    if( team.getName().toUpperCase().equals(teamName.toUpperCase())
                            ||team.getCountryCode().toUpperCase().equals(TeamNameHelper.teamNameFilter(teamName).toUpperCase()))
                    {
                        teamFound = true;
                        break;
                    }
                }
                Assert.assertTrue(match.getHomeTeamId()+" not found",teamFound);
            }
        }
    }
}
