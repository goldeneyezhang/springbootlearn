package javaeight;

public class Car2 implements Vehicle,FourWheeler{
	public  void print() {
		Vehicle.super.print();
		FourWheeler.super.print();
		Vehicle.blowHorn();
		System.out.println("我是一辆四轮汽车");
	}
}
