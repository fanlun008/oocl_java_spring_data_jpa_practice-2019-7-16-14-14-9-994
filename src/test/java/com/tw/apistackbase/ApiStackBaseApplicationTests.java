package com.tw.apistackbase;

import com.tw.apistackbase.core.Company;
import com.tw.apistackbase.core.Employee;
import com.tw.apistackbase.core.Profile;
import com.tw.apistackbase.repo.CompanyRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ApiStackBaseApplicationTests {

	@Autowired
	CompanyRepo companyRepo;

	@Test
	public void contextLoads() {
		
	}

	@Test
	public void test_one_to_one_post() {
		Company company = new Company();
		Profile companyProfile = new Profile();
		companyProfile.setRegisteredCapital(500000);
		companyProfile.setCertId("3XXXXX");

		company.setName("acompany");
		company.setProfile(companyProfile);

		companyRepo.saveAndFlush(company);
	}

	@Test
	public void test_one_to_many() {
		Company company = new Company();
		Employee employee1 = new Employee("John", 23);
		Employee employee2 = new Employee("Bill", 24);

		company.setEmployees(Arrays.asList(employee1, employee2));

		Company company1 = companyRepo.saveAndFlush(company);
		System.out.println(company1);
		List<Company> all = companyRepo.findAll();
		System.out.println(all);
	}

}
