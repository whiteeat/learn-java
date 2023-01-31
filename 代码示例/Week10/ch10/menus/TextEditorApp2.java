import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.*;

class TextEditorFrame extends JFrame
{

	File file = null;
	Color color = Color.black;
	TextDAO dao = null;
	
	TextEditorFrame(TextDAO dao){
		this.dao = dao;

		initTextPane();
		initMenu();
		initAboutDialog();
		initToolBar();
	}

	void initTextPane(){ //���ı�������й������󣬲����뵽Frame��
		getContentPane().add( new JScrollPane(text) );
	}

	JTextPane text = new JTextPane();  //�ı���
	JFileChooser filechooser = new JFileChooser(); //�ļ�ѡ��Ի���
	JColorChooser colorchooser = new JColorChooser(); //��ɫѡ��Ի���
	JDialog about = new JDialog(this); //���ڶԻ���
	JMenuBar menubar = new JMenuBar(); //�˵�

	JMenu [] menus = new JMenu[] {
		new JMenu("File"),
		new JMenu("Edit"),
		new JMenu("Help")
	};
	JMenuItem menuitems [][] = new JMenuItem[][]{{
		new JMenuItem("New"), 
		new JMenuItem("Open..."),
		new JMenuItem("Save..."), 
		new JMenuItem("Exit")},{
		new JMenuItem("Copy"),
		new JMenuItem("Cut"),
		new JMenuItem("Paste"),
		new JMenuItem("Color...")},{
		new JMenuItem("About")}
	};

	void initMenu(){  //��ʼ���˵�
		for( int i=0; i<menus.length; i++ ){
			menubar.add( menus[i] );
			for( int j=0; j<menuitems[i].length; j++ ){
				menus[i].add( menuitems[i][j] );
				menuitems[i][j].addActionListener( action );
			}
		}
		this.setJMenuBar( menubar );
	}

	ActionListener action = new ActionListener(){ //�˵��¼�����
		public void actionPerformed( ActionEvent e ){
			JMenuItem mi = (JMenuItem)e.getSource();
			String id = mi.getText();
			if( id.equals("New" )){
				text.setText("");
				file = null;
			}else if( id.equals("Open...")){
				if( file != null ) filechooser.setSelectedFile( file );
				int returnVal = filechooser.showOpenDialog(
					TextEditorFrame.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					file = filechooser.getSelectedFile();
					openFile();
				}
			}else if( id.equals("Save...")){
				if( file != null ) filechooser.setSelectedFile( file );
				int returnVal = filechooser.showSaveDialog(
					TextEditorFrame.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					file = filechooser.getSelectedFile();
					saveFile();
				}
			}else if( id.equals("Exit")){
				System.exit(0);
			}else if( id.equals("Cut")){
				text.cut();
			}else if( id.equals("Copy")){
				text.copy();
			}else if( id.equals("Paste")){
				text.paste();
			}else if( id.equals("Color...")){
				color = JColorChooser.showDialog( 
					TextEditorFrame.this, "", color );
				text.setForeground(color);
			}else if( id.equals("About")){
				about.setSize(100,50);
				about.setVisible(true);
			}
		}
    };

	void saveFile(){ //�����ļ������ַ�д���ļ�
		String content = text.getText();
		dao.save(file, content);
	}
	void openFile(){ //�����ļ��������ַ������ı�����
		String content = dao.read(file);
		text.setText(content);
	}

	void initAboutDialog(){  // ��ʼ���Ի���
		about.getContentPane().add( new JLabel("�򵥱༭�� V1.0") );
		about.setModal( true );  
		about.setSize(100,50 );
	}
	
	JToolBar toolbar = new JToolBar();  //������
	JButton [] buttons = new JButton[] {
		new JButton( "", new ImageIcon("copy.jpg") ),
		new JButton( "", new ImageIcon("cut.jpg") ),
		new JButton( "", new ImageIcon("paste.jpg") )
	};
		
	void initToolBar(){  //���빤����
		for( int i=0; i<buttons.length; i++)
			toolbar.add( buttons[i] );
		buttons[0].setToolTipText( "copy" );
		buttons[0].addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				text.copy();
			}
		});
		buttons[1].setToolTipText( "cut" );
		buttons[1].addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				text.cut();
			}
		});
		buttons[2].setToolTipText( "paste" );
		buttons[2].addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				text.paste();
			}
		});
		this.getContentPane().add( toolbar, BorderLayout.NORTH );
		toolbar.setRollover(true);
	}
}

class TextEditorApp2  //Ӧ�ó���
{
	public static void main( String [] args){

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
				TextDAO dao = new FileTextDAO();
				TextEditorFrame f = new TextEditorFrame(dao);
				f.setTitle( "�򵥵ı༭��");
				f.setSize( 800, 600 );
				f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				f.setVisible(true);
            }
        });
	}
}

//------------- �������ݴ�ȡ��������־ ---------------
interface TextDAO {
    String read(File file);
    void save(File file, String text);
}


class FileTextDAO implements TextDAO {
	//�ӵ���־����
	Logger logger = Logger.getLogger( FileTextDAO.class.getName());
	{
		try{
			FileHandler handler = new FileHandler("TextEditorApp2.log");//������ %h/xxxx.log��ʾ���û���Ŀ¼��
			handler.setFormatter( new SimpleFormatter());
			logger.addHandler(handler);
		}catch(IOException ex){}
	}

    @Override
    public String read(File file) {
		logger.log(Level.INFO, "read", "read..." + file.getPath());

		try{
			FileReader fr = new FileReader( file );
			int len = (int) file.length();
			char [] buffer = new char[len];
			fr.read( buffer, 0, len );
			fr.close();
			return new String( buffer );
		}catch(Exception e ){ 
			e.printStackTrace(); 
            logger.log(Level.SEVERE, null, e);
		}
		return "";
	}

	@Override
    public void save(File file, String text) {
		logger.log(Level.INFO, "save", "save..." + file.getPath());
		try{
			FileWriter fw = new FileWriter( file );
			fw.write( text );
			fw.close();
		}catch(Exception ex ){ 
			ex.printStackTrace(); 
            logger.log(Level.SEVERE, null, ex);
		}
	}
}



