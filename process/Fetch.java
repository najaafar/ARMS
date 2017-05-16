package process;

import src.InternalMemory;
import java.util.*;
import java.io.*;

public class Fetch implements Runnable{

	public Thread tFetch;
	private String name = "FETCH";
	public InternalMemory im;
	public String[][] instruction;

	public Fetch(InternalMemory im){
		createThreadInstance();
		this.tFetch.start();
		this.im = im;
		this.instruction = im.getInstructions();
	} 

	public void createThreadInstance(){
		this.tFetch = new Thread(this);
	}

	public void run(){
		//kay pc nakalagay yung index ng current instruction
		//ilagay ang laman ni pc kay MAR
		im.MAR.setValue(im.PC.getValue());

		//ilagay ang value ng address na laman ni MAR kay MBR
		String tempMBR;
		tempMBR = this.instruction[im.MAR.getValue()][0] + " " + this.instruction[im.MAR.getValue()][1] + " " + this.instruction[im.MAR.getValue()][2];
		im.MBR.setValueMBR(tempMBR);
		//System.out.println("MBR = " + im.MBR.getValueMBR());
		
		//i-increment si PC
		im.incrementPC();

		System.out.println("Fetch finished!");
		//Gawa ka ng Decode tas ipasa mo yung mga registers
		
		Decode decode = new Decode(im);
		decode.run();
	}

	public Thread getThread(){
		return this.tFetch;
	}

	public void doProcess(){

	}

	//getter
	public String getProcessName(){
		return this.name;
	}

}