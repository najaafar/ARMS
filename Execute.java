
import src.InternalMemory;
import java.util.*;
import java.io.*;

public class Execute implements Runnable{

	public Thread tExecute;
	private String name = "EXECUTE";
	public String[][] instruction;

	public Execute(){
		createThreadInstance();
		this.tExecute.start();

		
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
		this.tExecute = new Thread(this);
	}

	public void run(){
		int result;

		String[] instruction = Main.im.getInstructions()[Main.im.MAR.getValue()];
		//kunin yung name ng operator
		//switch statement ng mga operators
		//sa result ilalagay yung result ng operations
		switch(instruction[0]){
			case "LOAD":
					System.out.println("~~ LOAD ~~");
					if(instruction[2].charAt(0) != 'R'){	//Main.immediate
						result = Integer.parseInt(instruction[2]);
					}else{	//register
						result = Main.im.registers.get(instruction[2]).getValue();
					}
					break;
			case "ADD":
					System.out.println("~~ ADD ~~");
					result = Main.im.registers.get(instruction[1]).getValue() + Main.im.registers.get(instruction[2]).getValue();
					break;
			case "SUB":
					System.out.println("~~ SUB ~~");
					result = Main.im.registers.get(instruction[1]).getValue() - Main.im.registers.get(instruction[2]).getValue();
					break;
			case "CMP":
					System.out.println("~~ CMP ~~");
					break;
			default:
					System.out.println("~~ DEFAULT ~~");
		}

		//tas ipapasa yung result sa writeback siguro
		System.out.println("Execute finished!");
		Main.cycle++;
		System.out.println("Clock cycle at " + Main.cycle);

		Memory memory = new Memory();
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