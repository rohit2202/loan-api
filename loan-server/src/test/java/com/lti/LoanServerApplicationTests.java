package com.lti;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Customer;
import com.lti.entity.Customer.GENDER;
import com.lti.repository.CustomerRepository;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class  LoanServerApplicationTests {

	@Autowired
	CustomerRepository customerRepo;

	@Test
	void add() {
		Customer c = new Customer();
		
		c.setCustomerName("Rohit Roy");
		c.setEmailid("roy@example.com");
		c.setPassword("roy");
		c.setDateofbirth(LocalDate.of(1999,02, 07));
		c.setPhoneno(991101652);
		c.setNationality("Indian");
		c.setAadhaarno("985623560974");
		c.setPanno("XCR63");
		c.setGender(GENDER.MALE);
		

		customerRepo.save(c);
		// assert missing
	}

	@Test
	void findAll() {
		List<Customer> listOfCustomers = customerRepo.findAll();

		for (Customer c : listOfCustomers) {
			System.out.println(c.getCustomerId() + " , " + c.getCustomerName() + " , " + c.getDateofbirth() + " , " + c.getEmailid());
			;
		}
		// assert missing
	}

@Test
	void findByUsernamePassword() {

		long id = customerRepo.findByUsernamePassword("roy@example.com", "roy");
		System.out.println("Customer id is"+id);
		// assert missing
	}
}