// Class for the Text Area holding the Binary Lines

import java.awt.Font;

import javax.swing.*; 

public class BinaryTextArea extends JTextArea {
	// Declare necessary variables
	private ResultPanel rPanel;
	private String bits32 = "0000 0000 0000 0000 0000 0000 0000 0000";
	
	
	public BinaryTextArea(ResultPanel panel) {
		// Have the frame in the area
		rPanel = panel; 
		// Set the rows and colums of the Text Area
		setColumns(32);
		setRows(2); 
		this.insert("\t" + bits32 + "\n\t" + bits32, 0);
		this.setFont(new Font("Serif", Font.PLAIN, 20));
	}
	
	public void setText() {
		// Modify the text in the text field
		this.setText(null);
		double p = Double.parseDouble(rPanel.getText());
		Long t = Math.round(p);
		String r = Long.toBinaryString(t);
		String binary = bits32 + "\n" + bits32;
		// Modify the string to then make a strinbuilder to edit
		binary = binary.replaceAll("\\s+", "");
		binary = binary.substring(0, binary.length() - r.length());
		binary = binary.concat(r);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < binary.length(); i++)
		{
			if(i % 4 == 0 && i != 0)
				sb.append(" ");
			if(i == 32)
				sb.append("\n\t");
			sb.append(binary.charAt(i));
		}
		r = sb.toString();
		this.insert("\t" + r, 0);
		this.setFont(new Font("Serif", Font.PLAIN, 20));
	}
	
	public void setTextHex() {
		this.setText(null);
		String s = rPanel.getText();
		Long t = Long.valueOf(s, 16);
		String r = Long.toBinaryString(t);
		String binary = bits32 + "\n" + bits32;
		// Modify the string to then make a strinbuilder to edit
		binary = binary.replaceAll("\\s+", "");
		binary = binary.substring(0, binary.length() - r.length());
		binary = binary.concat(r);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < binary.length(); i++)
		{
			if(i % 4 == 0 && i != 0)
				sb.append(" ");
			if(i == 32)
				sb.append("\n\t");
			sb.append(binary.charAt(i));
		}
		r = sb.toString();
		this.insert("\t" + r, 0);
		this.setFont(new Font("Serif", Font.PLAIN, 20));
	}
	
	public void clearText() {
		this.setText(null);
		this.insert("\t" + bits32 + "\n\t" + bits32, 0);
		this.setFont(new Font("Serif", Font.PLAIN, 20));
	}

}
