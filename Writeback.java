
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
		if(reg != null){
			Main.im.registers.get(this.reg.getName()).setValue(result);
		}

		System.out.println("Writeback finished!");
		Main.addProcessesPerClockCycle(getProcessName());
		Main.showProcessesPerClockCycle();
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