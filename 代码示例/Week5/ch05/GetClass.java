class GetClass 
{
	public static void main(String[] args) 
	{
		//ͨ�����ͻ����
       Class c1 = String.class;
       System.out.println(c1);

       //ͨ�����������
       String stringExample = "abc";
       Class c2 = stringExample.getClass();
       System.out.println(c2);

	   //ͨ��Class.forName
	   try{
		   Class c3 = Class.forName("java.lang.String");
		   System.out.println(c3);
	   }catch(ClassNotFoundException ex){
			System.out.println(ex);
	   }
	}
}
