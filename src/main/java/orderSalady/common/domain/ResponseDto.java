package orderSalady.common.domain;

import static lombok.AccessLevel.PRIVATE;
import static orderSalady.common.domain.ResponseCode.OK;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(access=PRIVATE)
@AllArgsConstructor(access=PRIVATE)
public class ResponseDto<T> {
	private final String code;
	private final String message;
	private T contents;
	
	public static <T> ResponseDto<T> of(ResponseCode responseCode) {
		return new ResponseDto<>(responseCode.getCode(), responseCode.getMessage(), null);
	}

	public static <T> ResponseDto<T> of(ResponseCode responseCode, T contents) {
		return new ResponseDto<>(responseCode.getCode(), responseCode.getMessage(), contents);
	}

    public static <T> ResponseDto<T> ok(T contents) {
        return of(OK, contents);
    }
}