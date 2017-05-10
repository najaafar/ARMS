package process;

import java.util.*;
import java.io.*;

public class Decode implements Runnable{

	public Thread tDecode;
	private String name = "DECODE";

	public Decode(){
		createThreadInstance();
		this.tDecode.start();
	} 

	public void createThreadInstance(){
		this.tDecode = new Thread(this);
	}

	public void run(){
		System.out.println("Decode finished!");
	}

	public Thread getThread(){
		return this.tDecode;
	}

	//getter
	public String getProcessName(){
		return this.name;
	}

}