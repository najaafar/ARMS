package process;

import java.util.*;
import java.io.*;

public class Memory implements Runnable{

	public Thread tMemory;
	private String name = "MEMORY";

	public Memory(){
		createThreadInstance();
		this.tMemory.start();
	} 

	public void createThreadInstance(){
		this.tMemory = new Thread(this);
	}

	public void run(){
		System.out.println("Memory finished!");
	}

	public Thread getThread(){
		return this.tMemory;
	}

	//getter
	public String getProcessName(){
		return this.name;
	}

}