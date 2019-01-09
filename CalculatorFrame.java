// JFrame class for the Calculator 

import javax.swing.*;
import java.awt.Dimension;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.*;

public class CalculatorFrame extends JFrame implements ActionListener{
	
	// Variables for the Calculator Class
	
	private ResultPanel rPanel; 
	private BinaryTextArea bTextArea;
	private WordLengthPanel wPanel; 
	private BasePanel bPanel;
	private CalcMenuBar mBar; 
	private NumPanel nPanel;
	private Operations op; 
	private Double result;
	private double value; 
	private int baseResult, base;
	private String n;
	
	public CalculatorFrame() {
		// Create the objects for the calculator 
		rPanel = new ResultPanel(); 
		bTextArea = new BinaryTextArea(rPanel);
		wPanel = new WordLengthPanel();
		bPanel = new BasePanel(this);
		mBar = new CalcMenuBar(this); 
		nPanel = new NumPanel(this); 
		op = new Operations();
		base = 1; 
		
		// Disable necessary components
		bTextArea.setEditable(false);
		
		// Modify dimensions of necessary components
		mBar.setPreferredSize(new Dimension (675, 25));
		bTextArea.setPreferredSize(new Dimension(650,75));
		wPanel.setPreferredSize(new Dimension(75, 100));
		bPanel.setPreferredSize(new Dimension(75, 100));
		nPanel.setPreferredSize(new Dimension(550, 225));
		
		// Modify Layout
		getContentPane().setLayout(new FlowLayout(5));
		
		// Change the Layout of the Frame
		add(mBar);
		add(rPanel);
		add(bTextArea);
		add(bPanel);
		add(nPanel);
		add(wPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
	}
	
	public void manageNumberClick(JButton btn) {
		// Deal with setting result value
		String s = btn.getText();
		rPanel.setText(s);
		bTextArea.setText();
		op.numClick(s);
	}
	
	public void manageHexClick(JButton btn) {
		// Deal with the hex buttons
		String s = btn.getText(); 
		rPanel.setText(s);
		bTextArea.setTextHex();
		op.hexClick(s);		
	}
	
	public void manageHexBase() {
		// Deal with the change of base to a hex one
		nPanel.baseChangeHex();
		Long i = (long) 0;
		if(base == 1) {
			n = rPanel.getText(); 
			value = Double.parseDouble(n);
			baseResult = (int)(value);
			n = Long.toHexString(baseResult);
		}
		else if(base == 2) {
			String o = rPanel.getText();
			i = Long.valueOf(o, 8);
			n = Long.toHexString(i);
		}
		else if(base == 3) {
			String b = rPanel.getText(); 
			i = Long.valueOf(b, 2);
			n = Long.toHexString(i);
		}
		rPanel.clearText();
		rPanel.setText(n);
		base = 0;
	}
	
	public void manageDecBase() {
		// Deal with change to decimal base(default)
		nPanel.baseChangeDec();
		Long i = (long) 0;
		if(base == 0) {
			String h = rPanel.getText(); 
			i = Long.valueOf(h, 16);
			n = Long.toString(i);
		}
		else if(base == 2) {
			String o = rPanel.getText();
			i = Long.valueOf(o, 8);
			n = Long.toString(i);
		}
		else if(base == 3) {
			String b = rPanel.getText(); 
			i = Long.valueOf(b, 2);
			n = Long.toString(i);
		}
		rPanel.clearText();
		rPanel.setText(n);
		base = 1;
	}
	
	public void manageOctBase() {
		// Deal with change to octal base
		nPanel.baseChangeOctal();
		Long i = (long) 0;
		if(base == 0) {
			String h = rPanel.getText(); 
			i = Long.valueOf(h, 16);
			n = Long.toOctalString(i);
		}
		else if(base == 1) {
			n = rPanel.getText(); 
			value = Double.parseDouble(n);
			baseResult = (int)(value);
			n = Integer.toOctalString(baseResult);
		}
		else if(base == 3) {
			String b = rPanel.getText(); 
			i = Long.valueOf(b, 2);
			n = Long.toOctalString(i);
		}
		rPanel.clearText();
		rPanel.setText(n);
		base = 2;
	}
	
	public void manageBinBase() {
		// Deal with change to binary base
		nPanel.baseChangeBin();
		Long i = (long) 0;
		if(base == 0) {
			String h = rPanel.getText();
			i = Long.valueOf(h, 16);
			n = Long.toBinaryString(i);
		}
		else if(base == 1) {
			n = rPanel.getText(); 
			value = Double.parseDouble(n);
			baseResult = (int)(value);
			n = Long.toBinaryString(baseResult);
		}
		else if(base == 2) {
			String o = rPanel.getText(); 
			i = Long.valueOf(o, 8);
			n = Long.toBinaryString(i);
		}
		rPanel.clearText();
		rPanel.setText(n);
		base = 3;
	}
	
	public void manageClear() {
		// Deal with Clear operations
		op = new Operations(); 
		rPanel.clearText();
		bTextArea.clearText();
	}
	
	public void manageClearE() {
		// Deal with clearE
		op.clearE();
		rPanel.clearText();
		bTextArea.clearText();
	}
	
	public void manageEqualBtn() {
		// Deal with the equal button and execute operations
		rPanel.clearText();
		result = op.execute();
		if(result == Integer.MIN_VALUE)
		{
			rPanel.setText("Divide by 0 error!");
			bTextArea.clearText();
			op = new Operations();
		}
		else{
			rPanel.setText(result.toString()); 
			bTextArea.setText();
		}
	}
	
	public void manageOperationsClick(JButton btn) {
		// Deal with the different operations
		rPanel.clearText();
		bTextArea.setText();
		op.opClick(btn.getText());		
	}
	
	public void manageBackSpace() {
		// Deal with the backspace operation
		rPanel.backSpace(); 
		bTextArea.setText();
		op.backSpace();
	}
	
	public void manageSignChange() {
		// Deal with the sign button	
		op.signClick();
		rPanel.signChange();
		bTextArea.setText();
	}
	
	public void hideCalculator() {
		// Hide the calculator when pressed 
		rPanel.setVisible(false);
		bTextArea.setVisible(false);
		bPanel.setVisible(false);
		wPanel.setVisible(false);
		nPanel.setVisible(false);
	}
	
	public void showCalculator() {
		// Show the components of the calculator
		rPanel.setVisible(true);
		bTextArea.setVisible(true);
		bPanel.setVisible(true);
		wPanel.setVisible(true);
		nPanel.setVisible(true);
	}
	
	public void copyResult() {
		// Copy contents of result into clipboard
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		c.setContents(new StringSelection(rPanel.getText()), null);
	}
	
	public void viewHelp() {
		// Variables for View Help
		JFrame helpFrame = new JFrame();
				JTextArea viewArea = new JTextArea("Description of the calculator:"
						+ "\n1) The calculator operates closely to the Windows Programming Calculator, with buttons having the same functionality"
						+ "\n2) It performs order of operations like the Windows Programming Calculator."
						+ "\n3) The custom menu bar operates with a View pane to hide/show the calculator, Edit to copy contents and Help for more info."
						+ "\n4) It can do basic conversion of outputs into Hexadecimal, Decimal, Octal and Binary base by pressing the radio buttons."
						+ "\n5) It has a Text Area that dynamically outputs the numbers inputted and results in a 64-bit binary word."
						+ "\n6) Buttons light up when selected in order to know which button is going to the input when hovered over."
						+ "\n7) The '+/-' sign changes the sign of the current input, 'CE' clears previous number entry, 'C' clears the operation."
						+ "\n8) The divide by 0 error is accounted for, however, clear the calculator to delete the message"
						+ "\n9) In order to process operations you have to press the '=' once all operation are inputted");
				
		helpFrame.setSize(new Dimension(1000, 300));
		helpFrame.setVisible(true);
		helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewArea.setPreferredSize(new Dimension(1000, 300));
		viewArea.setFont(new Font("Serif", Font.BOLD, 18));
		viewArea.setLineWrap(true);
		helpFrame.add(viewArea, BorderLayout.NORTH);
		viewArea.setEditable(false);
	}
	
	public void aboutItem() {
		// Variables for About
		JFrame aboutFrame = new JFrame();
		JTextArea aboutArea = new JTextArea("Calculator designed and built by Miguel de la Rocha. Semester Project 1."
				+ "\nAll rights reserved 2016.");
		
		aboutFrame.setSize(new Dimension(500, 100));
		aboutFrame.setVisible(true);
		aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		aboutArea.setPreferredSize(new Dimension(500, 100));
		aboutFrame.add(aboutArea, BorderLayout.NORTH);
		aboutArea.setEditable(false);
	}
}
