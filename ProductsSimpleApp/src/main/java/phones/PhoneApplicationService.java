package phones;

import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PhoneApplicationService {
	
	PhoneRepository phoneRepository;
	
	public PhoneApplicationService(PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}
	
	public PhoneDetails createPhone(CreatePhoneCommand createPhoneCommand) {
		PhoneDetails phoneDetails = new PhoneDetails();
		phoneDetails.setId(UUID.randomUUID().toString());
		phoneDetails.setName(createPhoneCommand.getName());
		phoneDetails.setSnippet(createPhoneCommand.getSnippet());
		phoneRepository.save(phoneDetails);
		return phoneDetails;
	}

	public void updatePhone() {
	}

	public void deletePhone(String id) {
	}
}
