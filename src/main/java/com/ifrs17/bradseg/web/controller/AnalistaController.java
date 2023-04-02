package com.ifrs17.bradseg.web.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifrs17.bradseg.dominio.Analista;
import com.ifrs17.bradseg.dominio.Usuario;
import com.ifrs17.bradseg.service.AnalistaService;
import com.ifrs17.bradseg.service.UsuarioService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("analistas")
public class AnalistaController {
	
	@Autowired
	private AnalistaService service;
	@Autowired
	private UsuarioService usuarioService;
	

    @GetMapping("/teste")
    public @ResponseBody Map<String, String> meuJson() {
        Map<String, String> json = new HashMap<>();
        json.put("mensagem", "Olá, mundo!");
        json.put("data", LocalDateTime.now().toString());
        return json;
    }
	
	
	// abrir pagina de dados pessoais do analista
	@GetMapping("/dados")
	public String cadastrar(Analista analista, ModelMap model, @AuthenticationPrincipal User user) {
		analista = service.buscarPorUsuarioEmail(user.getUsername());
		if (analista.hasNotId()) {
			analista.setUsuario(new Usuario(user.getUsername()));
		}
		model.addAttribute("analista", analista);
		System.out.println("AnalistaController 0001");
		return "analista/cadastro";
	}
	
	// salvar o form de dados pessoais do analista com verificacao de senha
	@PostMapping("/salvar")
	public String salvar(Analista analista, ModelMap model, @AuthenticationPrincipal User user) {
		Usuario u = usuarioService.buscarPorEmail(user.getUsername());
		if (UsuarioService.isSenhaCorreta(analista.getUsuario().getSenha(), u.getSenha())) {
			analista.setUsuario(u);
			service.salvar(analista);
			model.addAttribute("sucesso", "Seus dados foram inseridos com sucesso.");
		} else {
			model.addAttribute("falha", "Sua senha não confere, tente novamente.");
		}
		System.out.println("AnalistaController 0002");
		return "analista/cadastro";
	}	
	
	// editar o form de dados pessoais do analista com verificacao de senha
	@PostMapping("/editar")
	public String editar(Analista analista, ModelMap model, @AuthenticationPrincipal User user) {
		Usuario u = usuarioService.buscarPorEmail(user.getUsername());
		if (UsuarioService.isSenhaCorreta(analista.getUsuario().getSenha(), u.getSenha())) {
			service.editar(analista);
			model.addAttribute("sucesso", "Seus dados foram editados com sucesso.");
		} else {
			model.addAttribute("falha", "Sua senha não confere, tente novamente.");
		}
		System.out.println("AnalistaController 0003");
		return "analista/cadastro";
	}	
		
	
}
