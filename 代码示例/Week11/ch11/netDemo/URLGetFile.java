
import java.io.*; 
import java.net.*; 
import java.awt.*;
import java.awt.event.*;
import java.applet.*; 
public class URLGetFile extends Applet{ 
	
	TextField txtUrl = new TextField("http://www.baidu.com");
	Button btn = new Button("��ȡ��ҳ����");
	TextArea txtContent = new TextArea("���ص����ݣ�"); 

	public void init() { 
		add(txtUrl);
		add(btn);
		add(txtContent);

		btn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String strurl = txtUrl.getText(); 
				try { 
					URL url= new URL(strurl); 
					txtContent.setText("");
					getPageContent(url);
				}catch ( MalformedURLException e) { 
					System.out.println("URL��ʽ�д�" ); 
				}
			}
		});
	} 

	public void getPageContent(URL url) { 
		InputStream filecon = null; 
		BufferedReader filedata = null; 
		String line; 
		try { 
			filecon = url.openStream(); 
			filedata = new BufferedReader(new InputStreamReader(filecon,"UTF-8")); 
			while ((line = filedata.readLine()) != null) { 
				txtContent.append(line+"\n"); 
			} 
		}catch (IOException e) { 
			System.out.println("Error in I/O:" + e.getMessage()); 
		} 
	} 
	public static void main( String[] args){
		Frame f = new Frame("URL Test");
		Applet ap = new URLGetFile();
		ap.init();
		f.add(ap);
		f.addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent e){System.exit(0);}
		});
		f.setSize( 400,300 );
		f.setVisible(true);
		ap.start();
	}
} 
