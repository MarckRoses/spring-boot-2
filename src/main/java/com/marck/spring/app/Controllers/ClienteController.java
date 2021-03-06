package com.marck.spring.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/cliente",method=RequestMethod.GET)
	public ModelAndView Clientes() {
		ModelAndView model= new ModelAndView("/cliente_page");
		List<Cliente> c=scliente.findAll();
		model.addObject("clientes", c);
		return model;
	}
	
	
	@RequestMapping(value="/cliente/save",method=RequestMethod.POST)
	public String Guardar(Cliente cliente) {
		//ModelAndView model= new ModelAndView("/cliente_page");
		int num=ccliente.insertCliente(cliente);
		System.out.print(num);
		return "redirect:/cliente";
	}
	@RequestMapping(value="/cliente/add",method=RequestMethod.GET)
	public ModelAndView Agregar() {
		ModelAndView model= new ModelAndView("/cliente_form");
		Cliente cform= new Cliente();
		model.addObject("use_form",cform);
		return model;
	}
	
	@RequestMapping(value="/cliente/update/{id}",method=RequestMethod.GET)
	public ModelAndView Actualizar(@PathVariable("id") long id) {
		ModelAndView model= new ModelAndView("/cliente_form");
		Cliente cform= scliente.findOne(id);
		model.addObject("use_form",cform);
		return model;
	}
	@RequestMapping(value="/cliente/delete/{id}",method=RequestMethod.GET)
	public String Eliminar(@PathVariable("id") long id) {
		scliente.deleteCliente(id);
		return "redirect:/cliente";
	}
	

}
