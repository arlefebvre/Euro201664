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

import fr.arlefebvre.pronostics.model.Match;
import fr.arlefebvre.pronostics.model.Team;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur on 14/04/2016.
 */
@RestController
public class EuroMatchListController {
    private ArrayList<Match> pseudoCache;

    @RequestMapping("/euro2016/matches")
    public List<Match> matches() {
        if(pseudoCache!=null && !pseudoCache.isEmpty())
            return pseudoCache;
        ArrayList<Match> result = new ArrayList<Match>();
        String uri = "http://www.lequipe.fr/Football/Euro/Saison-2016/calendrier-resultats.html";

        //On se connecte au site et on charge le document html

        Document doc;
        try {
            doc = Jsoup.connect(uri).get();

            Elements elements= doc.getElementsByClass("mainDate");
            for (Element element : elements) {
                Element title = element.getElementsByClass("title").first();
                String date = title.text();

                Element tbody = element.getElementsByTag("tbody").first();
                for (Element matchElement : tbody.children()) {
                    String groupe = matchElement.getElementsByClass("date").first().text();
                    String home = matchElement.getElementsByClass("domicile").first().text();
                    String away = matchElement.getElementsByClass("exterieur").first().text();

                    Match m = new Match();
                    m.setDate(date);
                    m.setHomeTeamId(home);
                    m.setAwayTeamId(away);
                    m.setGroup(groupe);
                    result.add(m);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(pseudoCache == null)
            pseudoCache = result;
        return result;
    }
}
