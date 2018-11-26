package progs;

public class InheritencePractice {
	public static void main(String[] args) {

		Parent1 p = new Parent1();
		Child1 c = new Child1();
		p = (Parent1) c;
		c.fun2(c);
		c.fun2(p);
	}
}

class Parent1 {

	int i = 10;

	void func1() {

		System.out.println("Parent : func1");
	}

	void func4() {

		System.out.println("Parent : func4");
	}
}

class Child1 extends Parent1 {

	int i = 20;

	void func1() {

		System.out.println("Child : func1");
	}

	void fun2(Parent1 p) {
		p.func1();
		System.out.println(p.i);
	}

	void fun2(Child1 c) {
		c.func1();
	}
}
