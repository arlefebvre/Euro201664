package fr.arlefebvre.pronostics.repo;

import fr.arlefebvre.pronostics.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by alefebvre on 06/04/2016.
 */
//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface TeamRepository extends MongoRepository<Team, String> {
    List<Team> findByName(@Param("name") String name);
}
