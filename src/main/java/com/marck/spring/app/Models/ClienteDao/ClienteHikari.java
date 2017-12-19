package com.marck.spring.app.Models.ClienteDao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.marck.spring.app.Models.Entity.Cliente;

public class ClienteHikari implements ICliente {
	DataSourceJdbcTemplate ds= new DataSourceJdbcTemplate();
	JdbcTemplate jdbc=ds.getJdbcTemplate();
	private final String SelectAll="Select * from Clientes";
	@Override
	public List<Cliente> findAll() {
		return jdbc.query(SelectAll,new ClienteRow());
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
