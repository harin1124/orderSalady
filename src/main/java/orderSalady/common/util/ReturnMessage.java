package orderSalady.common.util;

import java.util.HashMap;

import lombok.Data;

@Data
public class ReturnMessage {
	/*
	{
		"state_code":200,
		"state_msg":"ok",
		"invalid":true,
		"message":{}
	}
	*/
	private int state_code;
	private String state_msg;
	private boolean invalid;
	private HashMap<String, Object> message;
	private Object obj;
	
	public ReturnMessage(){}
	
	public ReturnMessage(HashMap<String, Object> paramMap){
		this.state_code=Integer.valueOf(paramMap.get("state_code").toString());
		this.state_msg=paramMap.get("state_msg").toString();
		this.invalid=Boolean.valueOf(paramMap.get("invalid").toString());
		//this.obj=paramMap.get
	}
	/**
	 * @param state_code : HTTP STATE CODE 값
	 * @param state_msg : message
	 * @param invalid : 유효성 검사에 부적절한지. (부적절=true)
	 */
	public ReturnMessage(int state_code, String state_msg, boolean invalid, Object obj){
		this.state_code=state_code;
		this.state_msg=state_msg;
		this.invalid=invalid;
		this.obj=obj;
	}
}