package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.classes.Usuario;
import com.web.client.RestService;
import com.web.repository.UsuarioRepository;

@Controller
public class IndexController {
	
	@Autowired
	private UsuarioRepository ur;

	@GetMapping("/")
//	@Scheduled(fixedRate= 3000)
	@RequestMapping(value="/", method=RequestMethod.GET)	
	public String login(Model model) throws Exception {
		model.addAttribute("usuario", new Usuario());
		new RestService().run("0");

		return "home";
	}	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String insertDB(Usuario user) {
		ur.save(user);
		return "cadastro";
	}	
}
