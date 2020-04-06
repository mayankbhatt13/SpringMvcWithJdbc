package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int save(Contact contact) {
		String sqlQuery = "INSERT INTO Contact(name, email, address, phone) values (?,?,?,?)";
		return jdbcTemplate.update(sqlQuery, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone());
	}

	@Override
	public int update(Contact contact) {
		String sqlQuery = "UPDATE Contact set name=?, email=?, address=?, phone=? WHERE contact_id=?";
		return jdbcTemplate.update(sqlQuery, contact.getName(),contact.getEmail(), contact.getAddress(), contact.getPhone(), contact.getId());
	}

	@Override
	public Contact get(Integer id) {
		String sqlQuery = "SELECT * FROM Contact WHERE contact_id = "+id;
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {
			
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					
					return new Contact(id, name, email, address, phone);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sqlQuery, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sqlQuery = "DELETE FROM Contact WHERE contact_id = "+id;
		return jdbcTemplate.update(sqlQuery);
	}

	@Override
	public List<Contact> list() {
		String sqlQuery = "SELECT * FROM Contact";
		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {
			
			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("contact_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				
				return new Contact(id, name, email, address, phone);
			}
		};
		return jdbcTemplate.query(sqlQuery, rowMapper);
	}

}
