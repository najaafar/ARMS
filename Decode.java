
import src.InternalMemory;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decode implements Runnable{

	public Thread tDecode;
	private String name = "DECODE";
	//public String[][] instruction;
	public static String line; 
	public static String[] decodedInst = new String[3]; 
	public static String operator;
	public static String op1, op2;

	public Decode(String line){
		createThreadInstance();
		this.tDecode.start();
		this.line = line;

		//this.instruction = Main.im.getInstructions();
		//print all element in the inst 2Darray
		/*for(int i=0; i < Main.im.getNoOfInstructions(); i++){
			for(int j=0; j < 3; j++){
				System.out.println(instruction[i][j]);
			}
			System.out.println("\n");
		}*/

	} 

	public void createThreadInstance(){
		this.tDecode = new Thread(this);
	}

	public void run(){
		//parsing ng instruction - nagawa na sa Main
		parseInstruction();

		//hazard detection!!!
		System.out.println("Decode finished!");
		Main.cycle++;
		System.out.println("Clock cycle at " + Main.cycle);

		Execute execute = new Execute(operator, op1, op2);
		execute.run();
	}

	public Thread getThread(){
		return this.tDecode;
	}

	//getter
	public String getProcessName(){
		return this.line;

	}

	public void parseInstruction(){
		final String PATTERN = "(LOAD|ADD|SUB|CMP)\\s+(R\\d+),*\\s*((R\\d+)|\\d+)\\s*";
		Pattern p = Pattern.compile(PATTERN);
		Matcher m = p.matcher(line);
		if(m.find()) {
			decodedInst[0] = m.group(1);
			decodedInst[1] = m.group(2);
			decodedInst[2] = m.group(3);

			//System.out.println("Decoded instruction: " + decodedInst[0] + "," + decodedInst[1] + "," + decodedInst[2]);
		}

		operator = decodedInst[0];
		op1 = decodedInst[1];
		op2 = decodedInst[2];
	}



}