package com.springboot.peoplemanagment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.springboot.peoplemanagment.entities.Person;
import com.springboot.peoplemanagment.service.PeopleManagementService;

@SpringBootApplication
public class PeopleManagmentSpringBootDataAppApplication implements CommandLineRunner {

	@Autowired
	private PeopleManagementService peopleManagementService;

	public static void main(String[] args) {
		SpringApplication.run(PeopleManagmentSpringBootDataAppApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		// Pageable pageable
		//queryFirst10ByLastName();
		dispPagination();
		
		//queryFirst10ByLastName();
	}
	
	private void queryFirst10ByLastName()
	{

		System.out.println("First Page ------------------------");
	List<Person> list = peopleManagementService.
			findByLastName("kumar",
	//new PageRequest(0, 4, Direction.ASC, "firstName")
	PageRequest.of(0, 2, Direction.ASC,"lastName")
	);
		
		list.forEach(System.out::println);
		
		
		System.out.println("First Page ------------------------");
		List<Person> list2 = peopleManagementService.
				findByLastName("kumar",
		//new PageRequest(0, 4, Direction.ASC, "firstName")
		PageRequest.of(1, 2, Direction.ASC,"lastName")
		);
			
		list2.forEach(System.out::println);
			
	}
	
	private void dispPagination()
	{

		System.out.println("First Page ------------------------");
		List<Person> list = peopleManagementService.findByLastName("kumar",
				new PageRequest(0, 2, Direction.DESC, "lastName"));
		
		
		list.forEach(System.out::println);
		
		
		System.out.println("Second Page ------------------------");
		List<Person> secondlist = peopleManagementService.findByLastName("kumar",
				//new PageRequest(1, 2, Direction.ASC, "firstName"));
				PageRequest.of(1, 1));
		
		secondlist.forEach(System.out::println);
			
		
		System.out.println("Third Page ------------------------");
		List<Person> thirdlist = peopleManagementService.findByLastName("kumar",
				new PageRequest(2, 1, Direction.ASC, "firstName"));
		
		thirdlist.forEach(System.out::println);
		
		
	}

	

}
