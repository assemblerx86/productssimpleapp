/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phones;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface PhoneRepository extends MongoRepository<PhoneDetails, String> {
	List<PhoneDetails> findByName(@Param("name") String name);
	PhoneDetails findById(@Param("id") String id);
}
