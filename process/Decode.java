package process;

import src.InternalMemory;
import java.util.*;
import java.io.*;

public class Decode implements Runnable{

	public Thread tDecode;
	private String name = "DECODE";
	public InternalMemory im;

	public Decode(InternalMemory im){
		createThreadInstance();
		this.tDecode.start();
		this.im = im;
	} 

	public void createThreadInstance(){
		this.tDecode = new Thread(this);
	}

	public void run(){
		//parsing ng instruction - nagawa na sa Main
		//hazard detection
		System.out.println("Decode finished!");

		Execute execute = new Execute(im);
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