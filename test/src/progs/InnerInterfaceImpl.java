package progs;

public class InnerInterfaceImpl {

	public interface MyInterface {

		void func(int n);
		void func2(int n);
	}

	static class MyClass implements MyInterface{

		@Override
		public void func(int n) {
			System.out.println("Inside method using MyClass");
		}
		@Override
		public void func2(int n) {
			System.out.println("Inside method2 using MyClass");
		}
		
	}
	public static void main(String[] s) {

		MyInterface obj = new MyInterface() {

			@Override
			public void func(int n) {
				System.out.println("Inside method using outside def " + n);
			}
			@Override
			public void func2(int n) {
				System.out.println("Inside method2 using outside def " + n);
			}
		};

//		MyInterface obj2 = (n) -> {
//			System.out.println("Inside method using lamda" + n);
//		};
//		
		MyInterface obj3 = new MyClass();
		
		obj.func(1);
		//obj2.func(2);
		obj3.func(3);
	}
}
