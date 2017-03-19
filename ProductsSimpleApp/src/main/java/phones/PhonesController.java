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
@RequestMapping("/phones") //{phoneId}
public class PhonesController {
	private PhoneRepository phoneRepository;
	
	@Autowired
    public PhonesController(PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
    }

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<PhoneDetails> list() {
		return phoneRepository.findAll();
	}
}
// 