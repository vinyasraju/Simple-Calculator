// Class for the ToolBar of the Calculator
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class CalcMenuBar extends JMenuBar implements ActionListener {
	// Declare necessary variables
	CalculatorFrame frame; 
	JMenu viewMenu, editMenu, helpMenu; 
	JMenuItem showMenuItem, hideMenuItem, copyMenuItem, viewHelpItem, aboutMenuItem; 
	public CalcMenuBar(CalculatorFrame frame) {
		// Menu Bar options to be added
		this.frame = frame;
		// View Menu
		viewMenu = new JMenu("View");
		viewMenu.setMnemonic(KeyEvent.VK_F);
		this.add(viewMenu);
		// View Menu Items
		hideMenuItem = new JMenuItem("Hide", KeyEvent.VK_N);
		viewMenu.add(hideMenuItem);
		hideMenuItem.addActionListener(this);
		showMenuItem = new JMenuItem("Show", KeyEvent.VK_N);
		viewMenu.add(showMenuItem);
		showMenuItem.addActionListener(this);
		
		// Edit Menu
		editMenu = new JMenu("Edit"); 
		editMenu.setMnemonic(KeyEvent.VK_F);
		this.add(editMenu);
		// Edit Menu Items
		copyMenuItem = new JMenuItem("Copy", KeyEvent.VK_N);
		editMenu.add(copyMenuItem);
		copyMenuItem.addActionListener(this);
		
		// Help Menu
		helpMenu = new JMenu("Help");
		editMenu.setMnemonic(KeyEvent.VK_F);
		this.add(helpMenu);
		// Help Menu items
		viewHelpItem = new JMenuItem("View Help", KeyEvent.VK_N);
		helpMenu.add(viewHelpItem);
		viewHelpItem.addActionListener(this);
		aboutMenuItem = new JMenuItem("About", KeyEvent.VK_N);
		helpMenu.add(aboutMenuItem);
		aboutMenuItem.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// Do actions according to the menu item pressed 
		if(e.getSource() == hideMenuItem)
			frame.hideCalculator();
		else if(e.getSource() == showMenuItem)
			frame.showCalculator();
		else if(e.getSource() == copyMenuItem)
			frame.copyResult();
		else if(e.getSource() == viewHelpItem)
			frame.viewHelp(); 
		else if(e.getSource() == aboutMenuItem)
			frame.aboutItem();			
	}
	

}
