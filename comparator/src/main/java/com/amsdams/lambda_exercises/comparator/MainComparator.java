package com.amsdams.lambda_exercises.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MainComparator {

	public static void main(String... args) {

		MainService mainService = new MainService();
		
		
		List<Person> persons = new ArrayList<>();

		Person person1 = new Person();
		person1.setAge(1);
		person1.setFirstName("firstName");
		person1.setLastName("lastName");
		persons.add(person1);

		Person person2 = new Person();
		person2.setAge(2);
		person2.setFirstName("2firstName");
		person2.setLastName("2lastName");

		persons.add(person2);

		Person person3 = new Person();
		person3.setAge(3);
		person3.setFirstName("3firstName");
		person3.setLastName("3lastName");
		persons.add(person3);

		
		Integer age = mainService.getAge().apply(person1);
		log.info("age {}", age);
		
		String firstName = mainService.getFirstName().apply(person1);
		log.info("firstName {}", firstName);

		String lastName = mainService.getLastName().apply(person1);
		log.info("lastName {}", lastName);


		int ageComparator = mainService.getAgeComparator().compare(person1, person2);
		log.info("ageComparator {}", ageComparator);
		
		int firstNameComparator = mainService.getFirstNameComparator().compare(person1, person2);
		log.info("firstNameComparator {}", firstNameComparator);
		
		int lastNameComparator = mainService.getLastNameComparator().compare(person1, person2);
		log.info("lastNameComparator {}", lastNameComparator);
		

		int personAgeComparator = mainService.getPersonAge().compare(person1, person2);
		log.info("personAgeComparator {}", personAgeComparator);

		int personLastNameComparator = mainService.getPersonLastName().compare(person1, person2);
		log.info("personLastNameComparator {}", personLastNameComparator);

		int personLastNameComparatorAndLastName = mainService.getPersonLastNameAndFirstName().compare(person1, person2);
		log.info("personLastNameComparatorAndLastName {}", personLastNameComparatorAndLastName);

	}
}
