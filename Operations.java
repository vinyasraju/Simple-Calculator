import java.util.*;

// Class to handle calculator operations between inputs

public class Operations {
	// Define necessary variables to hold data
	
	private ArrayList<Double> nums; 
	private PriorityQueue<OpDictionary> ops;
	private int operationIndex;
	public String numBuffer = "0";
	public static Hashtable<String, Integer> symbols;
	private boolean sign;
	
	public Operations() {
		// Instantiate the arrayList to hold the nums and priority queue for the dictionary
		nums = new ArrayList<Double>();
		ops = new PriorityQueue<OpDictionary>(new PriorityComparator());
		numBuffer = "0";
		operationIndex = 0;
		sign = false;
	}
	
	public static Hashtable<String, Integer> initializeSymbols() {
		// Create a dictionary with the signs for order of operations
		symbols = new Hashtable<String, Integer>();

		symbols.put("+", 0);
		symbols.put("-", 0);
		symbols.put("*", 1);
		symbols.put("/", 1);
		symbols.put("Mod", 1);

		return symbols;
	}
	
	public void numClick(String n) {
		// Handle when the user presses a num button
		numBuffer += n;
	}
	
	public void signClick() {
		// Handle when the user changes a number's sign
		String s; 
		if(sign) {
			sign = false;
			numBuffer = numBuffer.substring(1, numBuffer.length());
		}
		else {
			sign = true;
			s = "-" + numBuffer;
			numBuffer = s;
		}
		
	}
	
	public void clearE() {
		// Delete the previous numerical entry of the user
		numBuffer = "0";
	}
	
	public void backSpace() {
		// Delete the latest inputted digit 
		numBuffer = numBuffer.substring(0, numBuffer.length() - 1);
		if(numBuffer.equals(""))
			numBuffer = "0";
	}
	
	public void hexClick(String n) {
		// Translate the string given appropriately
		Long i = Long.valueOf(numBuffer, 10);
		numBuffer = Long.toHexString(i) + n;
		i = Long.valueOf(numBuffer, 16);
		numBuffer = Long.toString(i);
	}
	
	public void opClick(String s) {
		// Process the click of an operation
		if(numBuffer.startsWith("--"))
			numBuffer = numBuffer.substring(2, numBuffer.length());
		nums.add(Double.parseDouble(numBuffer));
		sign = false;
		numBuffer = "";
		ops.add(new OpDictionary(s, operationIndex));
		operationIndex++;
	}
	
	public Double execute() {
		// Function to process the numbers when the equal sign is pressed
		if(numBuffer.startsWith("--"))
			numBuffer = numBuffer.substring(2, numBuffer.length());
		nums.add(Double.parseDouble(numBuffer));
		numBuffer = "";
		sign = false;

		while(true) {
			if (nums.size() == 1) {
				break;
			}
			// Order of operations implementation with dictionaries and dynamic indices
			OpDictionary op = ops.poll();
			
			int index = op.index;
			double a = nums.get(index);
			double b = nums.get(index + 1);
			
			double result = this.executeOperation(a, b, op.op);
			
			nums.remove(index);
			nums.remove(index);
			
			nums.add(index, result);
			this.updateIndices(index);
		}
		
		Double result = nums.get(0);
		numBuffer = result.toString();
		// Reset values for next operation
		nums.clear();
		ops.clear();
		operationIndex = 0;
		sign = false;
		return result;
	}
	
	public void updateIndices(int index) {
		// Function to update indices
		for (OpDictionary i : ops) {
			if (i.index > index) {
				i.index--;
			}
		}
	}

	public double executeOperation(double a, double b, String op) {
		// Execute the operations of the calculator
		if(op.equals("+"))
			return a + b;
		else if(op.equals("-"))
			return a - b; 
		else if(op.equals("*"))
			return a * b; 
		else if(op.equals("/"))
		{
			// Check for divide by 0 error
			if(b == 0)
				return Integer.MIN_VALUE;
			
			return a / b;
		}
		else if(op.equals("Mod"))
			return a % b;
		else
			return a;
	}
}
