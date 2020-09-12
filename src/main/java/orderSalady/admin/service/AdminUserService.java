package orderSalady.admin.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import orderSalady.util.Util;

@Service
public class AdminUserService {
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Util util;
	
	@Autowired
	PasswordEncoder cryptEncoder;
	
	@Autowired
	RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	public int actionAdminLogin(HttpSession session, HashMap<String, Object> paramMap)throws Exception{
		HashMap<String, Object> resultMap=new HashMap<String, Object>();
		int loginChk=0;
		// TODO : 유효성 검사 코드 필요
		resultMap=restTemplate.postForObject(util.getApiUrl()+"/admin/user/login", paramMap, HashMap.class);
		//if(resultMap.size()==1 && resultMap.get("userPassword")!=null){
		if(resultMap!=null){
			boolean pwMatch=cryptEncoder.matches(paramMap.get("userPassword").toString(), resultMap.get("userPassword").toString());
			if(pwMatch){
				resultMap.remove("userPassword");
				session.setAttribute("userInfo", resultMap);
				loginChk=1;
			}
		}
		return loginChk;
	}
	
	public int actionAdminJoin(HashMap<String, Object> paramMap)throws Exception{
		int returnResult=0;
		// TODO : 유효성 검사 코드 필요
		paramMap.put("userPassword", cryptEncoder.encode(paramMap.get("userPassword").toString()));
		returnResult=restTemplate.postForObject(util.getApiUrl()+"/admin/user/join", paramMap, int.class);
		return returnResult;
	}
}