import java.util.*;
class TCovarContravar{
	public static void main( String[]args){
		List<Fruit> f = new ArrayList<Fruit>();
		List<Apple> a = new ArrayList<Apple>();
		f.add( new Fruit()); 
		a.add( new Apple());
		f.add( new Apple());
		//a.add( new Fruit());//��䲻��

		//f = a; //��䲻��
		//a = f; //��䲻��

		List<? extends Fruit> f2 = a; //Э��
		//f2.add( new Fruit() ); //��䲻��
		//f2.add( new Apple() ); //��䲻��
		Fruit fo = f2.get(0);

		List<? super Apple> a2 = f; //���

		//List<? super Fruit> f3 = a; //��䲻��
		List<? super Apple> a3 = f;
		a3.add( new Apple() );
		//a3.add( new Fruit() ); //��䲻��
		//Apple ao = a3.get(0); //��䲻��
		//Fruit fo2 = a3.get(0); //��䲻��

	}

}
class Fruit {}
class Apple extends Fruit{}
class Banana extends Fruit{}
