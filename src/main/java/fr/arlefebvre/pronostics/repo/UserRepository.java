package fr.arlefebvre.pronostics.repo;

import java.util.List;

import fr.arlefebvre.pronostics.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by alefebvre on 06/04/2016.
 */
//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByLogin(@Param("login") String login);

}
