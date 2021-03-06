package phones;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import static java.util.Arrays.asList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/phones")
public class PhonesController {
	private PhoneRepository phoneRepository;
	private PhoneApplicationService phoneApplicationService;
	
	@Autowired
    public PhonesController(PhoneRepository phoneRepository, PhoneApplicationService phoneApplicationService) {
		this.phoneRepository = phoneRepository;
		this.phoneApplicationService = phoneApplicationService;
    }

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<PhoneDetails> list() {
		return phoneRepository.findAll();
	}

	@RequestMapping("/{phoneId}")
	@ResponseBody
	public PhoneDetails getPhoneById(@PathVariable("phoneId") String phoneId, HttpServletResponse response) {
		return phoneRepository.findById(phoneId);
	}

	@RequestMapping("/create")
	@ResponseBody
	public PhoneDetails createPhone(CreatePhoneCommand createPhoneCommand) {
		return phoneApplicationService.createPhone(createPhoneCommand);
	}
}
