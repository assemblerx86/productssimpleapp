/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phones;

import java.util.List;
import java.lang.Exception;
import phones.PhoneApplicationService;
import phones.PhoneDetails;
import phones.PhoneRepository;


public class PhoneApplicationServiceTest {/* @Patryk
	PhoneApplicationService phoneService;

	class PhoneRepositoryStub implements PhoneRepository {

		private boolean deleted = false;
		

		@Override
		public List<PhoneDetails> findByName(@Param("name") String name) {
			//throw new Exception("Not supported yet."); // UnsupportedOperation @patryk
		}
		
		
		// wszystko z mongo tez
		// IDE skonfigurowac
	
		public void deletePhone(String id) {
			if (id == "1") {
				deleted = true;
			}
		}
		
		public boolean isDeleted() {
			return deleted;
		}
	}

	public void test() {
		
		// given
		PhoneRepositoryStub phoneRepositoryStub = new PhoneRepositoryStub();
		phoneService = new PhoneApplicationService(phoneRepositoryStub);
		// when
		phoneService.deletePhone("1");
		// then
		//assertTrue(phoneService.isDeleted()); // @Patryk
	}*/
}
