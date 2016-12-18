package main.java.products;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class HelloController {
    private MongoClient mongoClient;
    private MongoDatabase db;
    

    public HelloController() {
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("phones");	
    }
    
    @RequestMapping("/")
    public String index(HttpServletResponse response) {
        return "Spring Boot app";
    }

	private String outSet = "";
	private int limitCounter = 0;
	
    @RequestMapping("/phones/all")
    public String all(HttpServletResponse response) {
		setJSONHeaders(response);

		FindIterable<Document> iterable = db.getCollection("list").find();
		outSet = "[";
		iterable.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document) {
				outSet += document.toJson();
				outSet += ",";
			}
		});
		outSet = outSet.replaceFirst("(.*),$", "$1");
		outSet += "]";
		return outSet;
    }

	@RequestMapping("/phones/{phoneId}")
	public String getPhoneById(@PathVariable("phoneId") String phoneId, HttpServletResponse response) {
		setJSONHeaders(response);

		FindIterable<Document> iterable = db.getCollection("items").find(
			new Document("id", phoneId)
		);
		outSet = "";
		iterable.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document) {
				outSet += document.toJson();
			}
		});
		return outSet;
	}

	private void setJSONHeaders(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8383");
	}
}
