package orderSalady.common.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {
	/*
	OK : 성공
	NO_AUTH : 권한 없음
	BAD_REQUEST : 잘못된 요청
	INTERNAL_SERVER_ERROR : 서버 에러
	CRUD_ERROR : CRUD 에러
	ETC_ERROR : 그 외 에러
	*/
	OK("0000", "OK"),
	NO_AUTH("0001", "NO_AUTH"),
	BAD_REQUEST("1400", "BAD_REQUEST"),
	INTERNAL_SERVER_ERROR("1500", "INTERNAL_SERVER_ERROR"),
	CRUD_ERROR("1501", "CRUD_ERROR"),
	ETC_ERROR("9999", "ETC_ERROR");

	private final String code;
	private final String message;
}
