package orderSalady.user.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import orderSalady.common.util.ApiRequest;
import orderSalady.user.domain.UserJoinDto;

@Service
@RequiredArgsConstructor
public class UserService {
	public void actionJoin(UserJoinDto param)throws Exception{
		
		// POST TEST
		// 성공
		//ApiRequest.post("/user/join", param, HashMap.class);
		
		//ApiResponseDto<Integer> x2=ApiRequest.put("/user/join", Util.domainToQueryStringExport(param, null));
		
		// GET TEST
		//String queryString=Util.domainToQueryStringExport(param, null);
		//System.out.println(ApiRequest.get("/user/join", queryString));
		
		// PUT TEST
		//System.out.println(ApiRequest.put("/user/join", param));
		
		// DELETE TEST
		//System.out.println(ApiRequest.delete("/user/join", param));
		System.out.println(ApiRequest.post("/user/join", param));
		//ApiRequest.put("/user/join", param);
		//ApiRequest.delete("/user/join", param);
	} 
}