package orderSalady.menu.mapper;

import org.apache.ibatis.annotations.Mapper;

import orderSalady.menu.domain.MenuNutritionDto;
import orderSalady.menu.domain.MenuNutritionVo;

@Mapper
public interface MenuNutritionMapper {
	MenuNutritionVo selectMenuNutrition(MenuNutritionDto param);
}