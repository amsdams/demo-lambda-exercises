package com.amsdams.lambda_exercises.comparator;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MainService {


	public Comparator<Person> getAgeComparator() {
		Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
		log.info("cmpAge {}", cmpAge);
		return cmpAge;
	}

	public Comparator<Person> getFirstNameComparator() {
		Comparator<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		log.info("cmpFirstName {}", cmpFirstName);
		return cmpFirstName;
	}

	public Comparator<Person> getLastNameComparator() {
		Comparator<Person> cmpLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
		log.info("cmpLastName {}", cmpLastName);
		return cmpLastName;
	}

	public Function<Person, Integer> getAge() {
		Function<Person, Integer> f1 = p -> p.getAge();
		log.info("f1 {}", f1);
		return f1;
	}

	
	public Function<Person, String> getLastName() {
		Function<Person, String> f1 = p -> p.getLastName();
		log.info("f1 {}", f1);
		return f1;
	}
	
	public Function<Person, String> getFirstName() {
		Function<Person, String> f1 = p -> p.getFirstName();
		log.info("f1 {}", f1);
		return f1;
	}
	
	public Comparator<Person> getPersonAge(){
		Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
		log.info("cmpPersonAge {}", cmpPersonAge);
		
		return cmpPersonAge;
	}
	
	public Comparator<Person> getPersonLastName(){
		Comparator<Person> cmpPersonLastName = Comparator.comparing(Person::getLastName);
		log.info("cmpPersonLastName {}", cmpPersonLastName);
		
		return cmpPersonLastName;
	}
	
	
	public Comparator<Person> getPersonLastNameAndFirstName(){
		Comparator<Person> cmp = Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName)
				.thenComparing(Person::getAge);

		log.info("cmp {}", cmp);
		
		return cmp;
	}
	
	
	
}
