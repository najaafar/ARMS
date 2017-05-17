
import src.InternalMemory;
import src.Register;
import java.util.*;
import java.io.*;

public class Memory implements Runnable{

	public Thread tMemory;
	private String name = "MEMORY";
	public static int result;
	public static Register reg;

	public Memory(int result, Register reg){
		createThreadInstance();
		this.tMemory.start();
		this.result = result;
		this.reg = reg;
	} 

	public void createThreadInstance(){
		this.tMemory = new Thread(this);
	}

	public void run(){
		System.out.println("Memory finished!");
		Main.cycle++;
		System.out.println("Clock cycle at " + Main.cycle);

		Writeback writeback = new Writeback(result, reg);
		writeback.run();
	}

	public Thread getThread(){
		return this.tMemory;
	}

	//getter
	public String getProcessName(){
		return this.name;
	}

}