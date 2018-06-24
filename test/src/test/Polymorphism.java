package test;

public class Polymorphism {

	public static void main(String s[]) {

		Parent p = new Parent();
		p.show1();

		// Parent p1 = new Parent();
		// Child c1 = (Child)p1;
		// c1.show1();
		// c1.show2();

		Parent p1 = new Child();
		p1.show1();
		p1.show2_parent();
		System.out.println(p1.a);
		// Error not accessible p1.show2_child();

		Child c = new Child();
		c.show1();
		c.show2_child();
		c.show2_parent();

		Parent p2 = new Child();
		Child c2 = (Child) p2;
		c2.show1();
		c2.show2_child();
		c2.show2_parent();
		System.out.println(c2.a);
	}
}

class Parent {
	int a = 10;

	public void show1() {
		System.out.println("Parent: show " + a);
	}

	public void show2_parent() {
		System.out.println("Parent: show2 " + a);
	}
}

class Child extends Parent {
	int a = 20;

	public void show1() {
		System.out.println("Child : show " + a);
	}

	public void show2_child() {
		System.out.println("child : SHow2 " + a);
	}
}