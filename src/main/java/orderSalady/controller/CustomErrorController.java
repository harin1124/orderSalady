package orderSalady.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {
	private static final String ERROR_PATH="/error";
	
	@Override
	public String getErrorPath(){
		return ERROR_PATH;
	}
	
	@RequestMapping("/error")
	public ModelAndView pageCustomError(HttpServletRequest req){
		ModelAndView mv=new ModelAndView("error/error");
		return mv;
	}
}