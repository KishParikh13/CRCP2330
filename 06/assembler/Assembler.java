import java.io*;
import java.util.HashMap;

public class Assembler {
	
	public static String file;
	public static int counter = 0;
	public static int n = 16;
	
	public static void main(String[] inputFile) {

		//manage file input
		String inputFileName = inputFile[0].substring(0,inputFile[0].indexOf('.'));
		String outputFileName = inputFileName + ".hack";
		Parser aParse = new Parser(inputFile[0]);
		Parser bParse = new Parser(inputFile[0]);
		File out = new File(outputFileName);
		out.createNewFile();
		FileWriter fw = new FileWriter(out);

		//map the predefined symbols
		HashMap<String,String> index = new HashMap<String,String>();
		index.put( "R0", "0" ); index.put( "R1", "1" ); index.put( "R2", "2" );
		index.put( "R3", "3" ); index.put( "R4", "4" ); index.put( "R5", "5" ); 
		index.put( "R6", "6" ); index.put( "R7", "7" ); index.put( "R8", "8" ); 
		index.put( "R9", "9" ); index.put( "R10", "10" ); index.put( "R11", "11" );
		index.put( "R12", "12" ); index.put( "R13", "13" ); index.put( "R14", "14" ); index.put( "R15", "15" );
        index.put( "SCREEN", "16384" ); index.put( "KBD", "24576" ); 
		index.put( "SP", "0" ); index.put( "LCL", "1" ); index.put( "ARG", "2" ); 
		index.put( "THIS", "3" ); index.put( "THAT", "4" );
		
		// map the labels
		index.put("LOOP", "4"); index.put("STOP", "18"); index.put("END", "22");
		
		//Index of Variable Symbols
			//if seen for the first time, assign a unique memory address starting at 16

		// read file
		aParse.readInputFile();

		// if L command (new symbol), assign to new address in memory
		if(aParse.getCommand.equals("L"))
			
			HashMap<String,String> cInstructions = new HashMap<String,String>();
			HashMap<String,String> dInstructions = new HashMap<String,String>();
			HashMap<String,String> jInstructions = new HashMap<String,String>();
	
			// translate to binary
			cInstructions.put( "0", "0101010" ); cInstructions.put( "1", "0111111" ); cInstructions.put( "-1", "0111010" ); 
			cInstructions.put( "D", "0001100" ); cInstructions.put( "A", "0110000" ); cInstructions.put( "M", "1110000" ); 
			cInstructions.put( "!D", "0001101" ); cInstructions.put( "!A", "0110001" ); cInstructions.put( "!M", "1110001" );
			cInstructions.put( "-D", "0001111" ); cInstructions.put( "-A", "0110011" ); cInstructions.put( "-M", "1110011" ); 
			cInstructions.put( "D+1", "0011111" ); cInstructions.put( "A+1", "0110111" ); cInstructions.put( "M+1", "1110111" );
			cInstructions.put( "D-1", "0001110" ); cInstructions.put( "A-1", "0110010" ); cInstructions.put( "M-1", "1110010" );
			cInstructions.put( "D+A", "0000010" ); cInstructions.put( "D+M", "1000010" ); cInstructions.put( "D-A", "0010011" );
			cInstructions.put( "D-M", "1010011" ); cInstructions.put( "A-D", "0000111" ); cInstructions.put( "M-D", "1000111" );
			cInstructions.put( "D&A", "0000000" ); cInstructions.put( "D&M", "1000000" ); cInstructions.put( "D|A", "0010101" ); cInstructions.put( "D|M", "1010101" );

			dInstructions.put( "", "000" ); dInstructions.put( "M", "001" ); dInstructions.put( "D", "010" );
			dInstructions.put( "MD", "011" ); dInstructions.put( "A", "100" ); dInstructions.put( "AM", "101" );
			dInstructions.put( "AD", "110" ); dInstructions.put( "AMD", "111" );

			jInstructions.put( "", "000" ); jInstructions.put( "JGT", "001" ); jInstructions.put( "JEQ", "010" );
			jInstructions.put( "JGE", "011" ); jInstructions.put( "JLT", "100" ); jInstructions.put( "JNE", "101" );
			jInstructions.put( "JLE", "110" ); jInstructions.put( "JMP", "111" );
	
}

// functions to return index locations of values 

public String dest(String d){
	return dInstructions.get(d);
}

public String comp(String c){
	return cInstructions.get(c);
}

public String jump(String j){
	return jInstructions.get(j);
}