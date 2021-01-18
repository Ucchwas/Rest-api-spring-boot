package com.example.demo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import ch.qos.logback.core.net.server.Client;

@RestController

public class UiCon {
	private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
	
	@Autowired
	public RestTemplate restTemplate;
	
	@RequestMapping("/weather")
	
	@GetMapping()
	public String getWeather(@RequestParam(value="q") String q) {
		String[] words = q.split("\\W+");
		String city = words[words.length-1];
		String what = words[4];
		String ask = words[2];
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String api = "67fb98b514a7781a2cd33a9b86597c27"; //User Api Key
		String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+api;
		ResponseEntity<OpenWeatherResponse> response = restTemplate.getForEntity(url, OpenWeatherResponse.class);
		if(what.equals("temperature")) {
			String temp = response.getBody().getMain().getTemp();
			return temp;
		}
		if(what.equals("humidity")) {
			String humid = response.getBody().getMain().getHumidity();
			return humid;
		}
		if(ask.equals("Clouds") || ask.equals("Rain") || ask.equals("Clear")){
			ResponseEntity<NewOpenWeather> res = restTemplate.getForEntity(url, NewOpenWeather.class);
			String w = res.getBody().getWeather().getmain();
			return w;
		}
		return "Don't know";
	}
	
	@RequestMapping("/qa")
	
	@GetMapping()
	public String getQa(@RequestParam(value="q") String q) {
		q = encodeValue(q);
		String res1 = "Who is the president of Bangladesh?";
		res1 = encodeValue(res1);
		if(q.equals(res1))
			return "Abdul Hamid";
		String res2 = "How old is Putin?";
		res2 = encodeValue(res2);
		if(q.equals(res2))
			return "68 years";
		String res3 = "How long is the Titanic movie?";
		res3 = encodeValue(res3);
		if(q.equals(res3))
			return "210 minutes";
		String res4 = "What is the prime language of Bangladesh?";
		res4 = encodeValue(res4);
		if(q.equals(res4))
			return "Bengali";
		String res5 = "Who is the current CEO of Google?";
		res5 = encodeValue(res5);
		if(q.equals(res5))
			return "Sundar Pichai";
		return "Your majesty! Jon Snow knows nothing! So do I!";
	}
	
	@RequestMapping("/greetings")
	
	@GetMapping()
	public String getGreetings(@RequestParam(value="q") String q) {
		q = encodeValue(q);
		String res1 = "Hello! How are you?";
		res1 = encodeValue(res1);
		if(q.equals(res1))
			return "Hello, Corona! I am fine,you?";
		String res2 = "Hi! What is your name?";
		res2 = encodeValue(res2);
		if(q.equals(res2))
			return "My name is Ucchwas";
		String res3 = "Good morning! I am Corona! It’s a pleasure to meet you!";
		res3 = encodeValue(res3);
		if(q.equals(res3))
			return "Good morning! Nice to meet you";
		return "See you next time,I have to go";
	}
}
