package process;

import src.InternalMemory;
import java.util.*;
import java.io.*;

public class Execute implements Runnable{

	public Thread tExecute;
	private String name = "EXECUTE";

	public Execute(InternalMemory im){
		createThreadInstance();
		this.tExecute.start();
	} 

	public void createThreadInstance(){
		this.tExecute = new Thread(this);
	}

	public void run(){
		System.out.println("Execute finished!");
	}

	public Thread getThread(){
		return this.tExecute;
	}

	//getter
	public String getProcessName(){
		return this.name;
	}

}