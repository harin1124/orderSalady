package orderSalady.menu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import orderSalady.menu.domain.MenuInfoDto;
import orderSalady.menu.domain.MenuInfoVo;
import orderSalady.menu.domain.MenuNutritionDto;
import orderSalady.menu.domain.MenuNutritionVo;
import orderSalady.menu.mapper.MenuInfoMapper;
import orderSalady.menu.mapper.MenuNutritionMapper;
import orderSalady.menu.util.MenuUtil;

@Service
@RequiredArgsConstructor
public class MenuService {
	private final MenuInfoMapper menuInfoMapper;
	private final MenuNutritionMapper menuNutritionMapper;
	private final MenuUtil menuUtil;
	
	public List<MenuInfoDto> menuAllList(){
		List<MenuInfoVo> result=menuInfoMapper.selectMenuInfoAllList();
		List<MenuInfoDto> returnResult=new ArrayList<MenuInfoDto>();
		result.forEach(vo->{
			returnResult.add(menuUtil.ConvertMenuInfoVoToDto().apply(vo));
		});
		return returnResult;
	}
	
	public MenuInfoDto menuDetail(MenuInfoDto param){
		MenuInfoVo result=menuInfoMapper.selectMenuInfo(param);
		return menuUtil.ConvertMenuInfoVoToDto().apply(result);
	}
	
	public MenuNutritionDto menuNutrition(MenuNutritionDto param){
		MenuNutritionVo result=menuNutritionMapper.selectMenuNutrition(param);
		return (result==null)?null:menuUtil.ConvertMenuNutritionVoToDto().apply(result);
	}
}