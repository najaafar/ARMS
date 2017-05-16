
import src.InternalMemory;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main implements Runnable{

	public static int noOfInstruction = 0;
	public static ArrayList<Thread> processes = new ArrayList<Thread>(); 
	public static ArrayList<String[]> instructions;
	public static InternalMemory im;
	public static int cycle = 0;

	public static void main(String[] args){

		//read input data from a file
		final String FILE_PATH = "src/resources/TestCase001.txt";
		/* load input data */
		ArrayList<String> inputData = new ArrayList<String>();
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
		Fetch fetch = new Fetch();
		//Decode decode = new Decode();
		//Execute execute = new Execute();
		//Memory memory = new Memory();
		//Writeback writeback = new Writeback();

		showProcessesPerClockCycle();

	}

	public void run(){
		//System.out.println("Program is now running.")
		for(int i=0; i < noOfInstruction; i++){
			//System.out.println("Thread : " + i);
			try{
				startExecution(instructions.get(i));
				Thread.sleep(50);
			}catch(InterruptedException ie){
				System.out.println("Operation interrupted! " + ie);
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