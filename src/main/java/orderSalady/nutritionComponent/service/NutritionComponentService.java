package orderSalady.nutritionComponent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import orderSalady.menu.domain.MenuNutritionDto;
import orderSalady.menu.domain.MenuNutritionVo;
import orderSalady.menu.util.MenuUtil;
import orderSalady.nutritionComponent.mapper.NutritionComponentMapper;

@Service
@RequiredArgsConstructor
public class NutritionComponentService {
	private final MenuUtil menuUtil;
	private final NutritionComponentMapper nutritionComponentMapper;
	
	public List<MenuNutritionDto> getMenuNutritionList(){
		List<MenuNutritionVo> result=nutritionComponentMapper.selectMenuNutritionExtendList();
		List<MenuNutritionDto> returnResult=new ArrayList<MenuNutritionDto>();
		result.forEach(vo->{
			returnResult.add(menuUtil.ConvertMenuNutritionVoToDto().apply(vo));
		});
		return returnResult;
	}
}