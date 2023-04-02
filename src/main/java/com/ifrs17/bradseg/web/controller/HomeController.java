package com.ifrs17.bradseg.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.userdetails.User;

@Controller
//@ResponseBody
public class HomeController {

	// abrir pagina home
	@GetMapping({"/", "/home"})
	public String home() {
		System.out.println("HomeController 0001");
		return "home";
	}		

	@GetMapping("/logintest")
	public ResponseEntity<String> testeGet(){
		return ResponseEntity.ok("Login successful");		
	}
	
	@PostMapping("/logintest")
	public ResponseEntity<String> fazerLogin(@RequestParam String username, 
	                    @RequestParam String password, 
	                    @AuthenticationPrincipal User user,
	                    RedirectAttributes attr,
	                    HttpServletRequest request,  
	                    HttpServletResponse response) {
		
		
	    // check if username is correct
	    if (username.equals("correctUsername")) {
	        // return success code if username is correct
	        return ResponseEntity.ok("Login successful");
	    } else {
	        // return bad request code if username is incorrect
	        return ResponseEntity.badRequest().body("Incorrect username");
	    }
	}
	
	

	// abrir pagina login
	@GetMapping({"/login"})
	public String login() {
		System.out.println("HomeController 0002");
		return "login";
	}	
	
	// login invalido
	@GetMapping({"/login-error"})
	public String loginError(ModelMap model) {
		model.addAttribute("alerta", "erro");
		model.addAttribute("titulo", "Crendenciais inválidas!");
		model.addAttribute("texto", "Login ou senha incorretos, tente novamente.");
		model.addAttribute("subtexto", "Acesso permitido apenas para cadastros já ativados.");
		System.out.println("HomeController 0003");
		return "login";
	}	
	
	// acesso negado
	@GetMapping({"/acesso-negado"})
	public String acessoNegado(ModelMap model, HttpServletResponse resp) {
		model.addAttribute("status", resp.getStatus());
		model.addAttribute("error", "Acesso Negado");
		model.addAttribute("message", "Você não tem permissão para acesso a esta área ou ação.");
		System.out.println("HomeController 0004");
		return "error";
	}	
}
