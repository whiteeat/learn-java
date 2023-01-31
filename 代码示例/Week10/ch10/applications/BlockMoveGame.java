import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class BlockMoveGame extends JFrame
{
	final int RC = 4;	// ������
	final int N = RC*RC;	// ��ĸ���
	//����num���ڼ�¼ÿ����ť�ϵ�����-1
	int []num = new int[N];   
	JButton [] btn = new JButton[N];
	JButton btnStart = new JButton("��ʼ��Ϸ");

	public BlockMoveGame(){
		setTitle( "�򵥵��ſ���Ϸ");
		setSize( 300, 350 );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//����ʼ,�����鸳ֵ,����ʾ��ť����
		JPanel pnlBody = new JPanel();
		JPanel pnlFoot = new JPanel();
		pnlBody.setLayout( new GridLayout( RC, RC ));
		pnlFoot.add( btnStart );
		getContentPane().setLayout( new BorderLayout() );
		getContentPane().add(pnlBody, BorderLayout.CENTER );
		getContentPane().add(pnlFoot, BorderLayout.SOUTH );

		Font font = new Font("Times New Rome", 0, 24 );
		for( int i=0; i<N; i++ ){
			num[i] = i;
			btn[i] = new JButton(""+ ( num[i] + 1 ));
			btn[i].setFont(font);
			pnlBody.add(btn[i]);
			btn[i].setVisible( true );
		}
		btn[N-1].setVisible( false ); //����ΪN-1�İ�ť����ʾ

		btnStart.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e){
				btnStart_Click();
			}
		});
		for( int i=0; i<N; i++ ){
			btn[i].addActionListener( new ActionListener(){
				public void actionPerformed( ActionEvent e){
					for( int j=0; j<N; j++ )
						if( (JButton)e.getSource() == btn[j] )
							btn_Click(j);
				}
			});
		}
	}

	public void btnStart_Click(){
		//����˳�򣬿�ʼ��Ϸ
		//����������±�,�������Ӧ������Ԫ��
		for( int i = 1; i<500; i++){ 
			int j = (int)(Math.random()* N);  
			int k = (int)(Math.random()* N);
			int t = num[j]; num[j] = num[k]; num[k] = t;
		}
		
		for( int i=0; i<N; i++ ){//��ʾ����
			btn[i].setText(""+ (num[i] + 1));
			btn[i].setVisible( true );
		}
		int blank = findBlank();  //������һ����ť��Ҫ����
		btn[blank].setVisible(false);
	}

	//�ҵ���һ��Ϊ��λ
	int findBlank(){  
		for(int i=0; i<N; i++ ){ 
			if( num[i] == N-1 ) return i; 
		}
		return -1; 
	}

	//��Index����ť���¼�����
	void btn_Click(int index){  
		int blank = findBlank();           //�ҵ��հװ�ť(���ص�)
		if( isNeighbor(blank, index)){       //�������
			btn[index].setVisible( false );  //һ������,һ����ʾ
			btn[blank].setVisible( true );   //���������ϵ�����
			int t = num[blank]; 
			num[blank] = num[index]; 
			num[index] = t;
			btn[blank].setText( ""+ (num[blank] + 1));
			btn[index].setText( ""+ (num[index] + 1));
			btn[blank].requestFocus();  //�����Ƶ�ԭ��ť�ϣ������û�����
		}
		checkResult();  //���ù���,����Ƿ����
	}

	//�ж��Ƿ�����
	boolean isNeighbor(int a, int b){  
		boolean r = false;
		if( a == b - RC || a == b + RC ) 
			r = true;  //��������
		if( (a == b - 1 || a == b + 1) && a / RC == b / RC ) 
			r = true; //��������,ע��Ҫ��ͬһ��
		return r;
	}
	//������Ƿ���ȫ��λ
	void checkResult(){  
		for(int i=0; i<N; i++ ){     
			if( num[i] != i ) return; 
		}
		JOptionPane.showMessageDialog(this,
			"��Ӯ��!���� [��ʼ] ����һ��.");
	}

	public static void main(String... args) {
		SwingUtilities.invokeLater(()->{
			new BlockMoveGame().setVisible(true);
		});
    }
}


