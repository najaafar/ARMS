package process;

import src.InternalMemory;
import java.util.*;
import java.io.*;

public class Fetch implements Runnable{

	public Thread tFetch;
	private String name = "FETCH";

	public Fetch(InternalMemory im){
		createThreadInstance();
		this.tFetch.start();
	} 

	public void createThreadInstance(){
		this.tFetch = new Thread(this);
	}

	public void run(){
		System.out.println("Fetch finished!");
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