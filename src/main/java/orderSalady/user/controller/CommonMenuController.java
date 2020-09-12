package orderSalady.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/commonMenu")
public class CommonMenuController {
	@GetMapping("/main.do")
	public ModelAndView pageCommonMenuMain(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mv=new ModelAndView("user/commonMenu/main");
		return mv;
	}
}