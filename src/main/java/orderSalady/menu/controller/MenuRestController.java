package orderSalady.menu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import orderSalady.common.domain.ResponseDto;
import orderSalady.menu.domain.MenuInfoDto;
import orderSalady.menu.domain.MenuNutritionDto;
import orderSalady.menu.service.MenuService;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuRestController {
	private final MenuService menuService;
	
	@PostMapping("/allList")
	public ResponseDto<List<MenuInfoDto>> menuAllList(){
		return ResponseDto.ok(menuService.menuAllList());
	}
	
	@PostMapping("/detail/{rowSeq}")
	public ResponseDto<MenuInfoDto> menuDetail(@PathVariable("rowSeq") int rowSeq){
		MenuInfoDto param=MenuInfoDto.builder().rowSeq(rowSeq).build();
		return ResponseDto.ok(menuService.menuDetail(param));
	}
	
	@PostMapping("/nutrition/{rowSeq}")
	public ResponseDto<MenuNutritionDto> menuNutrition(@PathVariable("rowSeq") int rowSeq){
		MenuNutritionDto param=MenuNutritionDto.builder().menuInfoSeq(rowSeq).build();
		return ResponseDto.ok(menuService.menuNutrition(param));
	}
}