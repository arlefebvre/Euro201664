package fr.arlefebvre.pronostics.controller;

import fr.arlefebvre.pronostics.model.Team;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alefebvre on 08/04/2016.
 */
@RestController
public class UEFATeamsController {

    @RequestMapping("/uefa/teams")
    public List<Team> teams() {
        ArrayList<Team> result = new ArrayList<Team>();
        String uri = "http://fr.fifa.com/fifa-world-ranking/ranking-table/men/uefa.html";

        //On se connecte au site et on charge le document html

        Document doc = null;
        try {
            doc = Jsoup.connect(uri).get();
            //On récupère dans ce document la premiere balise ayant comme nom h1 et pour attribut class="title"
            //"table tbl-ranking table-striped"
            Elements elements= doc.getElementsByClass("table");
            for (Element element : elements) {
                Element tbody = element.getElementsByTag("tbody").first();
                for (Element child : tbody.children()) {
                    Element teamNameElement = child.getElementsByClass("tbl-teamname").first();
                    String name =  teamNameElement.text();
                    String countryCode =  child.getElementsByClass("tbl-countrycode").first().text();
                    String imgUrl = teamNameElement.select("img").first().absUrl("src");
                    Team team = new Team();
                    team.setName(name);
                    team.setCountryCode(countryCode);
                    team.setImgUrl(imgUrl);
                    team.setNationalTeam(true);
                    result.add(team);
                }
            }


            //String titre =  element.text();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<ChampionListDto> response = restTemplate.getForEntity(
//                uri,
//                ChampionListDto.class);
//
//        List<ChampionDto> champions = response.getBody().getChampions();
//        return champions.stream().map(c -> getChampionById(c.getId()).getName()).collect(Collectors.toList());
        result.sort((t1,t2)->t1.getName().compareTo(t2.getName()));
        return result;
    }
}
