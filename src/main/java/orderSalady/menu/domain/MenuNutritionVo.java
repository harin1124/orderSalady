package orderSalady.menu.domain;

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
@NoArgsConstructor
@AllArgsConstructor
public class MenuNutritionVo {
	private Integer rowSeq;
	private Integer menuInfoSeq;
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