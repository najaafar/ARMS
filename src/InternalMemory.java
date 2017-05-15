package src;


import java.util.*;
import java.io.*;


public class InternalMemory{

	public static ArrayList<Register> registers = new ArrayList<Register>();
	public static Register r, PC, MAR, MBR, OF, NF, ZF;
	private int noOfInstruction;
	public static int pc = 0;


	public InternalMemory(String[][] instruction){

		initRegisters();				//to initialize the registers
		//viewRegisters();				//to view or show the registers

		//get the total number of instructions to be executed
		noOfInstruction = instruction.length;

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
			registers.add(r);
		}

		//Program Counter (PC) - holds the address of the next instruction 
		PC = new Register("PC");
		registers.add(PC);

		//Memory Address Register (MAR) - holds the address of the current instruction
		MAR = new Register("MAR");
		registers.add(MAR);

		//MBR (Memory Buffer Register) - hold the data of the current instruction
		MBR = new Register("MBR");
		registers.add(MBR);

		//Overflow Flag (OF) - 1 if value exceed -99 or 99, 0 if otherwise
		OF = new Register("OF");
		registers.add(OF);

		//Negative Flag (NF) - 1 if negative, 0 if positive
		NF = new Register("NF");
		registers.add(NF);

		//Zero Flag (ZF) - 1 if zero result, 0 if non-zero result
		ZF = new Register("ZF");
		registers.add(ZF);
	}

	public static void viewRegisters(){
		//print all element in the intructions arraylist
		System.out.println("\n");
		for(int i=0; i < registers.size(); i++){
			System.out.println(registers.get(i));
		}
	}

	public void incrementPC(){
		pc++;
		PC.setValue(pc);
	}

}