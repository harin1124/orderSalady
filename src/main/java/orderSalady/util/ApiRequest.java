package orderSalady.util;

import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiRequest {
	private final static String API="http://localhost:8090";
	
	public static String get(String uri){
		return new RestTemplate().getForObject(API+uri, String.class);
	}
	public static String get(String uri, HashMap<String, Object> param){
		return new RestTemplate().getForObject(API+uri, String.class, param);
	}
	
	public static String post(String uri, HashMap<String, Object> paramMap){
		return new RestTemplate().postForObject(API+uri, paramMap, String.class);
	}
	public static String post(String uri){
		return new RestTemplate().postForObject(API+uri, null, String.class);
	}
	
	public static String put(String uri, HashMap<String, Object> paramMap){
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> httpEntity=new HttpEntity<>(paramMap, httpHeaders);
		ResponseEntity<String> req=new RestTemplate().exchange(API+uri, HttpMethod.PUT, httpEntity, String.class);
		return req.getBody();
	}
	
	public static String delete(String uri, HashMap<String, Object> paramMap){
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> httpEntity=new HttpEntity<>(paramMap, httpHeaders);
		ResponseEntity<String> req=new RestTemplate().exchange(API+uri, HttpMethod.DELETE, httpEntity, String.class);
		return req.getBody();
	}
}