package orderSalady.menu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
	
	@GetMapping("/list")
	public ModelAndView pageMenuMain(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mv=new ModelAndView("menu/list");
		return mv;
	}
	
	@GetMapping("/{menuRowSeq}")
	public ModelAndView pageMenuDetail(@PathVariable("menuRowSeq") int rowSeq){
		ModelAndView mv=new ModelAndView("menu/detail");
		mv.addObject("rowSeq", rowSeq);
		return mv;
	}
}