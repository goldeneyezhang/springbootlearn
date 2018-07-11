package javaeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodReferenceStudy {
	public static void main(String args[]) {
		List<String> names = new ArrayList<>();
		names.add("Google");
		names.add("Baidu");
		names.add("Sina");
		names.add("Taobao");
		names.add("Yahoo");
		names.forEach(System.out::println);
		final Car car = Car.create( Car::new );
		final List<Car> cars = Arrays.asList(car);
		
		cars.forEach(Car::collide);
		cars.forEach(Car::repair);
		final Car police = new Car();
		cars.forEach(police::follow);
	}
}
