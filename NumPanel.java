// Class for the panel containing the numbers of the calculator

import java.awt.GridLayout;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class NumPanel extends JPanel implements ActionListener, MouseListener {
	// Declare necessary variables for the class
	
	private CalculatorFrame frame;
	private JButton quot, mod, backSpace, clearE, clear, signs, squareRoot,
					percentage, reciprocal, decPoint; 
	private String [] hex = {"A", "B", "C", "D", "E", "F"}; 
	private JButton hexBtns[] = new JButton[6];
	private String [] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	private JButton numBtns[] = new JButton[10];
	private JButton addBtn, subBtn, mulBtn, divBtn, equalBtn; 
	private JButton blankBtns[] = new JButton[18]; 
	
	public NumPanel(CalculatorFrame frame) {
		this.frame = frame;
		// Set the Layout of the NumberPanels
		this.setLayout(new GridLayout(6, 8));
		// Initilialize the components
		myInitComponents(); 
		// Add the components to the panel
		addComponents();
	}
	
	public void myInitComponents() {
		// Initialize Components
		// Special event buttons 
		
		mod = new JButton("Mod"); 
		backSpace = new JButton("<-");
		clearE = new JButton("CE"); 
		clear  = new JButton("C");
		signs  = new JButton("+/-");
		
		// Disable some of the buttons
		squareRoot = new JButton("SqRt");
		squareRoot.setEnabled(false);
		percentage = new JButton("%");
		percentage.setEnabled(false);
		reciprocal = new JButton("1/x");
		reciprocal.setEnabled(false);
		decPoint = new JButton(".");
		decPoint.setEnabled(false);
		for (int i = 0; i < blankBtns.length; i++) 
		{
			blankBtns[i] = new JButton();
			blankBtns[i].setEnabled(false);
		}
			
		// Hex Letter Buttons
		
		for(int i = 0; i < hex.length; i++) {
			hexBtns[i] = new JButton("" + hex[i]);
			hexBtns[i].setEnabled(false);
		}
		
		// Numbers
		
		for(int i = 0; i < nums.length; i++) {
			numBtns[i] = new JButton("" + nums[i]);
		}
		
		// Operations 
		addBtn = new JButton("+");
		subBtn = new JButton("-");
		mulBtn = new JButton("*");
		divBtn = new JButton("/"); 
		equalBtn = new JButton("=");
	}
	
	public void addComponents() {
		// Add the components to the panel
		// Also add the action listeners for the buttons
		
		this.add(blankBtns[17]);
		
		this.add(mod);
		mod.addActionListener(this);
		mod.addMouseListener(this);
		
		this.add(hexBtns[0]); 
		for (int i = 0; i < 7; i++)
			this.add(blankBtns[i]);
		
		this.add(hexBtns[1]);
		
		this.add(backSpace);
		backSpace.addActionListener(this);
		backSpace.addMouseListener(this);
		
		this.add(clearE);
		clearE.addActionListener(this);
		clearE.addMouseListener(this);
		
		this.add(clear);
		clear.addActionListener(this);
		clear.addMouseListener(this);
		
		this.add(signs);
		signs.addActionListener(this);
		signs.addMouseListener(this);
		
		this.add(squareRoot);
		for (int i = 7; i < 9; i++)
			this.add(blankBtns[i]);
		
		this.add(hexBtns[2]); 
		for (int i = 7; i < nums.length; i++)
			this.add(numBtns[i]);
		
		this.add(divBtn);
		divBtn.addActionListener(this);
		divBtn.addMouseListener(this);
		
		this.add(percentage);
		for (int i = 9; i < 11; i++)
			this.add(blankBtns[i]);
		
		this.add(hexBtns[3]);
		for (int i = 4; i < 7; i++)
			this.add(numBtns[i]);
		
		this.add(mulBtn);
		mulBtn.addActionListener(this);
		mulBtn.addMouseListener(this);
		
		this.add(reciprocal);
		for (int i = 11; i < 13; i++)
			this.add(blankBtns[i]);
		
		this.add(hexBtns[4]);
		for (int i = 1; i < 4; i++)
			this.add(numBtns[i]);
		
		this.add(subBtn);
		subBtn.addActionListener(this);
		subBtn.addMouseListener(this);
		
		for (int i = 13; i < 16; i++)
			this.add(blankBtns[i]);
		
		this.add(hexBtns[5]);
		this.add(numBtns[0]); 
		this.add(decPoint);
		this.add(blankBtns[16]);
		
		this.add(addBtn);
		addBtn.addActionListener(this);
		addBtn.addMouseListener(this);
		
		this.add(equalBtn);
		equalBtn.addActionListener(this);
		equalBtn.addMouseListener(this);
		
		for(int i = 0; i < hexBtns.length; i++) {
			hexBtns[i].addActionListener(this);
			hexBtns[i].addMouseListener(this);
		}
		for(int i = 0; i < numBtns.length; i++) {
			numBtns[i].addActionListener(this);
			numBtns[i].addMouseListener(this);
		}
	}
	
	public void baseChangeHex() {
		// Display the hex buttons when in hex base
		for(int i = 0; i < hexBtns.length; i++) {
			hexBtns[i].setEnabled(true);
		}
		for(int i = 0; i < numBtns.length; i++) {
			numBtns[i].setEnabled(true);
		}
	}
	
	public void baseChangeOctal() {
		// Hide the buttons needed for Octal base
		for(int i = 0; i < hexBtns.length; i++) {
			hexBtns[i].setEnabled(false);
		}
		for(int i = 0; i < numBtns.length; i++) {
			if(i <= 7)
			{
				numBtns[i].setEnabled(true);
			}
			else
				numBtns[i].setEnabled(false);
		}
	}
	
	public void baseChangeBin() {
		// Disable necessary buttons for binary base
		for(int i = 0; i < hexBtns.length; i++) {
			hexBtns[i].setEnabled(false);
		}
		for(int i = 2; i < numBtns.length; i++) {
			numBtns[i].setEnabled(false);
		}
	}
	
	public void baseChangeDec() {
		// Enable and disable necessary buttons
		for(int i = 0; i < numBtns.length; i++) {
			numBtns[i].setEnabled(true);
		}
		for(int i = 0; i < hexBtns.length; i++) {
			hexBtns[i].setEnabled(false);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		// Num buttons
		for(int i = 0; i < numBtns.length; i++)
		{
			if(e.getSource() == numBtns[i]) {
				frame.manageNumberClick(numBtns[i]);
			}
		}
		// Hex buttons
		for(int i =0; i < hexBtns.length; i++)
		{
			if(e.getSource() == hexBtns[i])
				frame.manageHexClick(hexBtns[i]);
		}
		// Clear buttons
		if(e.getSource() == clear)
			frame.manageClear();
		if(e.getSource() == clearE)
			frame.manageClearE();
		// Equal buttons
		if(e.getSource() == equalBtn)
			frame.manageEqualBtn();
		// Operation buttons
		if(e.getSource() == addBtn)
			frame.manageOperationsClick(addBtn);
		else if (e.getSource() == subBtn) 
			frame.manageOperationsClick(subBtn);
		else if (e.getSource() == divBtn)
			frame.manageOperationsClick(divBtn);
		else if (e.getSource() == quot)
			frame.manageOperationsClick(quot); 
		else if (e.getSource() == mulBtn)
			frame.manageOperationsClick(mulBtn);
		else if (e.getSource() == mod)
			frame.manageOperationsClick(mod);
		// Backspace button
		if(e.getSource() == backSpace)
			frame.manageBackSpace();
		// Signs button
		if(e.getSource() == signs)
			frame.manageSignChange(); 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Change the color of the buttons when hovered over
		for(int i = 0; i < numBtns.length; i++)
		{
			if(e.getSource() == numBtns[i] && numBtns[i].isEnabled() == true) {
				numBtns[i].setBackground(Color.ORANGE);
			}
		}
		// Hex buttons
		for(int i =0; i < hexBtns.length; i++)
		{
			if(e.getSource() == hexBtns[i] && hexBtns[i].isEnabled() == true)
				hexBtns[i].setBackground(Color.ORANGE);
		}
		// Clear buttons
		if(e.getSource() == clear)
			clear.setBackground(Color.ORANGE);
		if(e.getSource() == clearE)
			clearE.setBackground(Color.ORANGE);
		// Equal buttons
		if(e.getSource() == equalBtn)
			equalBtn.setBackground(Color.ORANGE);
		// Operation buttons
		if(e.getSource() == addBtn)
			addBtn.setBackground(Color.ORANGE);
		else if (e.getSource() == subBtn) 
			subBtn.setBackground(Color.ORANGE);
		else if (e.getSource() == divBtn)
			divBtn.setBackground(Color.ORANGE);
		else if (e.getSource() == mulBtn)
			mulBtn.setBackground(Color.ORANGE);
		else if (e.getSource() == mod)
			mod.setBackground(Color.ORANGE);
		// Backspace button
		if(e.getSource() == backSpace)
			backSpace.setBackground(Color.ORANGE);
		// Signs button
		if(e.getSource() == signs)
			signs.setBackground(Color.ORANGE); 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Change the color of the buttons when not hovered over
		for(int i = 0; i < numBtns.length; i++)
		{
			if(e.getSource() == numBtns[i]) {
				numBtns[i].setBackground(null);
			}
		}
		// Hex buttons
		for(int i =0; i < hexBtns.length; i++)
		{
			if(e.getSource() == hexBtns[i])
				hexBtns[i].setBackground(null);
		}
		// Clear buttons
		if(e.getSource() == clear)
			clear.setBackground(null);
		if(e.getSource() == clearE)
			clearE.setBackground(null);
		// Equal buttons
		if(e.getSource() == equalBtn)
			equalBtn.setBackground(null);
		// Operation buttons
		if(e.getSource() == addBtn)
			addBtn.setBackground(null);
		else if (e.getSource() == subBtn) 
			subBtn.setBackground(null);
		else if (e.getSource() == divBtn)
			divBtn.setBackground(null);
		else if (e.getSource() == mulBtn)
			mulBtn.setBackground(null);
		else if (e.getSource() == mod)
			mod.setBackground(null);
		// Backspace button
		if(e.getSource() == backSpace)
			backSpace.setBackground(null);
		// Signs button
		if(e.getSource() == signs)
			signs.setBackground(null); 
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
	
}
