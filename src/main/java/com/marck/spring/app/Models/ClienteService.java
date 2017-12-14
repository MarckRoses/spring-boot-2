package com.marck.spring.app.Models;

import java.util.List;

import com.marck.spring.app.Models.Entity.Cliente;

public interface ClienteService {
	public List<Cliente> findAll();
	public Cliente findOne(Long id);
	public int insertCliente(Cliente cliente);
	public int deleteCliente(Long id);
	public int updateCliente(Cliente cliente);
}
