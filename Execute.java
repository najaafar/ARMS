
import src.InternalMemory;
import src.Register;
import java.util.*;
import java.io.*;

public class Execute/* implements Runnable*/{

	//public Thread tExecute;
	private String name = "EXECUTE";
	public String[][] instruction;
	public static String operator;
	public static String op1, op2;
	public static int result;
	public static Register reg;

	public Execute(String operator, String op1, String op2){
		/*createThreadInstance();
		this.tExecute.start();*/
		this.operator = operator;
		this.op1 = op1;
		this.op2 = op2;

		
		this.instruction = Main.im.getInstructions();

		//print all element in the inst 2Darray
		/*for(int i=0; i < Main.im.getNoOfInstructions(); i++){
			for(int j=0; j < 3; j++){
				System.out.println(instruction[i][j]);
			}
			System.out.println("\n");
		}*/



		//String[] instruction = Main.im.getInstructions()[Main.im.MAR.getValue()];
		//kunin yung name ng operator
		//switch statement ng mga operators
		//sa result ilalagay yung result ng operations
		switch(this.operator){
			case "LOAD":
					System.out.println("~~ LOAD ~~");
					if(this.op2.charAt(0) != 'R'){	//Main.immediate
						result = Integer.parseInt(this.op2);
						reg = Main.im.registers.get(this.op1);
						Main.im.registers.get(this.op1).setValue(result);
						System.out.println("register = " + reg.getName() + ", result = " + Main.im.registers.get(this.op1).getValue());
					}else{	//register
						result = Main.im.registers.get(this.op1).getValue();
						reg = Main.im.registers.get(this.op1);
						System.out.println("register = " + reg.getName() + "result = " + result);
					}

					//Sets OF to 1 if the value loaded is more than 2 digits, 0 otherwise.
					if(result<-99 || result>99)
						Main.im.registers.get("OF").setValue(1);
					else Main.im.registers.get("OF").setValue(0);

					break;
			case "ADD":
					System.out.println("~~ ADD ~~");
					result = Main.im.registers.get(this.op1).getValue() + Main.im.registers.get(this.op2).getValue();
					reg = Main.im.registers.get(this.op1);
					System.out.println("register = " + reg.getName() + "result = " + result);

					//Sets OF to 1 if the value loaded is more than 2 digits, 0 otherwise.
					if(result<-99 || result>99)
						Main.im.registers.get("OF").setValue(1);
					else Main.im.registers.get("OF").setValue(0);
					//write the result in the first register
					break;
			case "SUB":
					System.out.println("~~ SUB ~~");
					result = Main.im.registers.get(this.op1).getValue() - Main.im.registers.get(this.op2).getValue();
					reg = Main.im.registers.get(this.op1);
					System.out.println("register = " + reg.getName() + "result = " + result);

					//Sets OF to 1 if the value loaded is more than 2 digits, 0 otherwise.
					if(result<-99 || result>99)
						Main.im.registers.get("OF").setValue(1);
					else Main.im.registers.get("OF").setValue(0);
					//write the result in the first register
					break;
			case "CMP":
					System.out.println("~~ CMP ~~");
					result = Main.im.registers.get(this.op1).getValue() - Main.im.registers.get(this.op2).getValue();
					//reg = null;
					//If the resultis zero (0),the ZF is set to 1, 0 otherwise (default).
					if(result == 0)
						Main.im.registers.get("ZF").setValue(1);
					else Main.im.registers.get("ZF").setValue(0);

					//Ifthe resultis negative,the NF is set to 1, 0 otherwise (default).
					if(result < 0)
						Main.im.registers.get("NF").setValue(1);
					else Main.im.registers.get("NF").setValue(0);


					break;
			default:
					System.out.println("~~ DEFAULT ~~");
		}

		//tas ipapasa yung result sa writeback siguro
		System.out.println("Execute finished!");
		Main.addProcessesPerClockCycle(getProcessName());
		Main.showProcessesPerClockCycle();
		Main.im.viewRegisters();
		Main.clearProcessesPerClockCycle();
		Main.cycle++;
		System.out.println("Clock cycle at " + Main.cycle);

		//Memory memory = new Memory(result, reg);
		//memory.run();
	} 

	/*public void createThreadInstance(){
		this.tExecute = new Thread(this);
	}

	public void run(){
	}

	public Thread getThread(){
		return this.tExecute;
	}*/

	//getter
	public String getProcessName(){
		return this.name;
	}

}