import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// WeightCalculator
class WeightCalculator extends JFrame implements ActionListener
{
    // Label lbl = new JLabel("体重指数计算器");
    // The button to calculate body mass index (BMI)

    JLabel lblHeight = new JLabel("身高");
    JLabel lblWeight = new JLabel("体重");
    JTextField tfHeight = new JTextField();
    JTextField tfWeight = new JTextField();

    JButton btnCalculate = new JButton("计算体质指数");

    public WeightCalculator() {
        super("体重指数计算器");
        Font font = new Font("Consolas", Font.BOLD, 18);
        setFont(font);

        JPanel pnlHead = new JPanel(new FlowLayout());
        pnlHead.add(lblHeight);
        pnlHead.add(lblWeight);
        pnlHead.add(tfHeight);
        pnlHead.add(tfWeight);
        add(BorderLayout.NORTH, pnlHead);
        add(btnCalculate, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(512, 512);
        setVisible(true);
    }

    public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			new WeightCalculator();
		});
    }
}