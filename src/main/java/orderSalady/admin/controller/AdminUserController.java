package orderSalady.admin.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import orderSalady.admin.service.AdminUserService;
import orderSalady.util.Util;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	Util util;
	
	@Autowired
	AdminUserService adminUserService;
	
	@GetMapping("/login.do")
	public ModelAndView pageAdminLogin(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mv=new ModelAndView("admin/user/login");
		return mv;
	}
	
	@PostMapping("/login.do")
	public String actionAdminLogin(HttpServletRequest req, HttpServletResponse res, HttpSession session, @RequestParam HashMap<String, Object> paramMap)throws Exception{
		String url="";
		log.debug("PARAM MAP : "+paramMap);
		int loginChk=adminUserService.actionAdminLogin(session, paramMap);
		url=(loginChk==1)?"admin/main.do":"admin/user/login.do";
		return util.redirectUrl(url);
	}
	
	@GetMapping("/logout.do")
	public String actionAdminLogout(HttpSession session){
		session.invalidate();
		return util.redirectUrl("admin/user/login.do");
	}
	
	@GetMapping("/join.do")
	public ModelAndView pageAdminJoin(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mv=new ModelAndView("admin/user/join");
		return mv;
	}
	
	@PostMapping("/join.do")
	public String actionAdminJoin(HttpServletRequest req, HttpServletResponse res, @RequestParam HashMap<String, Object> paramMap)throws Exception{
		log.debug("PARAM MAP : "+paramMap);
		int joinResult=adminUserService.actionAdminJoin(paramMap);
		return util.redirectUrl("admin/user/"+(joinResult==1?"login.do":"join.do"));
	}
}