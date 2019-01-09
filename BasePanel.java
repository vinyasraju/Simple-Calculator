// Class for the Bases Panel

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class BasePanel extends JPanel implements ActionListener {
	// Declare necessary variables for the panel
	
	private JRadioButton baseRadioButtons[];
	private String [] bases = {"Hex", "Dec", "Oct", "Bin"};
	private ButtonGroup btnGroup; 
	private CalculatorFrame cFrame;
	
	public BasePanel(CalculatorFrame frame) {
		// Make the panel for the word Length
		cFrame = frame;
		setLayout(new GridLayout(4,1));
		btnGroup = new ButtonGroup();
		baseRadioButtons = new JRadioButton[bases.length];
		setBorder(BorderFactory.createLineBorder(Color.black));
		for (int i = 0; i < bases.length; i++) {
				baseRadioButtons[i] = new JRadioButton(bases[i]);
				baseRadioButtons[i].addActionListener(this);
				btnGroup.add(baseRadioButtons[i]); 
				add(baseRadioButtons[i]);
		}
		
		// Set the decimal option as the default 
		
		baseRadioButtons[1].setSelected(true);
	}
	
	public boolean isSelected() {
		// Verify that a selection was made
		for (JRadioButton c : baseRadioButtons) {
			if(c.isSelected())
				return true; 
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == baseRadioButtons[0])
			cFrame.manageHexBase();
		else if(e.getSource() == baseRadioButtons[1])
			cFrame.manageDecBase();
		else if(e.getSource() == baseRadioButtons[2])
			cFrame.manageOctBase();
		else if(e.getSource() == baseRadioButtons[3])
			cFrame.manageBinBase();
	}
	
}

