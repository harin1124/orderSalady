package orderSalady.nutritionComponent;

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
		ModelAndView mv=new ModelAndView("nutritionComponent/main");
		return mv;
	}
}