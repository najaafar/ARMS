package process;

import src.InternalMemory;
import java.util.*;
import java.io.*;

public class Fetch implements Runnable{

	public Thread tFetch;
	private String name = "FETCH";
	public InternalMemory im;

	public Fetch(InternalMemory im){
		createThreadInstance();
		this.tFetch.start();
		this.im = im;
	} 

	public void createThreadInstance(){
		this.tFetch = new Thread(this);
	}

	public void run(){
		//kay pc nakalagay yung index ng current instruction
		//ilagay ang laman ni pc kay MAR
		im.MAR.setValue(im.PC.getValue());
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