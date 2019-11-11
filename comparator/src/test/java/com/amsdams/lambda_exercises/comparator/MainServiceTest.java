package com.amsdams.lambda_exercises.comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.amsdams.lambda_exercises.comparator.MainService;
import com.amsdams.lambda_exercises.comparator.Person;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)

@SpringBootTest
@Slf4j
public class MainServiceTest {

	@Autowired
	private MainService mainService;

	@Test
	public void getAge() {

		Person person1 = getPerson1();

		Person person2 = getPerson2();

		Integer age = mainService.getAge().apply(person1);
		log.info("age {}", age);
		Assertions.assertEquals(1, age);
	}

	@Test
	public void getFirstName() {

		Person person1 = getPerson1();

		Person person2 = getPerson2();

		String firstName = mainService.getFirstName().apply(person1);
		log.info("firstName {}", firstName);
		Assertions.assertEquals("firstName", firstName);
	}

	@Test
	public void getLastName() {
		Person person1 = getPerson1();

		Person person2 = getPerson2();
		String lastName = mainService.getLastName().apply(person1);
		log.info("lastName {}", lastName);
		Assertions.assertEquals("lastName", lastName);
	}

	@Test
	public void getAgeComparator() {
		Person person1 = getPerson1();

		Person person2 = getPerson2();
		int ageComparator = mainService.getAgeComparator().compare(person1, person2);
		log.info("ageComparator {}", ageComparator);
		Assertions.assertEquals(1, ageComparator);
	}

	@Test
	public void getFirstNameComparator() {
		Person person1 = getPerson1();

		Person person2 = getPerson2();
		int firstNameComparator = mainService.getFirstNameComparator().compare(person1, person2);
		log.info("firstNameComparator {}", firstNameComparator);
		Assertions.assertEquals(52, firstNameComparator);
	}

	@Test
	public void getLastNameComparator() {
		Person person1 = getPerson1();

		Person person2 = getPerson2();
		int lastNameComparator = mainService.getLastNameComparator().compare(person1, person2);
		log.info("lastNameComparator {}", lastNameComparator);
		Assertions.assertEquals(58, lastNameComparator);
	}

	@Test
	public void getPersonAge() {
		Person person1 = getPerson1();

		Person person2 = getPerson2();
		int personAgeComparator = mainService.getPersonAge().compare(person1, person2);
		log.info("personAgeComparator {}", personAgeComparator);
		Assertions.assertEquals(-1, personAgeComparator);
	}

	@Test
	public void getPersonLastName() {
		Person person1 = getPerson1();

		Person person2 = getPerson2();
		int personLastNameComparator = mainService.getPersonLastName().compare(person1, person2);
		log.info("personLastNameComparator {}", personLastNameComparator);
		Assertions.assertEquals(58, personLastNameComparator);
	}

	@Test
	public void getPersonLastNameAndFirstName() {
		Person person1 = getPerson1();

		Person person2 = getPerson2();
		int personLastNameComparatorAndLastName = mainService.getPersonLastNameAndFirstName().compare(person1, person2);
		log.info("personLastNameComparatorAndLastName {}", personLastNameComparatorAndLastName);
		Assertions.assertEquals(58, personLastNameComparatorAndLastName);
	}

	private Person getPerson2() {
		Person person2 = new Person();
		person2.setAge(2);
		person2.setFirstName("2firstName");
		person2.setLastName("2lastName");
		return person2;
	}

	private Person getPerson1() {
		Person person1 = new Person();
		person1.setAge(1);
		person1.setFirstName("firstName");
		person1.setLastName("lastName");
		return person1;
	}
}
