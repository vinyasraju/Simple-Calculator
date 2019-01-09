// Class to compare the operations being processed

import java.util.Comparator;
import java.util.Hashtable;

public class PriorityComparator implements Comparator<OpDictionary> {
	@Override
	public int compare(OpDictionary a, OpDictionary b) {
		Hashtable<String, Integer> table = Operations.initializeSymbols();
		
		if (a.op.equals(b.op))
			return 0;
		else if (table.get(a.op) < table.get(b.op))
			return 1;
		else
			return -1;
	}
}
