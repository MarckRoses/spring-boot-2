package com.marck.spring.app.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marck.spring.app.Models.CimplS;
import com.marck.spring.app.Models.Response;
import com.marck.spring.app.Models.Entity.Buscar;
import com.marck.spring.app.Models.Entity.Cliente;

@RestController
@RequestMapping("cliente/")
public class RestClienteController {
	@Autowired
	CimplS cs;
	
	
	@PostMapping(value="/buscar")
	public Response getResource(@RequestBody String valor) throws JsonParseException, JsonMappingException, IOException {
		List<Cliente> cli= new ArrayList<Cliente>();
		Cliente clione= new Cliente();
		Buscar ob = new ObjectMapper().readValue(valor, Buscar.class);
		clione=cs.findOne(Long.parseLong(ob.getBuscar()));
		cli.add(clione);
		System.out.println(cli);
		Response response= new Response("Done",cli);
		return response;
	}
}
