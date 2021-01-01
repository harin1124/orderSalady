package orderSalady.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import orderSalady.user.domain.UserJoinDto;
import orderSalady.user.service.UserService;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@GetMapping("/joinForm")
	public ModelAndView pageJoinForm(){
		ModelAndView mv=new ModelAndView("/user/join");
		return mv;
	}
	
	@PostMapping("/join")
	public ModelAndView actionJoin(@RequestBody UserJoinDto param)throws Exception{
		ModelAndView mv=new ModelAndView("/main");
		System.out.println("회원가입 액션");
		System.out.println("UserJoinDto : "+param);
		userService.actionJoin(param);
		return mv;
	}
	
	/*
	 * @GetMapping("/loginForm") public ModelAndView pageLoginForm(){ ModelAndView
	 * mv=new ModelAndView("/user/login"); return mv; }
	 */
}