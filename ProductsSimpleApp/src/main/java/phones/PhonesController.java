package main.java.phones;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/phones/") //{phoneId}
public class PhonesController {
    private MongoClient mongoClient;
    private MongoDatabase db;
    

    public PhonesController() {
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("phones");	
    }
    
    @RequestMapping("/")
    public String index(HttpServletResponse response) {
        return "Spring Boot app";
    }

// TODO tu powinno być
//+    @RequestMapping("/")^M
//+    public List<PhoneList> String all(HttpServletResponse response) {

    @RequestMapping("/all")
    public String all(HttpServletResponse response) {
		setJSONHeaders(response);

		StringBuffer outSet = new StringBuffer();
		
		FindIterable<Document> iterable = db.getCollection("list").find();
		outSet.append("[");
		iterable.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document) {
				outSet.append(document.toJson());
				outSet.append(",");
			}
		});
		String out = outSet.toString().replaceFirst("(.*),$", "$1");
		out += "]";
		return out;
    }

	// TODO: zwracać PhoneDetails obiekt a nie String
	@RequestMapping("/{phoneId}")
	@ResponseBody
	public String getPhoneById(@PathVariable("phoneId") String phoneId, HttpServletResponse response) {
		setJSONHeaders(response);

		FindIterable<Document> iterable = db.getCollection("items").find(
			new Document("id", phoneId)
		);

		StringBuffer outSet = new StringBuffer();
		iterable.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document) {
				outSet.append(document.toJson());
			}
		});
		return outSet.toString();
	}

	private void setJSONHeaders(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8383");
	}
}
