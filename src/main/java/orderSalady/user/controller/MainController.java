package orderSalady.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@GetMapping("/")
	public ModelAndView pageMain(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mv=new ModelAndView("user/main");
		return mv;
	}
	
	/*
	20200725 TEST
	@GetMapping("/")
	public ModelAndView pageMain(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mv=new ModelAndView("/main/mainPage");
		
		RestTemplate restTemplate=new RestTemplate();
	    // REST API 호출
		HashMap<String, Object> r=(HashMap<String, Object>)restTemplate.getForObject("http://localhost:8090/menu/list?userId=반도", Map.class);
		System.out.println("페이지에 내보낼 결과 : "+r);
		return mv;
	}
	
	@PostMapping("/post")
	public ModelAndView pagePost(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mv=new ModelAndView("/main/mainPage");
		
		RestTemplate restTemplate=new RestTemplate();
		HashMap<String, Object> mvMap=new HashMap<>();
		mvMap.put("샐러디", "좋아요");
		
		HashMap<String, Object> a=restTemplate.postForObject("http://localhost:8090/menu/list2", mvMap, HashMap.class);
		System.out.println("API 결과값 : "+a);
		return mv;
	}
	*/
}