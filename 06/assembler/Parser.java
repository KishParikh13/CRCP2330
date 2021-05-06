import java.io*;
import java.util.HashMap;

public class Parser {

	// to read in lines from files
	String inputLine;
	private BufferedReader reader;

	// create a reader instance
	public Parser(String inputFile) {
		reader = new BufferedReader(new FileReader(inputFile));
	}

	// read a line
	public void readInputFile() {
		inputLine = reader.readinputLine();
	}

	// return the type of command (L, A, C)
	public enum getCommand() {
		if (inputLine.charAt(0) == '(') {
			return L;
		} else if (inputLine.charAt(0) == '@') {
			return A;
		} else {
			return C;
		}
	}
	
}