
public class Constructors {
	
	public static void main(String[] args) {
		Person obj = new Person();
		Person obj1 = new Person("Sudha");
		obj1.show();			
	}

}

class Person {
	String name; //instance variable	
	//constructor overloading
	Person(){}
	
	 Person(String name){
		this.name = name;		
	}
	 
	 void show() {
		 
	 }	 
	 //this refers to the current object
	 	
}
