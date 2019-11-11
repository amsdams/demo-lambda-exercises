package intro;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {

		Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());

		int comparatorResult = comparator.compare("11111", "11111");

		log.info("comparatorResult {}", comparatorResult);

		Function<Person, Integer> age = person -> person.getAge();

		Person p = new Person();
		p.setAge(2);

		Integer ageResult = age.apply(p);
		log.info("ageResult {}", ageResult);

		Function<Person, Integer> age2 = Person::getAge;

		Integer age2Result = age2.apply(p);
		log.info("age2Result {}", age2Result);

		BinaryOperator<Integer> sum = (i1, i2) -> Integer.sum(i1, i2);
		Integer sumResult = sum.apply(1, 2);
		log.info("sumResult {}", sumResult);

		BinaryOperator<Integer> sum2 = Integer::sum;
		Integer sum2Result = sum2.apply(1, 2);
		log.info("sum2Result {}", sum2Result);

		Consumer<String> printer = s -> System.out.print(s);
		printer.accept("hi");

		IdentityFunction<Person, Person> identityFunction = IdentityFunction.indentity();

		Person identity = identityFunction.apply(p);

		log.info("identity {}", identity);

	}

}
