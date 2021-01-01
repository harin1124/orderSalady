package orderSalady.nutritionComponent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/nutritionComponent")
@RequiredArgsConstructor
public class NutritionComponentController {
	@GetMapping("/main")
	public ModelAndView pageNutritionComponentMain(){
		System.out.println("컨트롤러 진입..");
		ModelAndView mv=new ModelAndView("nutritionComponent/main");
		return mv;
	}
}