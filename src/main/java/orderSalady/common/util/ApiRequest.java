package orderSalady.common.util;

import java.util.HashMap;

import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiRequest {
	
	private static String API_URL="http://localhost:8090/";
	
	public static RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	public static String paramMapToString(HashMap<String, Object> paramMap){
		StringBuilder builder=new StringBuilder();
		for(String s:paramMap.keySet()){
			builder.append(s).append("=").append(paramMap.get(s)).append("&");
		}
		return builder.toString();
	}
	
	public static HashMap<?, ?> get(String path, String param){
		return restTemplate().getForObject(API_URL+path+param, HashMap.class);
	}
	public static HashMap<?, ?> get(String path, HashMap<String, Object> param){
		return restTemplate().getForObject(API_URL+path+paramMapToString(param), HashMap.class);
	}
	
	public static HashMap<?, ?> post(String path, Object param){
		return restTemplate().postForObject(API_URL+path, param, HashMap.class);
	}
	
	public static void put(String path, Object param){
		restTemplate().put(API_URL+path, param);
	}
	
	public static void delete(String path, Object param){
		restTemplate().delete(API_URL+path, param);
	}
}