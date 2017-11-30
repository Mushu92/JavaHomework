import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {
	private JTextField input;
	private JButton[] btn = new JButton[15];
	private boolean ccomplete;
	private String[] btnName = { "7", "8", "9","4","5","6", "1","2","3","0","+","*","D","C","="};
	ArrayList<String> yunsan = new ArrayList<String>();
	ArrayList<BigInteger> num = new ArrayList<BigInteger>();

	public Calculator() {
		JPanel panel;
		setTitle("Calculator");
		setSize(200, 250);
		init(panel = new JPanel(null));
		setContentPane(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init(JPanel panel) {
		JPanel inPanel = new JPanel(new BorderLayout());
		inPanel.setBounds(10, 10, 165, 195);
		panel.add(inPanel);
		input = new JTextField("0", 15);
		input.setHorizontalAlignment(JTextField.RIGHT);
		inPanel.add(input, "North");
		JPanel btnPanel = new JPanel(new GridLayout(5, 3, 4, 4));
		inPanel.add(btnPanel, "South");
		ccomplete = false;
		for (int i = 0; i < btn.length; i++) {
			btnPanel.add(btn[i] = new JButton(btnName[i]));
			btn[i].addActionListener(this);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			String sNum = input.getText();
			if (e.getActionCommand().equals("=")) {
				String[] dstr = sNum.split("[*]|[+]");
				for(int i=0; i<dstr.length; i++) {
					if(dstr[i].contains("D")) {
						String s = dstr[i].replaceAll("D","");
						BigInteger c = new BigInteger(s);
						BigInteger a = new BigInteger("2");
						c = c.multiply(a);
						num.add(c);
					}else {
						BigInteger c = new BigInteger(dstr[i]);
						num.add(c);
					}
				}
				BigInteger res = BigInteger.ZERO;
				res = res.add(num.get(0));
				for(int i=0; i<yunsan.size(); i++) {
					if(yunsan.get(i) == "*") {
						res=res.multiply(num.get(i+1));
					}
					else if(yunsan.get(i)=="+") {
						res=res.add(num.get(i+1));
					}
				}
				input.setText(res.toString());
				ccomplete = true;
				yunsan.clear();
				num.clear();
				
			}
			else if(e.getActionCommand().equals("*")){
				if(sNum.charAt(sNum.length()-1)=='*'|sNum.charAt(sNum.length()-1)=='+'){
					String s = sNum.substring(0, sNum.length()-1);
					yunsan.set(yunsan.size()-1, e.getActionCommand());
					input.setText(s+e.getActionCommand());
				}
				else {
					yunsan.add(e.getActionCommand());
					input.setText(sNum+e.getActionCommand());
				}
				
			}
			else if(e.getActionCommand().equals("+")){
				if(sNum.charAt(sNum.length()-1)=='*'|sNum.charAt(sNum.length()-1)=='+'){
					String s = sNum.substring(0, sNum.length()-1);
					yunsan.set(yunsan.size()-1, e.getActionCommand());
					input.setText(s+e.getActionCommand());
				}
				else {
					yunsan.add(e.getActionCommand());
					input.setText(sNum+e.getActionCommand());
				}
			}
			else if(e.getActionCommand().equals("C")){
				yunsan.clear();
				num.clear();
				input.setText("0");
			}
			else {
				String digit = e.getActionCommand();
				if(ccomplete == true) {
					input.setText(digit);
					ccomplete = false;
				}
				else input.setText(sNum.equals("0") ? digit : sNum + digit);
			}
		}
	}

	public static void main(String[] args) {
		JFrame jf = new Calculator();
		jf.setVisible(true);
		// Scanner sc = new Scanner(System.in);
		// System.out.println(sc.nextInt() * 2);
		// sc.close();
	}
}