package com.marck.spring.app.Models;

import java.util.List;

import com.marck.spring.app.Models.ClienteDao.ClienteHikari;
import com.marck.spring.app.Models.Entity.Cliente;

public class ClienteHikariService implements ClienteService{
	ClienteHikari ch= new ClienteHikari();
	@Override
	public List<Cliente> findAll() {
		return ch.findAll();
	}

	@Override
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCliente(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

}
