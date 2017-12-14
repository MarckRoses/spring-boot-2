package com.marck.spring.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.marck.spring.app.Models.CimplS;
import com.marck.spring.app.Models.ClienteSImpl;
import com.marck.spring.app.Models.Entity.Cliente;

@Controller
public class IndexController {
	@Autowired
	CimplS scliente;
	
	@GetMapping("/")
	public String Index(Model model) {
		model.addAttribute("titulo", "Hola desde gradle");
		List<Cliente> c=scliente.findAll();
		model.addAttribute("clientes", c);
		return "index";
	}
}
