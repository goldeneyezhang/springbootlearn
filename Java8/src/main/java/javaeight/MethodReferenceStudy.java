package javaeight;

import java.util.ArrayList;
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
	}
}
