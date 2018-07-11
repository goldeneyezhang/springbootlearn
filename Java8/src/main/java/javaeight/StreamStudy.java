package javaeight;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamStudy {
	
	public static void main(String args[]) {
		StreamStudy s = new StreamStudy();
		s.test1();
		s.test2();
		s.test3();
		s.test4();
		s.test5();
		s.test6();
		s.test7();
		s.test8();
	}
	private void test1() {
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		System.out.println("------------------");
	}
	private void test2() {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//获取对应的平方数
		List<Integer> squaresList = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
		squaresList.forEach(f->System.out.println(f));
		System.out.println("------------------");
	}
	private void test3() {
		List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
		//获取空字符串的数量
		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println(count);
		System.out.println("------------------");
	}
	private void test4() {
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		System.out.println("------------------");
	}
	private void test5() {
		Random random = new Random();
		random.ints().limit(10).sorted().forEach(System.out::println);
		System.out.println("------------------");
	}
	/**
     * 并行（parallel）程序
     * parallelStream 是流并行处理程序的代替方法。以下实例我们使用 parallelStream 来输出空字符串的数量：
     */
	private void test6() {
		List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
		// 获取空字符串的数量
		long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println(count);
		System.out.println("------------------");
	}
	 /**
     * Collectors
     * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串
     */
	private void test7() {
		List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
		List<String> filtered = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
		System.out.println("筛选列表"+filtered);
		String mergedString = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("合并字符串: "+mergedString);
		System.out.println("------------------");
	}
	/**
     * 统计
     * 另外，一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
     */
	private void test8() {
		List<Integer> integers = Arrays.asList(3,2,2,3,7,3,5);
		IntSummaryStatistics stats = integers.stream().mapToInt((x)->x).summaryStatistics();
		System.out.println("列表中最大的数:"+stats.getMax());
		System.out.println("列表中最大的数:"+stats.getMin());
		System.out.println("所有数之和:"+stats.getSum());
		System.out.println("平均数:"+stats.getAverage());
	}
}
