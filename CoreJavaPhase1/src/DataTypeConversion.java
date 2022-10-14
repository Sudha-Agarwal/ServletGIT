import package1.AccessModifiers;
import package1.Chair;

//import package1.AccessModifiers;

//import packagename.classname

public class DataTypeConversion {
	public static void main(String[] args) {
		int i = 10;
		
		float f = (float)10.0;//explicit type casting
		
		double d = 10.0f;  //implicit type casting
		
		short s = 10000;
		
		long l = 100000;
		
		//range of short data type is -32,768 to 32,767
		
		DataTypeConversion obj = new DataTypeConversion();
		obj.print(10L, 20);
		
		
		AccessModifiers obj1 = new AccessModifiers();
		obj1.print();
		
		Chair chair_obj = new Chair();
		
		
		
		
	}
	//method overloading
	void print(int a, int b) {
		System.out.print("method with int parameters");
		
	}
	
	float print(long a, int b) {
		System.out.print("method with long parameters");
		return 10.0f;		
	}
	
	

}
