package src;


import java.util.*;
import java.io.*;


public class InternalMemory{

	// public static ArrayList<Register> registers = new ArrayList<Register>();
	public static HashMap<String, Register> registers = new HashMap<String, Register>();
	public static Register r, PC, MAR, MBR, OF, NF, ZF;
	private int noOfInstruction;
	public static int pc = 0;
	public String[][] instruction;


	public InternalMemory(String[][] instruction){

		initRegisters();				//to initialize the registers
		viewRegisters();				//to view or show the registers

		//get the total number of instructions to be executed
		noOfInstruction = instruction.length;
		this.instruction = instruction;
		System.out.println(instruction[0][0]);
		System.out.println(instruction[0][1]);
		System.out.println(instruction[0][2]);

		//print all element in the inst 2Darray
		/*for(int i=0; i < noOfInstruction; i++){
			for(int j=0; j < 3; j++){
				System.out.println(instruction[i][j]);
			}
			System.out.println("\n");
		}*/

		//assign values to the registers
		PC.setValue(pc);
	} 

	public static void initRegisters(){

		for(int i = 0; i < 32; i++){
			r = new Register("R"+i);
			registers.put(r.getName(),r);
		}

		//Program Counter (PC) - holds the address of the next instruction 
		PC = new Register("PC");
		PC.setValue(0);
		registers.put(PC.getName(),PC);

		//Memory Address Register (MAR) - holds the address of the current instruction
		MAR = new Register("MAR");
		registers.put(MAR.getName(),MAR);

		//MBR (Memory Buffer Register) - hold the data of the current instruction
		MBR = new Register("MBR");
		registers.put(MBR.getName(),MBR);

		//Overflow Flag (OF) - 1 if value exceed -99 or 99, 0 if otherwise
		OF = new Register("OF");
		registers.put(OF.getName(),OF);

		//Negative Flag (NF) - 1 if negative, 0 if positive
		NF = new Register("NF");
		registers.put(NF.getName(),NF);

		//Zero Flag (ZF) - 1 if zero result, 0 if non-zero result
		ZF = new Register("ZF");
		registers.put(ZF.getName(),ZF);
	}

	public static void viewRegisters(){
		//print all element in the intructions arraylist
		System.out.println("\n");
		// for(int i=0; i < registers.size(); i++){
		// 	System.out.println(registers.get(i));
		// }
		for(String key: registers.keySet()){
			System.out.println(registers.get(key).toString());
		}
	}

	public void incrementPC(){
		pc++;
		PC.setValue(pc);
	}

}