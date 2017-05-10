
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main implements Runnable{

	public static int noOfInstruction = 0;
	public static ArrayList<String[]> instructions;
	public static ArrayList<Register> registers = new ArrayList<Register>();

	public static void main(String[] args){

		final String FILE_PATH = "src/resources/input.txt";
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
		final String PATTERN = "(LOAD|ADD|SUB|CMP)\\s+(R\\d+),\\s*((R\\d+)|\\d+)\\s*";
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

		String inst[][] = new String[0][0];
		inst = instructions.toArray(new String[0][0]);	//converts instructions to a 2D String array
		
		//print all element in the inst 2Darray
		/*for(int i=0; i < noOfInstruction; i++){
			for(int j=0; j < 3; j++){
				System.out.println(inst[i][j]);
			}
			//System.out.println("\n");
		}*/

		//init registers
		initRegisters();
		showRegisters();

		for(int i=0; i < noOfInstruction; i++){
			Thread t = new Thread(new Main());
			t.start();
		}
		
	}

	public void run(){
		//System.out.println("Program is now running.")
		for(int i=0; i < 5; i++){
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

	public static void initRegisters(){
		Register r, pc, mar, mbr, of, nf, zf;
		for(int i = 0; i < 32; i++){
			r = new Register("R"+i, 0, false);
			registers.add(r);
		}

		//Program Counter (PC)
		pc = new Register("PC", 0, false);
		registers.add(pc);

		//Memory Address Register (MAR)
		mar = new Register("MAR", 0, false);
		registers.add(mar);

		//MBR (Memory Buffer Register)
		mbr = new Register("MBR", 0, false);
		registers.add(mbr);

		//Overflow Flag (OF)
		of = new Register("OF", 0, false);
		registers.add(of);

		//Negative Flag (NF)
		nf = new Register("NF", 0, false);
		registers.add(nf);

		//Zero Flag (ZF).
		zf = new Register("ZF", 0, false);
		registers.add(zf);
	}

	public static void showRegisters(){
		//print all element in the intructions arraylist
		System.out.println("\n");
		for(int i=0; i < registers.size(); i++){
			System.out.println(registers.get(i));
		}
	}
	public void startExecution(String[] line){
		//fetch

		//decode

		//execute

		//memory

		//writeback
	}
}