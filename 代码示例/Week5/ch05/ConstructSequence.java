class ConstructSequence 
{
	public static void main(String[] args){ 
		Person p = new Student("����", 18, "����");
	}
}

class Person
{
	String name="δ����";  //step 2
	int age=-1;
	Person( String name, int age ){
		super(); //step 1
		//step 3
		System.out.println( "��ʼ����Person(),��ʱthis.name="+this.name+",this.age="+this.age );
		this.name=name; this.age=age; 
		System.out.println( "Person()�������,��ʱthis.name="+this.name+",this.age="+this.age );
	}
}

class Student extends Person
{
	String school="δ��ѧУ"; //step2 
	Student( String name, int age, String school ){
		super( name, age );  //step 1
		//step 3
		System.out.println( "��ʼ����Student(),��ʱthis.name="+this.name+",this.age="+this.age+",this.school="+this.school );
		this.school = school;
		System.out.println( "Student()�������,��ʱthis.name="+this.name+",this.age="+this.age+",this.school="+this.school );
	}
}

