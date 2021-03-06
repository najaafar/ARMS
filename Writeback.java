/*
	Writeback.java
	- a class that executes the Writeback stage by storing the result of the Execute stage to
	the destination register.
	- consumes one clock cycle
*/
import src.InternalMemory;
import src.Register;
import java.util.*;
import java.io.*;

public class Writeback/* implements Runnable*/{

	//public Thread tWriteback;
	private String name = "WRITEBACK";
	public static int result;
	public static Register reg;

	public Writeback(int result, Register reg){
		/*createThreadInstance();
		this.tWriteback.start();*/
		//officially write the value of the result to the register
		this.reg = reg;

		if(reg != null){
			Main.im.registers.get(this.reg.getName()).setValue(result);
		}

		System.out.println("Writeback finished!");
		Main.addProcessesPerClockCycle(getProcessName());
		Main.showProcessesPerClockCycle();
		Main.im.viewRegisters();
		Main.clearProcessesPerClockCycle();
		Main.cycle++;
		System.out.println("Clock cycle at " + Main.cycle);
	} 

	/*public void createThreadInstance(){
		this.tWriteback = new Thread(this);
	}

	public void run(){
		
	}

	public Thread getThread(){
		return this.tWriteback;
	}*/

	//getter
	public String getProcessName(){
		return this.name;
	}

}