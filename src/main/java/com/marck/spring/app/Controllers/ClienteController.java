package com.marck.spring.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.marck.spring.app.Models.CimplS;
import com.marck.spring.app.Models.ClienteDao.ClienteImpl;
import com.marck.spring.app.Models.Entity.Cliente;

@Controller
public class ClienteController {
	@Autowired
	ClienteImpl ccliente;
	@Autowired
	CimplS scliente;

	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public ModelAndView Clientes() {
		ModelAndView model = new ModelAndView("/cliente_page");
		List<Cliente> c = scliente.findAll();
		model.addObject("clientes", c);
		return model;
	}

	@RequestMapping(value = "/cliente/save", method = RequestMethod.POST)
	public String Guardar(Cliente cliente) {
		// ModelAndView model= new ModelAndView("/cliente_page");
		if (cliente.getId() != null && cliente.getId() > 0) {
			ccliente.updateCliente(cliente);
		} else {
			ccliente.insertCliente(cliente);
		}
		return "redirect:/cliente";
	}

	@RequestMapping(value = "/cliente/add", method = RequestMethod.GET)
	public ModelAndView Agregar() {
		ModelAndView model = new ModelAndView("/cliente_form");
		Cliente cform = new Cliente();
		model.addObject("btn", "Crear Cliente");
		model.addObject("clase", "btn btn-success");
		model.addObject("use_form", cform);
		return model;
	}

	@RequestMapping(value = "/cliente/update/{id}", method = RequestMethod.GET)
	public ModelAndView Actualizar(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("/cliente_form");
		Cliente cform = scliente.findOne(id);
		model.addObject("btn", "Actualizar Cliente");
		model.addObject("clase", "btn btn-primary");
		model.addObject("use_form", cform);
		return model;
	}

	@RequestMapping(value = "/cliente/delete/{id}", method = RequestMethod.GET)
	public String Eliminar(@PathVariable("id") long id) {
		scliente.deleteCliente(id);
		return "redirect:/cliente";
	}

	@RequestMapping(value="/cliente/buscar",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Cliente handleAllUserRequest() {
		Long n=(long) 1;
		return scliente.findOne(n);
	}

}
