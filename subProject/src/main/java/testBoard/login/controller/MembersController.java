package testBoard.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import testBoard.login.dto.AddMemDTO;
import testBoard.login.dto.LoginMemDTO;
import testBoard.login.service.MembersService;



@Controller
public class MembersController {

	private final MembersService service;
	
	@Autowired
	public MembersController(MembersService service) {
		this.service = service;
	}
	

	@GetMapping("/login/member")
	public String MembersAdd(AddMemDTO addMemDTO) {
		
		
		
		return "login2/membership.html";
	}
	
	
	
	@PostMapping("/login/add")
	public String AddSuccess(@Valid @ModelAttribute AddMemDTO addMemDTO, BindingResult result) {
		
	
		
		if(result.hasErrors()) {
			
			return "login2/membership.html";
			
		}
		
		
		
		
		int num=service.insertProcess(addMemDTO);
		

		
		
		return "redirect:/login/signup_finish";
	}
	
	@GetMapping("/login/signup_finish")
	public String loginSuccess() {
		
		return "login2/signup_finish.html";
	}
	
	
	
	@ResponseBody
	@PostMapping("/members/idCheck")
	public int idCheck(@RequestParam("mem_Id") String id) {
		
		
		int cnt = service.duplicateIdCheckProcess(id);
		
		
		return cnt;
	}
	
}
