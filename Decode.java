
import src.InternalMemory;
import java.util.*;
import java.io.*;

public class Decode implements Runnable{

	public Thread tDecode;
	private String name = "DECODE";
	public String[][] instruction;

	public Decode(){
		createThreadInstance();
		this.tDecode.start();

		this.instruction = Main.im.getInstructions();
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

		

		//hazard detection
		System.out.println("Decode finished!");
		Main.cycle++;
		System.out.println("Clock cycle at " + Main.cycle);

		Execute execute = new Execute();
		execute.run();
	}

	public Thread getThread(){
		return this.tDecode;
	}

	//getter
	public String getProcessName(){
		return this.name;
	}

}