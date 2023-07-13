package testBoard.login.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import testBoard.login.commons.session.SessionConst;
import testBoard.login.dto.LoginMemDTO;
import testBoard.login.dto.SessionDTO;
import testBoard.login.service.MembersService;

// http://localhost:8090/


@Controller
public class LoginController {
	
	private final MembersService service;
	
	
	@Autowired
	public LoginController(MembersService service) {
		
		this.service = service;
	}


	
	
	@GetMapping("/login")
	public String loginForm(LoginMemDTO loginMemDTO) {
		
		return "login2/login.html";
	}
	
	@PostMapping("/login/apply")
	public String loginFormCheck(@Valid LoginMemDTO loginMemDTO,BindingResult bindingResult
			,HttpServletRequest request
			) {
		
		if(bindingResult.hasErrors()) {
			return "login2/login.html";
		}
		
		LoginMemDTO memberDTO = service.SelectMemberCheckProcess(loginMemDTO);
		
		if( memberDTO == null) {
			
			bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
			
			return "login2/login.html";
			
		}
			
		
		if(memberDTO.getMemberType().equals("4")) {
			
			SessionDTO sessionDTO = new SessionDTO();
			
			sessionDTO.setMem_Id(memberDTO.getMem_Id());
			sessionDTO.setMem_Name(memberDTO.getMem_Name());
			sessionDTO.setMem_code(memberDTO.getMem_code());
			
			HttpSession adminSession = request.getSession();
			
			
			adminSession.setAttribute(SessionConst.LOGIN_ADMIN, sessionDTO);
			
			
			return "redirect:/";
			
		}
		
		SessionDTO sessionDTO = new SessionDTO();
		
		sessionDTO.setMem_Id(memberDTO.getMem_Id());
		sessionDTO.setMem_Name(memberDTO.getMem_Name());
		sessionDTO.setMem_code(memberDTO.getMem_code());
		
		HttpSession session = request.getSession();
	
		session.setAttribute(SessionConst.LOGIN_MEMBER, sessionDTO);
		
		
		
		
		return "redirect:/";
	}
	
	////////////////////////////////////////////////////////////////
	
	
	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		
		
		return "redirect:/";
		
		
		
	}
	
	


	@GetMapping("/loginhome/login")
	public String loginHome() {
		
		return "login/loginHome.html";
	}
	
	////////////////////////////////////////////////
	
	@GetMapping("reservePage/login")
	public String reservePage() {
		
		return "reservePage.html";
		
	}
	
}
