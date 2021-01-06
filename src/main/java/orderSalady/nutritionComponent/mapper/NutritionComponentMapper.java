package orderSalady.nutritionComponent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import orderSalady.menu.domain.MenuNutritionVo;

@Mapper
public interface NutritionComponentMapper {
	List<MenuNutritionVo> selectMenuNutritionExtendList();
}