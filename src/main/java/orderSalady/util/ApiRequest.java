package orderSalady.util;

import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
	
	public static void put(String uri, HashMap<String, Object> paramMap){
		//new RestTemplate().exchange(url, method, requestEntity, responseType)
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// PARAM MAP을 유지하여 PUT으로 보내는 법.. 현재 API 서버에서는 인식하지 못하는 중
		HttpEntity<HashMap> httpEntity=new HttpEntity<HashMap>(paramMap, headers);
		System.out.println("보내는 파라미터 : "+paramMap);
		
		new RestTemplate().exchange(API+uri, HttpMethod.PUT, httpEntity, String.class, paramMap);
		//new RestTemplate().put(API+uri, paramMap);
	}
	
	public static void delete(String uri, HashMap<String, Object> paramMap){
		new RestTemplate().delete(API+uri, paramMap);
	}
}