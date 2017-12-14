package com.marck.spring.app.Models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marck.spring.app.Models.ClienteDao.CimplOther;
import com.marck.spring.app.Models.Entity.Cliente;

@Service
public class CimplS implements ClienteService{
	@Autowired
	CimplOther co;
	
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return co.findAll();
	}

	@Override
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return co.findOne(id);
	}

	@Override
	public int insertCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return co.insertCliente(cliente);
	}

	@Override
	public int deleteCliente(Long id) {
		// TODO Auto-generated method stub
		return co.deleteCliente(id);
	}

	@Override
	public int updateCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return co.updateCliente(cliente);
	}

}
