/*
	Operator.java
	- a class for the operator
*/
package operator;

public abstract class Operator{
	private String name;
	private int clockCycle;
	private int remCountCLockCycles;

	public Operator (String name, int clockCycle){
		//System.out.println("Operator added!");
		this.name = name;
		this.clockCycle = clockCycle;
	} 

	public String getName(){
		return name;
	}

	public int getClockCycle(){
		return clockCycle;
	}

	public int getRemCountClockCycle(){
		return remCountCLockCycles;
	}

	public String toString(){
		return getName() + " " + getClockCycle() + " " + getRemCountClockCycle();
	}

	public abstract void solve();
}