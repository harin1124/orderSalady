package orderSalady.util;

import org.springframework.stereotype.Component;

@Component
public class Util {
	/**
	 * 리다이렉트 주소
	*/
	public String redirectUrl(String url){
		return "redirect:/"+url;
	}
	
	/** 
	 * API 서버 주소
	*/
	public String getApiUrl(){
		return "http://localhost:8090";
	}
}