
import src.InternalMemory;
import java.util.*;
import java.io.*;

public class Writeback implements Runnable{

	public Thread tWriteback;
	private String name = "WRITEBACK";

	public Writeback(){
		createThreadInstance();
		this.tWriteback.start();
	} 

	public void createThreadInstance(){
		this.tWriteback = new Thread(this);
	}

	public void run(){
		System.out.println("Writeback finished!");
		Main.cycle++;
		System.out.println("Clock cycle at " + Main.cycle);
	}

	public Thread getThread(){
		return this.tWriteback;
	}

	//getter
	public String getProcessName(){
		return this.name;
	}

}