package process;

import src.InternalMemory;
import java.util.*;
import java.io.*;

public class Execute implements Runnable{

	public Thread tExecute;
	private String name = "EXECUTE";
	public InternalMemory im;

	public Execute(InternalMemory im){
		createThreadInstance();
		this.tExecute.start();
		this.im = im;
	} 

	public void createThreadInstance(){
		this.tExecute = new Thread(this);
	}

	public void run(){
		int result;

		String[] instruction = im.instruction[im.MAR.getValue()];
		//kunin yung name ng operator
		//switch statement ng mga operators
		//sa result ilalagay yung result ng operations
		switch(instruction[0]){
			case "LOAD":
					System.out.println("~~ LOAD ~~");
					if(instruction[2].charAt(0) != 'R'){	//immediate
						result = Integer.parseInt(instruction[2]);
					}else{	//register
						result = im.registers.get(instruction[2]).getValue();
					}
					break;
			case "ADD":
					System.out.println("~~ ADD ~~");
					result = im.registers.get(instruction[1]).getValue() + im.registers.get(instruction[2]).getValue();
					break;
			case "SUB":
					System.out.println("~~ SUB ~~");
					result = im.registers.get(instruction[1]).getValue() - im.registers.get(instruction[2]).getValue();
					break;
			case "CMP":
					System.out.println("~~ CMP ~~");
					break;
			default:
					System.out.println("~~ DEFAULT ~~");
		}

		//tas ipapasa yung result sa writeback siguro
		System.out.println("Execute finished!");

		Memory memory = new Memory(im);
		memory.run();
	}

	public Thread getThread(){
		return this.tExecute;
	}

	//getter
	public String getProcessName(){
		return this.name;
	}

}