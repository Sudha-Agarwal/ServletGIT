

public class AnimalRunner{
	public static void main(String[] args) {
		//static binding or early binding is done at the compilation
		Animal obj = new Dog();
		obj.sound("bark");
		
		
		//Dog dog_obj = new Cat();
		((Dog) obj).bite(); //user defined type casting
		
		//dynamic binding or late binding is done at run time
		Cat obj1 = new Cat();
		Cat returned_obj = obj1.sound("meow");
		//here obj is called as reference variable
		
		//Parent class reference variable is assigned an object of child class
		
		
		//array of objects
		Animal [] animal_arr = new Animal[5];
		animal_arr[0] = obj;
		animal_arr[1] = obj1;
		
		
		Animal ref = animal_arr[1];
		ref.sound("meow");		
		
	}
}
 abstract class Animal {
	
	String specie;
	
	//its an overridden method
	 public abstract void sound(String sound);
	 
	 //method overloading
	 void move() {
		 System.out.println("animal moving");
	 }
	 
	 void move(int a) {
		 System.out.println("animal moving");
	 }
	 
	 abstract void walk();

}

class Dog extends Animal{
	
	
	//method overriding
	 void sound(String sound) {
		System.out.println(sound);
		//return new Dog();
		
	}
	
	void bite() {
		System.out.println("dogs can bite");
	}
	
}

class Pug extends Dog{
	
}

class Cat extends Animal implements Walkable, Sleep{
	void sound(String sound) {
		System.out.println(sound);
		//return new Cat();
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub		
	}
}

interface Walkable{	
	void walk();
	
	
	//here default is not an access modifier
	default void walk1() {
		//this was introduced in java 8
	}
	
	//by default methods of an interface are public and abstract
}

interface Sleep{
	void sleep();
}
class Person implements Walkable{
	
}