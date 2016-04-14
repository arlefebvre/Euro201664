package fr.arlefebvre.pronostics.repo;

import fr.arlefebvre.pronostics.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by alefebvre on 06/04/2016.
 */
//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByLogin(@Param("login") String login);

}
