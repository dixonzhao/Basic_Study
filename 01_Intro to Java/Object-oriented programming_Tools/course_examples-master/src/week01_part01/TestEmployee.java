package week01_part01;

public class TestEmployee 
{

	public static void main(String[] args) {
		Employee employee01 = new Employee();
		employee01.setName("alice");
		employee01.setSalary(1500);
		
		System.out.println("employee # 1: " + employee01);
		System.out.println("done!");
		
		Employee employee02 = new Employee("bob", 1200);
		employee02.setSalary(1400);
		System.out.println("employee # 2: " + employee02);
	}

}
