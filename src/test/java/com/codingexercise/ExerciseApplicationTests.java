package com.codingexercise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.codingexercise.controller.MessageController;
import com.codingexercise.model.Greeting;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExerciseApplication.class)
@WebIntegrationTest
public class ExerciseApplicationTests {
		
	RestTemplate restTemplate = new TestRestTemplate();	
	
	@Autowired
	MessageController messageController;
	
	@Test
	public void controller_return_world() {		
		Greeting greeting = this.restTemplate.getForObject(
		            "http://localhost:8080/hello", Greeting.class);
		Assert.assertEquals("world", greeting.getHello());
		
	}
	
	
}
