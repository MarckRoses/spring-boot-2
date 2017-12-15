package com.marck.spring.app.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marck.spring.app.Models.CimplS;
import com.marck.spring.app.Models.Response;
import com.marck.spring.app.Models.Entity.Cliente;

@RestController
@RequestMapping("cliente/api/cliente")
public class RestClienteController {
	@Autowired
	CimplS cs;
	
	List<Cliente> cli= new ArrayList<Cliente>();
	Cliente clione= new Cliente();
	@PostMapping(value="/buscar")
	public Response getResource(@RequestBody String valor) {
		
		clione=cs.findOne(Long.parseLong(valor));
		cli.add(clione);
		System.out.println(cli);
		Response response= new Response("Done",cli);
		return response;
	}
}
