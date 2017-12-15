package com.marck.spring.app.Models.ClienteDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.marck.spring.app.Models.Entity.Cliente;
@Repository
public class ClienteImpl implements ICliente{
	private final String SelectAll="Select * from Clientes";
	private final String SelectOne="Select * from Clientes where id=:id";
	private final String Insert="INSERT INTO Clientes(nombre,apellido,email,fecha) values(:nombre,:apellido,:email,:fecha)";
	private final String Update="Update Clientes SET nombre=:nombre,apellido=:apellido,email=:email,fecha=:fecha where id=:id";
	private final String Delete="DELETE from Clientes where id=:id";
	NamedParameterJdbcTemplate nJdbc;
	@Autowired
	public  void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate nJdbc)throws DataAccessException{
		this.nJdbc=nJdbc;
	}
	@Override
	public List<Cliente> findAll() {
		List<Cliente> lcliente= nJdbc.query(SelectAll, getSQLParameterByModel(null), new ClienteMapper());
		return lcliente;
	}
	private SqlParameterSource getSQLParameterByModel(Cliente cliente) {
		MapSqlParameterSource paramSource= new MapSqlParameterSource();
		if(cliente!=null) {
			paramSource.addValue("id", cliente.getId());
			paramSource.addValue("nombre", cliente.getNombre());
			paramSource.addValue("apellido", cliente.getApellido());
			paramSource.addValue("email", cliente.getEmail());
			paramSource.addValue("fecha", cliente.getFecha());
		}
		return paramSource;
	}
	private static final class ClienteMapper implements RowMapper<Cliente>{

		@Override
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cliente cliente=new Cliente();
			cliente.setId(rs.getLong("id"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellido(rs.getString("apellido"));
			cliente.setEmail(rs.getString("email"));
			cliente.setFecha(rs.getTimestamp("fecha"));
			return cliente;
		}
		
	}
	@Override
	public Cliente findOne(Long id) {
		Cliente rcliente= nJdbc.queryForObject(SelectOne, getSQLParameterByModel(new Cliente(id)), new ClienteMapper());
		return rcliente;
	}

	@Override
	public int insertCliente(Cliente cliente) {
		int valor=nJdbc.update(Insert, getSQLParameterByModel(cliente));
		return valor;
	}

	@Override
	public int deleteCliente(Long id) {
		int valor=nJdbc.update(Delete, getSQLParameterByModel(new Cliente(id)));
		return valor;
	}

	@Override
	public int updateCliente(Cliente cliente) {
		int valor=nJdbc.update(Update, getSQLParameterByModel(cliente));
		return valor;
	}


}
