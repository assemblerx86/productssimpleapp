package phones;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface PhoneRepository extends MongoRepository<PhoneDetails, String> {
	List<PhoneDetails> findByName(@Param("name") String name);
	PhoneDetails findById(@Param("id") String id);
}
