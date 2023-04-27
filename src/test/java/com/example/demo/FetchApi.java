package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

//import java.net.http.HttpHeaders;



//@ComponentScan(basePackageClasses = AppConfig.class)


@RunWith(SpringRunner.class)
@SpringBootTest
class FetchApi {

	@Value("${my.api.token}")
	private String myApiToken;

	@Test
	void getRequest() throws UnsupportedEncodingException {
		String location = "New York City";
		String url = "https://api.yelp.com/v3/businesses/search?location=" + URLEncoder.encode(location, "UTF-8");

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(myApiToken);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		String responseBody = response.getBody();
		System.out.println(responseBody);
	}
}
