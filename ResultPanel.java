// Class for the Result Panel

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ResultPanel extends JPanel {
	// Declare the variables for the Result Panel
	
		private JTextField resultField; 
		
		// Declare the constructor for the Panel
		
		public ResultPanel() {
			// Create the result panel of the calculator by integrating the TextField
			resultField = new JTextField();
			resultField.setPreferredSize(new Dimension(650, 75));
			resultField.setEnabled(true);
			resultField.setEditable(false);
			// Add the element to the panel
			add(resultField);
			resultField.setText("0");
			// Edit the text field
			Font f = new Font("Segoe UI", Font.PLAIN, 26);
			resultField.setFont(f);
			resultField.setHorizontalAlignment(JTextField.RIGHT);
			resultField.setForeground(Color.BLACK);
		}
		
		public void setText(String s) {
			// If the user types bigger numbers
			if(resultField.getText().equals("0") || resultField.getText().equals("0.0"))
			{
				resultField.setText("");
			}
			String r = resultField.getText().concat(s);
			resultField.setText(r);
		}
		
		public void clearText() {
			// Clear the text field
			resultField.setText("0");
		}
		
		public void backSpace() {
			// Set a substring of the output being shown
			resultField.setText(resultField.getText().substring(0, resultField.getText().length()-1));
			if(resultField.getText().equals(""))
				resultField.setText("0");
		}
		
		public String getText() {
			// Return the text of the field
			return resultField.getText(); 
		}
		
		public void signChange() {
			// To change the displaying number
			if(resultField.getText().startsWith("-"))
			{
				resultField.setText(resultField.getText().substring(1, resultField.getText().length()));
			}
			else
			{
				String r = "-" + resultField.getText();
				resultField.setText(r);
			}
			
		}
}
