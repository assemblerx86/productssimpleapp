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
		PhoneDetails phoneDetails = new PhoneDetails(
			UUID.randomUUID().toString(),
			createPhoneCommand.getName(),
			createPhoneCommand.getSnippet()
		);
		phoneRepository.save(phoneDetails);
		return phoneDetails;
	}

	public void updatePhone() {
	}

	public void deletePhone(String id) {
	}
}
