// Class for the length of the word, per instructions, only QWord is selected

import javax.swing.*;
import java.awt.*;

public class WordLengthPanel extends JPanel{
	// Declare necessary variables for the panel
	
	private JRadioButton wordRadioButtons[];
	private String [] words = {"QWord", "DWord", "Word", "Byte"};
	private ButtonGroup btnGroup; 
	
	public WordLengthPanel() {
		// Make the panel for the word Length
		
		setLayout(new GridLayout(4,1));
		btnGroup = new ButtonGroup();
		wordRadioButtons = new JRadioButton[words.length];
		setBorder(BorderFactory.createLineBorder(Color.black));
		for (int i = 0; i < words.length; i++) {
				wordRadioButtons[i] = new JRadioButton(words[i]);
				btnGroup.add(wordRadioButtons[i]); 
				add(wordRadioButtons[i]);
		}
		// Set the default radio button
		// Disable the other buttons 
		wordRadioButtons[0].setSelected(true);
		wordRadioButtons[1].setEnabled(false);
		wordRadioButtons[2].setEnabled(false);
		wordRadioButtons[3].setEnabled(false);
		
	}
}
