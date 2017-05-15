
import java.util.*;
import java.io.*;


public class InternalMemory{

	public static ArrayList<Register> registers = new ArrayList<Register>();
	public static Register r, pc, mar, mbr, of, nf, zf;
	private int noOfInstruction;


	public InternalMemory(String[][] instruction){

		initRegisters();				//to initialize the registers
		//viewRegisters();				//to view or show the registers

		//get the total number of instructions to be executed
		noOfInstruction = instruction.length;
		//assign values to the registers
		//print all element in the inst 2Darray
		for(int i=0; i < noOfInstruction; i++){
			for(int j=0; j < 3; j++){
				System.out.println(instruction[i][j]);
			}
			System.out.println("\n");
		}

	} 

	public static void initRegisters(){

		for(int i = 0; i < 32; i++){
			r = new Register("R"+i, 0, false);
			registers.add(r);
		}

		//Program Counter (PC)
		pc = new Register("PC", 0, false);
		registers.add(pc);

		//Memory Address Register (MAR)
		mar = new Register("MAR", 0, false);
		registers.add(mar);

		//MBR (Memory Buffer Register)
		mbr = new Register("MBR", 0, false);
		registers.add(mbr);

		//Overflow Flag (OF)
		of = new Register("OF", 0, false);
		registers.add(of);

		//Negative Flag (NF)
		nf = new Register("NF", 0, false);
		registers.add(nf);

		//Zero Flag (ZF).
		zf = new Register("ZF", 0, false);
		registers.add(zf);
	}

	public static void viewRegisters(){
		//print all element in the intructions arraylist
		System.out.println("\n");
		for(int i=0; i < registers.size(); i++){
			System.out.println(registers.get(i));
		}
	}

}