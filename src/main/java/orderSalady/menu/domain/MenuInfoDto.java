package orderSalady.menu.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class MenuInfoDto {
	private Integer rowSeq;
	private String koName;
	private String enName;
	private String menuDesc;
	private String veganYn;
	private Integer menuTypeSeq;
	private String menuTypeKoName;
	private Integer price;
	private String saleYn;
	private String salePeriodYn;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate saleStartDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate saleEndDate;
	private String discountYn;
	private Integer discountPrice;
	private String discountPeriodYn;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate discountStartDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate discountEndDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate regDate;
	private String delYn;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate delDate;
}