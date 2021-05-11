package com.ojas.emps;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ojas.emps.model.Laptop;
import com.ojas.emps.model.Student;
import com.ojas.emps.repos.LaptopDao;
import com.ojas.emps.repos.StudentDao;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan
public class OneToManyRelationApplication implements CommandLineRunner {

	@Autowired
	private LaptopDao laptopDao;
	@Autowired
	private StudentDao studentDao;
	public static void main(String[] args) {
		SpringApplication.run(OneToManyRelationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveDataWithApproach1();
		
	}
	 private void saveDataWithApproach1(){
	        Laptop apple = new Laptop(101,"Apple");
	        Laptop samsung = new Laptop(102,"Samsung");
	        
	        Student stud1 = new Student(10,"Swathi", 45,apple);
	        Student stud2 = new Student(11,"Vani",46, apple);
	        
	        Student stud3 = new Student(12,"Madhu",47, samsung);
	        Student stud4 = new Student(13,"GalaxyTabA",48, samsung);
	        
	        apple.setStudents(new HashSet<Student>(){{
	            add(stud1);
	            add(stud2);
	        }});
	        
	        samsung.setStudents(new HashSet<Student>(){{
	            add(stud3);
	            add(stud4);
	        }});

	        // save companies
	        laptopDao.save(apple);
	        laptopDao.save(samsung);
	        
	        studentDao.save(stud1);
	    }
	 
//	 private void saveDataWithApproach2(){
//	      
//	      /*
//	       * Firstly persist companies (not include product list)
//	       */
//	        Company apple = new Company("Apple");
//	        Company samsung = new Company("Samsung");
//	        
//	        //save companies
//	        companyRepository.save(apple);
//	        companyRepository.save(samsung);
//	        
//	        /*
//	         * Then store products with had persisted companies.
//	         */
//	      Product iphone7 = new Product("Iphone 7", apple);
//	        Product iPadPro = new Product("IPadPro", apple);
//	        
//	        Product galaxyJ7 = new Product("GalaxyJ7", samsung);
//	        Product galaxyTabA = new Product("GalaxyTabA", samsung);
//	 
//	        // save products
//	        productRepository.save(iphone7);
//	        productRepository.save(iPadPro);
//	        
//	        productRepository.save(galaxyJ7);
//	        productRepository.save(galaxyTabA);
//	    }
	    
//	    @Transactional
//	    private void showData(){
//	      // get All data
//	      List<Company> companyLst = companyRepository.findAll();
//	        List<Product> productLst = productRepository.findAll();
//	         
//	        System.out.println("===================Product List:==================");
//	        productLst.forEach(System.out::println);
//	         
//	        System.out.println("===================Company List:==================");
//	        companyLst.forEach(System.out::println);
//	    }
}
