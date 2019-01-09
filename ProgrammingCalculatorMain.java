/**
 * 
 */

/**
 * @author Miguel de la Rocha
 * CS 2336.503
 * November 3, 2016
 * Programming Calculator Project
 */

import javax.swing.*; 

public class ProgrammingCalculatorMain {

	public static void main(String[] args) {
		// Calculator Object to be instantiated
		
		CalculatorFrame Calc = new CalculatorFrame(); 
		Calc.setSize(700, 600);
		Calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Calc.setVisible(true);
		Calc.setTitle("Calculator");
	}

}
