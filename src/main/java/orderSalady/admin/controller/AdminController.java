package orderSalady.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@GetMapping("/main.do")
	public ModelAndView pageMenuReg(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mv=new ModelAndView("admin/main");
		return mv;
	}
}