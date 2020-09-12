package orderSalady.admin.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import orderSalady.admin.service.AdminMenuService;
import orderSalady.util.Util;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/menu")
public class AdminMenuController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	private final Util util;
	private final AdminMenuService adminMenuService;
	
	// PAGE | 목록
	@GetMapping("/list.do")
	public ModelAndView pageAdminMenuList(@RequestParam(defaultValue="1") int pageNo)throws Exception{
		ModelAndView mv=new ModelAndView("admin/menu/list");
		HashMap<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("PAGE_NO", pageNo);
		adminMenuService.pageAdminMenuList(paramMap, mv);
		return mv;
	}
	
	// PAGE | 목록 내 메뉴 삭제
	@PostMapping("/delete.do")
	public String pageAdminMenuList(@RequestParam HashMap<String, Object> paramMap)throws Exception{
		return util.redirectUrl("admin/menu/list.do?pageNo=");
	}
	
	// PAGE | 등록
	@GetMapping("/reg.do")
	public ModelAndView pageAdminMenuReg()throws Exception{
		ModelAndView mv=new ModelAndView("admin/menu/reg");
		mv.addObject("PAGE_TYPE", "REG");
		adminMenuService.pageAdminMenuReg(mv);
		return mv;
	}

	// PAGE | 등록 액션
	@PostMapping("/reg.do")
	public String actionAdminMenuReg(@RequestParam HashMap<String, Object> paramMap)throws Exception{
		log.debug("PARAM MAP : "+paramMap);
		// TODO : 유효성 검사 실행
		adminMenuService.actionAdminMenuReg(paramMap);
		return util.redirectUrl("admin/menu/list.do");
	}
		
	// PAGE | 수정
	@GetMapping("/edit.do")
	public ModelAndView pageAdminMenuEdit(@RequestParam int rowSeq)throws Exception{
		ModelAndView mv=new ModelAndView("admin/menu/reg");
		adminMenuService.pageAdminMenuEdit(mv, rowSeq);
		mv.addObject("PAGE_TYPE", "EDIT");
		return mv;
	}
	
	// PAGE | 수정 액션
	@PostMapping("/edit.do")
	public String actionAdminMenuEdit(@RequestParam HashMap<String, Object> paramMap)throws Exception{
		return util.redirectUrl("admin/menu/list.do");
	}
	
}