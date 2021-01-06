package orderSalady.nutritionComponent.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import orderSalady.common.domain.ResponseDto;
import orderSalady.menu.domain.MenuNutritionDto;
import orderSalady.nutritionComponent.service.NutritionComponentService;

@RestController
@RequestMapping("/nutritionComponent")
@RequiredArgsConstructor
public class NutritionComponentRestController {
	private final NutritionComponentService nutritionComponentService;
	
	@GetMapping("/getMenuNutritionList")
	public ResponseDto<List<MenuNutritionDto>> getMenuNutritionList(){
		return ResponseDto.ok(nutritionComponentService.getMenuNutritionList());
	}
}