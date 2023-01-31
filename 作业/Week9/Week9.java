import java.io.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.util.List;
import java.util.ArrayList;

class Recite extends JFrame{ 
	JLabel lblWord = new JLabel("word"); 
	JLabel lblMeaning = new JLabel("meaning"); 

	public void init() { 
        JButton btnInterval = new JButton("Interval: " + interval + " seconds");

		setSize( 400,100 );
		setLayout(new FlowLayout());
		getContentPane().add(lblWord);
		getContentPane().add(lblMeaning);
        getContentPane().add(btnInterval);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

        btnInterval.addActionListener((e)->{
            ++interval;
            if (interval > intervalMax)
            {
                interval = 1;
            }
            btnInterval.setText("Interval: " + interval + " seconds");
        });
	} 

	List<String> words = new ArrayList<>();
	List<String> meanings = new ArrayList<>();
	int current = 0;

    int intervalMax = 5;
    int interval = 3;
    int countdown = interval;

	public void start() {
		new Thread(()->{
			try{
				readAll();
			}catch(IOException ex){}
			new javax.swing.Timer(1000,(e)->{
                countdown--;
                if (countdown <= 0)
                {
                    lblWord.setText( words.get(current) );
                    lblMeaning.setText( meanings.get(current) );
                    current++;
                    countdown = interval;
                }
			}).start();
		}).start();
	}

	public void readAll( ) throws IOException{
		String fileName = "College_Grade4.txt";
		String charset = "GB2312";
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(
				new FileInputStream(fileName), charset)); 
		String line; 
		while ((line = reader.readLine()) != null) { 
	        line = line.trim();
			if( line.length() == 0 ) continue;
			int idx = line.indexOf("\t");
			words.add( line.substring(0, idx ));

            // Remove phonetic symbols, only keep meanings
			String meaningsAndPhoneticSymbols = line.substring(idx+1);
            idx = meaningsAndPhoneticSymbols.indexOf("\t");
			meanings.add(meaningsAndPhoneticSymbols.substring(0, idx));
		} 
		reader.close();
	}

	public static void main( String[] args){
		// File directory = new File("./");
		// System.out.println(directory.getAbsolutePath());

		Recite f = new Recite();
		f.init();
		f.start();
	}
}
