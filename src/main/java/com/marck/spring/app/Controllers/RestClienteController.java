package com.marck.spring.app.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.marck.spring.app.Models.ClienteDao.ClienteImpl;
import com.marck.spring.app.Models.Entity.Buscar;
import com.marck.spring.app.Models.Entity.Cliente;

@RestController
@RequestMapping("cliente/")
public class RestClienteController {
	@Autowired
	CimplS cs;
	@Autowired
	ClienteImpl sc;
	
	
	@PostMapping(value="/buscar")
	public Response getResource(@RequestBody String valor) throws JsonParseException, JsonMappingException, IOException {
		List<Cliente> cli= new ArrayList<Cliente>();
		Cliente clione= new Cliente();
		Buscar ob = new ObjectMapper().readValue(valor, Buscar.class);
		clione=cs.findOne(Long.parseLong(ob.getBuscar()));
		cli.add(clione);
		Response response= new Response("Done",cli);
		return response;
	}
	
	@PostMapping(value="/save2")
	public Response addUpdate(HttpServletRequest request)  {
		Response response;
		List<Cliente> cli= new ArrayList<Cliente>();
		Cliente clione= new Cliente();
		clione.setNombre(request.getParameter("nombre"));
		clione.setApellido(request.getParameter("apellido"));
		clione.setEmail(request.getParameter("email"));
		if(request.getParameter("id")=="") {
			sc.insertCliente(clione);
			cli=cs.findAll();
			clione=cli.get((cli.size()-1));
			cli.clear();
			cli.add(clione);
			response= new Response("Done",cli);
		}else {
			clione.setId(Long.parseLong(request.getParameter("id")));
			sc.updateCliente(clione);
			response= new Response("Done","actualizado");
		}
		
		
		return response;
	}
}
