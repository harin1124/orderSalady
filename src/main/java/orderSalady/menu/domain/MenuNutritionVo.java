package orderSalady.menu.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@Alias("MenuNutritionVo")
@NoArgsConstructor
@AllArgsConstructor
public class MenuNutritionVo {
	private Integer rowSeq;
	private Integer menuTypeSeq;
	private String menuTypeKoName;
	private Integer menuInfoSeq;
	private String menuInfoKoName;
	private Integer capacity;
	private Integer calories;
	private Integer carbohydrate;
	private Integer sugar;
	private Integer protein;
	private Integer fat;
	private Integer transFat;
	private Integer saturatedFat;
	private Integer cholesterol;
	private Integer sodium;
}