package fr.arlefebvre.pronostics.repo;

import fr.arlefebvre.pronostics.model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Arthur on 10/04/2016.
 */
public interface MatchRepository extends MongoRepository<Match,String>{
}
