/*
	Main.java
	- main class for the backend of the project. The input file is read then parsed and added
	to the instructions ArrayList. The internal memory (registers), clock, and threads are 
	initialized before starting the threads.
*/
import src.InternalMemory;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main implements Runnable{

	public static int noOfInstruction = 0;
	public static ArrayList<String> processes = new ArrayList<String>(); 
	public static HashMap<String, ArrayList> registers = new HashMap<String, ArrayList>();
	public static ArrayList<String> inputData;
	public static ArrayList<String[]> instructions;
	public static InternalMemory im;
	public static int cycle = 0;

	public static void main(String[] args){

		//read input data from a file
		final String FILE_PATH = "src/resources/TestCase001.txt";
		/* load input data */
		inputData = new ArrayList<String>();
		try {
			FileReader file = new FileReader(FILE_PATH);
			BufferedReader text = new BufferedReader(file);
			String line;
			while ((line = text.readLine()) != null) {
				inputData.add(line);
				noOfInstruction++;
				//System.out.println(line);
			}
			text.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* convert input data to instructions using REGEX */
		final String PATTERN = "(LOAD|ADD|SUB|CMP)\\s+(R\\d+),*\\s*((R\\d+)|\\d+)\\s*";
		instructions = new ArrayList<String[]>();
		for(int i = 0; i < inputData.size(); i++) {
			String line[] = new String[3];

			Pattern p = Pattern.compile(PATTERN);
			Matcher m = p.matcher(inputData.get(i));
			if(m.find()) {
				line[0] = m.group(1);
				line[1] = m.group(2);
				line[2] = m.group(3);

				//System.out.println(line[0] + "," + line[1] + "," + line[2]);
			}
			instructions.add(line);

		}

		//print all element in the intructions arraylist
		/*for(int i=0; i < noOfInstruction; i++){
			System.out.println(Arrays.toString(instructions.get(i)));
		}*/

		//to access elements in instructions
		//System.out.println(instructions.get(2)[0]);

		String inst[][] = new String[0][0];
		inst = instructions.toArray(new String[0][0]);	//converts instructions to a 2D String array
		
		//print all element in the inst 2Darray
		/*for(int i=0; i < noOfInstruction; i++){
			for(int j=0; j < 3; j++){
				System.out.println(inst[i][j]);
			}
			System.out.println("\n");
		}*/

		//initialize internal memory to set up registers
		im = new InternalMemory(inst);
		
		//start mo dito yung isa muna

		//processes starts here ===========================================================================

		/*for(int i=0; i < noOfInstruction; i++){
			Thread t = new Thread(new Main());
			t.start();
		}*/

		//initialize clock thread
		Thread clock  =  new Thread(new Main());
		clock.start();
		System.out.println("Clock running...");

		//initialize threads for fetch, decode, execute, memory, writeback

		for(int i=0; i < noOfInstruction; i++){
			Thread t = new Thread();
			t.start();
		}

		// for(int i=0; i < noOfInstruction; i++){
		//Fetch fetch = new Fetch();
		// }

		// for(int i=0; i < noOfInstruction; i++){
		//Fetch fetch = new Fetch();
		// }

		
		//Decode decode = new Decode();
		//Execute execute = new Execute();
		//Memory memory = new Memory();
		//Writeback writeback = new Writeback();


	}

	public void run(){
		//System.out.println("Program is now running.")
		for(int i=0; i < noOfInstruction; i++){
			//System.out.println("Thread : " + i);
			try{
				//startExecution(instructions.get(i));
				//Thread.sleep(50);
				Fetch fetch = new Fetch();
				Decode decode = new Decode(Main.im.MBR.getValueMBR());
				Execute execute = new Execute(Decode.operator, Decode.op1, Decode.op2);
				Memory memory = new Memory(Execute.result, Execute.reg);
				Writeback writeback = new Writeback(Memory.result, Memory.reg);
			}catch(NullPointerException npe){
				System.out.println("Operation interrupted! " + npe);
			}
		}

		System.out.println("Operation finished!");
	}


	public static void showProcessesPerClockCycle(){
		//print all element in the intructions arraylist
		System.out.println("\n");
		for(int i=0; i < processes.size(); i++){
			System.out.println(processes.get(i));
		}
	}

	public static void addProcessesPerClockCycle(String process){
		processes.add(process);
	}

	public static void clearProcessesPerClockCycle(){
		processes.clear();
	}

	public void startExecution(String[] line){
		//fetch

		//decode

		//execute

		//memory

		//writeback


		/*processes.add(fetch.getThread());
		processes.add(decode.getThread());
		processes.add(execute.getThread());
		processes.add(memory.getThread());
		processes.add(writeback.getThread());*/
	}
}