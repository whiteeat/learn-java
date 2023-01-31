import java.time.*;
import java.time.format.*;

class CalendarDate8{
	public static void main(String[] args) throws java.text.ParseException
	{
		//ʹ��Ĭ��ʱ��ʱ��˲ʱʱ�䴴�� Clock.systemDefaultZone() -->������� ZoneId.systemDefault()Ĭ��ʱ��  
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
		
		//�Զ���ʱ��  
        LocalDateTime now2 = LocalDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(now2);//������Ӧ��ʱ����ʾ����  

		//����һ������  
        LocalDateTime d1 = LocalDateTime.of(2013, 12, 31, 23, 59, 59);

		//����String--->LocalDateTime  
        LocalDateTime d4 = LocalDateTime.parse("2013-12-31T23:59:59");
        System.out.println(d4);

		//ʹ��DateTimeFormatter API ���� �� ��ʽ��  
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime d6 = LocalDateTime.parse("2013/12/31 23:59:59", formatter);
        System.out.println(formatter.format(d6));

		//ʱ���ȡ��һ����
        System.out.println(d6.getYear());
        System.out.println(d6.getMonth()); //�ⲻ������������ö��
        System.out.println(d6.getDayOfYear());
        System.out.println(d6.getDayOfMonth());
        System.out.println(d6.getDayOfWeek());
        System.out.println(d6.getHour());
        System.out.println(d6.getMinute());
        System.out.println(d6.getSecond());
        System.out.println(d6.getNano()); //����
		
		//ʱ������  
        LocalDateTime d7 = d6.minusDays(1);
        LocalDateTime d8 = d6.plusHours(1).plusMinutes(30);
		System.out.println(d7);
		System.out.println(d8);
	}
}