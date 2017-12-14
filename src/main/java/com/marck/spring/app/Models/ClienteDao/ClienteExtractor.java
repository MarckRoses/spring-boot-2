package com.marck.spring.app.Models.ClienteDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.marck.spring.app.Models.Entity.Cliente;

public class ClienteExtractor implements ResultSetExtractor{

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Cliente c = new Cliente();
		c.setId(rs.getLong(1));
		c.setNombre(rs.getString(2));
		c.setApellido(rs.getString(3));
		c.setEmail(rs.getString(4));
		c.setFecha(rs.getTimestamp(5));
		return c;
	}

}
