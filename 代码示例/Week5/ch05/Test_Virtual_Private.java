class Test_Virtual_Private{
	public static void main(String[]s){
		A a = new A();
		a.t(6);
		B b = new B();
		b.t(6);
		A c = new B();
		c.t(6);
	}
}
class A {
	void t(int a ){ System.out.println("A-t "); f(a); }
	private void f(int a){ 
		System.out.println("A-f "+ a);
	}
}
class B extends A {
	//void t(int a ){ System.out.println("T-b "); f(a); } //Ҫ�벻Ҫ��������������ͬ
	private void f(int a){ System.out.println("B-f " + a);
	}
}
