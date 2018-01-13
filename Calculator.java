import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import acm.gui.TableLayout;
import acm.program.*;
import acm.util.*;
import java.awt.geom.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator extends JFrame implements ActionListener{
	
	JButton one,two,three,four,five,six,seven,eight,nine,zero,dot,minus,plus,multiply,divide,equal,clear;
	JLabel Input,Output;
	JSlider digitsSlider;
	JTextField enter,result,digit;
	JTextArea NumOfDigits;
	JPanel panel1,panel2;
	GridBagConstraints gbc;
	String I,O;

 	public Calculator () {
 		super("Jamie's Calculator");
 		
 		initFrame();
 		initVariables();
 		addTextFields();
 		addButtons();
 		
 		add(panel1, BorderLayout.SOUTH);
 		add(panel2, BorderLayout.NORTH);
 		
 	}
 	
 	public void initFrame() {
 		
 		setSize(400,250);
 		setLocation(500,250);
 		setDefaultCloseOperation(EXIT_ON_CLOSE);
 		getContentPane().setBackground(Color.decode("#444F5A"));
 		setResizable(false);
 		
 	}
 	
 	public void initVariables() {

 		panel1 = new JPanel();
 		panel2 = new JPanel();
 		
 		panel1.setBackground(Color.decode("#444F5A"));
 		panel2.setBackground(Color.decode("#444F5A"));
 		
 		gbc = new GridBagConstraints();
 		gbc.insets = new Insets(1,1,1,1);
 		I="0";
 		O="";
 		Input = new JLabel("Enter");
 		Input.setForeground(Color.white);
 		Output = new JLabel("Result");
 		Output.setForeground(Color.white);
 		enter = new JTextField(15);
 		result = new JTextField(15);
 	}
 	
 	public void addTextFields() {
 		panel2.setLayout(new TableLayout(3,2));
 		//first row
 		panel2.add(Input,gbc);
 		panel2.add(enter,gbc);
 		//second row
 		panel2.add(Output,gbc);
 		panel2.add(result,gbc);
 		enter.setText(I);
 		
 	}
 	
 	public void addButtons() {
 	
 		//layout
 		panel1.setLayout(new TableLayout(5,4));
 		
 		//first row
 		panel1.add(seven = new JButton("7"),gbc);
 		panel1.add(eight = new JButton("8"),gbc);
 		panel1.add(nine = new JButton("9"),gbc);
 		panel1.add(plus = new JButton("+"),gbc);
 		//second row
 		panel1.add(four = new JButton("4"),gbc);
 		panel1.add(five = new JButton("5"),gbc);
 		panel1.add(six = new JButton("6"),gbc);
 		panel1.add(minus = new JButton("-"),gbc);
 		//third row
 		panel1.add(one = new JButton("1"),gbc);
 		panel1.add(two = new JButton("2"),gbc);
 		panel1.add(three = new JButton("3"),gbc);	
 		panel1.add(multiply = new JButton("*"),gbc);
 		//fourth row
 		panel1.add(clear = new JButton("C"),gbc);
 		panel1.add(zero = new JButton("0"),gbc);
 		panel1.add(dot = new JButton("."),gbc);
 		panel1.add(divide = new JButton("/"),gbc);	
 		//fifth 
 		panel1.add(NumOfDigits = new JTextArea("Digits"),gbc);
 		panel1.add(digit = new JTextField(4),gbc);
 		panel1.add(digitsSlider = new JSlider(0,6,3),gbc);
 		panel1.add(equal = new JButton("="),gbc);	
 		
 		//customize buttons
 		NumOfDigits.setForeground(Color.WHITE);
 		NumOfDigits.setBackground(Color.decode("#444F5A"));
 		

 		//add actionListener to each button
 		one.addActionListener(this);
 		two.addActionListener(this);
 		three.addActionListener(this);
 		four.addActionListener(this);
 		five.addActionListener(this);
 		six.addActionListener(this);
 		seven.addActionListener(this);
 		eight.addActionListener(this);
 		nine.addActionListener(this);
 		zero.addActionListener(this);
 		plus.addActionListener(this);
 		minus.addActionListener(this);
 		multiply.addActionListener(this);
 		divide.addActionListener(this);
 		equal.addActionListener(this);
 		clear.addActionListener(this);
 		dot.addActionListener(this);
 		digitsSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				digit.setText(Integer.toString(digitsSlider.getValue()));
				CalcString cstr = new CalcString(enter.getText());		
				Double truncatedDouble = BigDecimal.valueOf(Double.parseDouble(cstr.getOutput())).setScale(digitsSlider.getValue(), RoundingMode.HALF_UP).doubleValue();
				result.setText(Double.toString(truncatedDouble));
			}
		});
 		
 	}
 		


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("C")) {
			I = "0";
			O = "";
			enter.setText(I);
			result.setText(O);
		} else if (e.getActionCommand().equals("=")) {
			// do evaluation based on the input string and return the value to the 
			CalcString cstr = new CalcString(enter.getText());		
			Double truncatedDouble = BigDecimal.valueOf(Double.parseDouble(cstr.getOutput())).setScale(digitsSlider.getValue(), RoundingMode.HALF_UP).doubleValue();
			result.setText(Double.toString(truncatedDouble));
		}  
			
		else {
			//add this button's string to the input string 
			I += e.getActionCommand();
			enter.setText(I);
		}
	}
 	
 	
}