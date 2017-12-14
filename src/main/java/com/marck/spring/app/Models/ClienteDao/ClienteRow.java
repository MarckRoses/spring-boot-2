package com.marck.spring.app.Models.ClienteDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ClienteRow implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClienteExtractor ce= new ClienteExtractor();
		return ce.extractData(rs);
	}

}
