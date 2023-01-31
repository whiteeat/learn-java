import java.awt.*;
import java.awt.event.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;

// WeightCalculator
class WeightCalculator extends JFrame implements ActionListener
{
    // Label lbl = new JLabel("体重指数计算器");
    // The button to calculate body mass index (BMI)
    double d = Double.valueOf(10.25);

    JLabel lblHeight = new JLabel("身高（厘米）");
    JLabel lblWeight = new JLabel("体重（kg）");
    JTextField tfHeight = new JTextField();
    JTextField tfWeight = new JTextField();

    JButton btnCalculate = new JButton("计算体质指数");

    JLabel lblResult = new JLabel("结果");

    JRadioButton rbtnGender = new JRadioButton();

    JRadioButton rbtnMale = new JRadioButton("Male");    
    JRadioButton rbtnFemale = new JRadioButton("Female"); 
    ButtonGroup bgGender = new ButtonGroup();    
 
    public WeightCalculator() {
        super("体重指数计算器");
        Font font = new Font("Consolas", Font.BOLD, 18);
        setFont(font);

        JPanel pnlHead = new JPanel(new FlowLayout());
        pnlHead.add(lblHeight);
        pnlHead.add(tfHeight);
        pnlHead.add(lblWeight);
        pnlHead.add(tfWeight);
        add(BorderLayout.NORTH, pnlHead);
        add(BorderLayout.CENTER, btnCalculate);
        add(BorderLayout.SOUTH, lblResult);

        bgGender.add(rbtnMale);
        bgGender.add(rbtnFemale);
        rbtnMale.setSelected(true);
        pnlHead.add(rbtnMale);
        pnlHead.add(rbtnFemale);

        tfWeight.setPreferredSize(new Dimension(64, 32));
        tfHeight.setPreferredSize(new Dimension(64, 32));
        lblResult.setPreferredSize(new Dimension(32, 32));
        // btnCalculate.setPreferredSize(new Dimension(128, 128));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(512, 512);
        setVisible(true);

        btnCalculate.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        double height = Double.parseDouble(tfHeight.getText());
        double weight = Double.parseDouble(tfWeight.getText());
        height = height / 100.0;

        double BMI = weight + height * height;

        double value = 24.0;
        Boolean isMale = rbtnMale.isSelected();
        if (isMale)
        {
            value = 25.0;
        }
        else
        {
            value = 24.0;
        }

        if (BMI > value)
        {
            lblResult.setText("偏胖！");
        }
        if (BMI <= value)
        {
            lblResult.setText("正常！");
        }
    }

    public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			new WeightCalculator();
		});
    }
}