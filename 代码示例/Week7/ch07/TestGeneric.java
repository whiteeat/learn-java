import java.util.*;
class TestGeneric {
	public static void main(String[] args){ 
		Vector<Photo> album = new Vector<Photo>(); //ʹ�÷���
		album.addElement( new Photo("one",new Date(), "�ں���"));
		album.addElement( new Photo("two",new Date(), "��ɽ��"));
		album.addElement( new Photo("three",new Date(), "�ڿ�Ұ"));
		for( int i=0; i < album.size(); i++ ){
			Photo photo = album.elementAt(i);
			System.out.println( photo.toString() );
		}
		for( Photo photo : album ){  //ʹ����ǿ��for���
			System.out.println( photo.toString() );
		}
	}
}
class Photo {
	String title;
	Date date;
	String memo;
	Photo(String title, Date date, String memo){
		this.title = title;
		this.date = date;
		this.memo = memo;
	}
	public String toString(){
		return title + "(" + date + ")" + memo;
	}
}
