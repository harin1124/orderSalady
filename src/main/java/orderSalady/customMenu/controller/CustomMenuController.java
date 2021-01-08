package orderSalady.customMenu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/customMenu")
@RequiredArgsConstructor
public class CustomMenuController {
	@GetMapping("/main")
	public ModelAndView pageCustomMenuMain(){
		ModelAndView mv=new ModelAndView("customMenu/main");
		return mv;
	}
}