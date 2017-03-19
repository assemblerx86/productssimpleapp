/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phones;

//import org.springframework.web.bind.annotation.Service;

/**
 *
 * @author assembler
 */
//@Service
public class PhoneApplicationService {
	
	PhoneRepository phoneRepository;
	
	public PhoneApplicationService(PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}
	
	class CreatePhoneCommand {}
	
	public void createPhone(CreatePhoneCommand create) {
		//tu phone deteailes 
	}
	
	public void updatePhone() {
	}
	
	public void deletePhone(String id) {
	}
}
