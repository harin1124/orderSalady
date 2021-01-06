package orderSalady.menu.util;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import orderSalady.menu.domain.MenuInfoDto;
import orderSalady.menu.domain.MenuInfoVo;
import orderSalady.menu.domain.MenuNutritionDto;
import orderSalady.menu.domain.MenuNutritionVo;

@Component
public class MenuUtil {
	public Function<MenuInfoVo,MenuInfoDto> ConvertMenuInfoVoToDto(){
		return i -> MenuInfoDto.builder()
			.rowSeq(i.getRowSeq()).koName(i.getKoName()).enName(i.getEnName()).menuDesc(i.getMenuDesc())
			.veganYn(i.getVeganYn())
			.menuTypeSeq(i.getMenuTypeSeq()).menuTypeKoName(i.getMenuTypeKoName())
			.price(i.getPrice())
			.saleYn(i.getSaleYn()).salePeriodYn(i.getSalePeriodYn()).saleStartDate(i.getSaleStartDate()).saleEndDate(i.getSaleEndDate())
			.discountYn(i.getDiscountYn()).discountPrice(i.getDiscountPrice()).discountPeriodYn(i.getDiscountPeriodYn()).discountStartDate(i.getDiscountStartDate()).discountEndDate(i.getDiscountEndDate())
			.regDate(i.getRegDate())
			.delYn(i.getDelYn()).delDate(i.getDelDate())
	  	.build();
	}
	
	public Function<MenuNutritionVo,MenuNutritionDto> ConvertMenuNutritionVoToDto(){
		return i -> MenuNutritionDto.builder()
			.rowSeq(i.getRowSeq())
			.menuTypeSeq(i.getMenuTypeSeq())
			.menuTypeKoName(i.getMenuTypeKoName())
			.menuInfoSeq(i.getMenuInfoSeq())
			.menuInfoKoName(i.getMenuInfoKoName())
			.capacity(i.getCapacity())
			.calories(i.getCalories())
			.carbohydrate(i.getCarbohydrate())
			.sugar(i.getSugar())
			.protein(i.getProtein())
			.fat(i.getFat())
			.transFat(i.getTransFat())
			.saturatedFat(i.getSaturatedFat())
			.cholesterol(i.getCholesterol())
			.sodium(i.getSodium())
		.build();
	}
}