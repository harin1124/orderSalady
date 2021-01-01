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
		ModelAndView mv=new ModelAndView("main");
		return mv;
	}
}