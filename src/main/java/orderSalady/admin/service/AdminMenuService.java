package orderSalady.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import orderSalady.util.Util;

@Service
@RequiredArgsConstructor
@PropertySource({"classpath:global.properties"})
public class AdminMenuService {
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	private final Util util;
	private final RestTemplate restTemplate;
	
	@Value("${paging.pageCnt}")
	private String pageCnt;

	@SuppressWarnings("unchecked")
	public void pageAdminMenuList(HashMap<String, Object> paramMap, ModelAndView mv)throws Exception{
		// 등록 메뉴 목록
		ArrayList<HashMap<String, Object>> menuList=new ArrayList<HashMap<String, Object>>();
		//OPTION_PAGE_CONTENT_SIZE = 한 페이지에 컨텐츠 몇 개를 가져올 것인지, 만약 해당 키가 없다면, API 서버는 자동적으로 10개만 가져옴
		paramMap.put("OPTION_PAGE_CONTENT_SIZE", pageCnt);
		menuList=restTemplate.postForObject(util.getApiUrl()+"/admin/menu/menu-list", paramMap, ArrayList.class);
		
		// 등록 메뉴 페이징 정보
		HashMap<String, Object> pagingInfo=new HashMap<String, Object>();
		pagingInfo=restTemplate.postForObject(util.getApiUrl()+"/admin/menu/menu-list/paging", paramMap, HashMap.class);
		
		mv.addObject("MENU_LIST", menuList);
		mv.addObject("PAGING_INFO", pagingInfo);
	}
	
	@SuppressWarnings("unchecked")
	public void pageAdminMenuReg(ModelAndView mv)throws Exception{
		HashMap<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("OPTION", "N");
		
		// 메뉴 타입 목록 가져오기
		String menuTypeList=restTemplate.getForObject(util.getApiUrl()+"/admin/menu/menu-type-list", String.class, paramMap);
		System.out.println("문자열 : "+menuTypeList);
		
		Gson gson=new Gson();
		/*
		JSONObject obj=null;
        try {
             obj=(JSONObject)parser.parse(menuTypeList);
        } catch (ParseException e){
             System.out.println("변환에 실패");
             e.printStackTrace();
        }
        System.out.println("OBJ : "+obj);
        System.out.println("OBJ : "+obj.getClass());
        */
		


		
		mv.addObject("MENU_TYPE_LIST", menuTypeList);
	}
	
	public int actionAdminMenuReg(HashMap<String, Object> paramMap)throws Exception{
		int returnResult=0;
		// TODO : 유효성 검사 코드 필요
		returnResult=restTemplate.postForObject(util.getApiUrl()+"/admin/menu/save", paramMap, int.class);
		return returnResult;
	}
	
	public void pageAdminMenuEdit(ModelAndView mv, int rowSeq)throws Exception{
		HashMap<String, Object> menuInfo=new HashMap<String, Object>();
		menuInfo=restTemplate.getForObject(util.getApiUrl()+"/admin/menu/"+rowSeq, HashMap.class);
		mv.addObject("MENU_INFO", menuInfo);
	}
}