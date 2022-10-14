package package1;


//a class is like a blueprint which defines an object
//parent class or base class
class Person{
	String name;
	int weight;
	int height;
	String language;
}

//is-a relationship
//child class or subclass
class Student extends Person{
	
	String grade;
	int rollId;
}

class Employee extends Person{
	
	int empId;
	String dept;
	long salary;
	String position;
}




public class AccessModifiers {
	
	 int i; //instance variable
	 
	  long Salary;
	
	//default modifier - no modifier
	 private void print() {
		 i = 0;
		 System.out.println();
		System.out.println("inside protected method");
		
		//return 1;
		int i;
	}

}

class abc{
	void show() {
		AccessModifiers obj = new AccessModifiers();
		obj.Salary = 10000000;
		
		Employee Sudha = new Employee();
		Sudha.name = "Sudha";
		Sudha.height= 156;
		Sudha.weight = 55;
		Sudha.empId = 001;
		
		
		Student Shane = new Student();
		Shane.name = "Shane";
		Shane.height = 165;
		Shane.rollId = 2345;
		
		
		
	}
}
