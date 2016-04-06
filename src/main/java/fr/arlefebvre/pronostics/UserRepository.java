package fr.arlefebvre.pronostics;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by alefebvre on 06/04/2016.
 */
//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByLastName(@Param("name") String name);

}
