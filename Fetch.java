/*
	Fetch.java
	- a class that executes the Fetch stage by storing the value of the register PC to the
	register MAR, then incrementing the PC.
	- consumes one clock cycle
*/
import src.InternalMemory;
import java.util.*;
import java.io.*;

public class Fetch/* implements Runnable*/{

	//public Thread tFetch;
	private String name = "FETCH";
	public String[][] instruction;

	public Fetch(){
		/*createThreadInstance();
		this.tFetch.start();*/

		
		this.instruction = Main.im.getInstructions();
		//print all element in the inst 2Darray
		/*for(int i=0; i < Main.im.getNoOfInstructions(); i++){
			for(int j=0; j < 3; j++){
				System.out.println(instruction[i][j]);
			}
			System.out.println("\n");
		}*/

		System.out.println("Main Memory = " + Main.im);


		//kay pc nakalagay yung index ng current instruction
		//ilagay ang laman ni pc kay MAR
		Main.im.MAR.setValue(Main.im.PC.getValue());

		//ilagay ang value ng address na laman ni MAR kay MBR
		//String tempMBR;
		//tempMBR = this.instruction[Main.im.MAR.getValue()][0] + " " + this.instruction[Main.im.MAR.getValue()][1] + " " + this.instruction[Main.im.MAR.getValue()][2];
		Main.im.MBR.setValueMBR(Main.inputData.get(Main.im.MAR.getValue()));
		System.out.println("MBR = " + Main.im.MBR.getValueMBR());
		
		//i-increment si PC
		Main.im.incrementPC();

		System.out.println("Fetch finished!");
		Main.addProcessesPerClockCycle(getProcessName());
		Main.showProcessesPerClockCycle();
		Main.im.viewRegisters();
		Main.clearProcessesPerClockCycle();
		Main.cycle++;
		System.out.println("Clock cycle at " + Main.cycle);
		//Gawa ka ng Decode tas ipasa mo yung mga registers
		
		//Decode decode = new Decode(Main.im.MBR.getValueMBR());
		//decode.run();
	} 

	/*public void createThreadInstance(){
		this.tFetch = new Thread(this);
	}

	public void run(){

	}

	public Thread getThread(){
		return this.tFetch;
	}*/

	public void doProcess(){

	}

	//getter
	public String getProcessName(){
		return this.name;
	}

}