package com.marck.spring.app.Models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marck.spring.app.Models.ClienteDao.ClienteImpl;
import com.marck.spring.app.Models.Entity.Cliente;
@Service
public class ClienteSImpl implements ClienteService {

	ClienteImpl cdao;
	@Autowired
	public void setCdao(ClienteImpl cdao) {
		this.cdao = cdao;
	}

	@Override
	public List<Cliente> findAll() {
		return cdao.findAll();
	}

	@Override
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCliente(Cliente cliente) {
		return cdao.insertCliente(cliente);
	}

	@Override
	public int deleteCliente(Long id) {
		return cdao.deleteCliente(id);
	}

	@Override
	public int updateCliente(Cliente cliente) {
		return cdao.updateCliente(cliente);
	}

}
