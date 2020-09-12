package orderSalady.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/nutrientComponent")
public class NutrientComponentController {
	
	@GetMapping("/main.do")
	public ModelAndView pageNutrientComponentMain(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mv=new ModelAndView("user/nutrientComponent/main");
		return mv;
	}
}