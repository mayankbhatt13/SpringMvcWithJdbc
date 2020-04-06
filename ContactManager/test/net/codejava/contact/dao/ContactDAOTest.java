package net.codejava.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dao = new ContactDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		//Contact contact = new Contact("Mayank Bhatt", "mayank@123", "Alambagh, Lucknow", "9876543216");
		Contact contact = new Contact("Abhishek", "mayank12@123", "guru, Lucknow", "3216");
		int result = dao.save(contact);
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(2,"Abhished Bhatt", "abhi@123", "Alambagh, Lucknow", "789654136");
		int result = dao.update(contact);
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Contact contact = dao.get(id);
		if(contact != null) {
			System.out.println(contact);
		}
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer id = 2;
		int result = dao.delete(id);
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Contact> contactList = dao.list();
		for(Contact cont:contactList) {
			System.out.println("Name :- "+cont.getName()+" Email :- "+cont.getEmail()+" Address :- "+cont.getAddress()+" Phone :- "+cont.getPhone());
		}
		assertTrue(!contactList.isEmpty());
	}

}
